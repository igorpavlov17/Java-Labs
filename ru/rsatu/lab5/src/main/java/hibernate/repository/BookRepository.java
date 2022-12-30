package hibernate.repository;

import hibernate.dto.BookDTO;
import hibernate.entity.Book;
import hibernate.mapper.BookMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BookRepository {
    @Inject
    EntityManager entityManager;

    @Inject
    BookMapper bookMapper;

    public List<Book> loadBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return entityManager.createQuery("select b from Book b where author.id = :authorId", Book.class)
                .setParameter("authorId", authorId).getResultList();
    }

    @Transactional
    public Book saveBook(BookDTO bookDto) {
        Book book = bookMapper.toBook(bookDto);
        if (book.getId() != null) entityManager.merge(book);
        else entityManager.persist(book);
        entityManager.flush();
        return book;
    }

    @Transactional
    public void deleteBook(Long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
    }
}
