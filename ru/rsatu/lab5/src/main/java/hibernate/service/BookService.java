package hibernate.service;

import hibernate.dto.BookDTO;
import hibernate.mapper.BookMapper;
import hibernate.repository.BookRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    BookMapper bookMapper;

    @Inject
    BookRepository bookRepository;

    public List<BookDTO> loadBookList() {
        return bookRepository.loadBooks().stream().map(bookMapper::toBookDto).toList();
    }

    public List<BookDTO> getBooksByAuthor(Long authorId) {
        return bookRepository.getBooksByAuthor(authorId).stream().map(bookMapper::toBookDto).toList();
    }

    public BookDTO saveBook(BookDTO bookDto) {
        return bookMapper.toBookDto(bookRepository.saveBook(bookDto));
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteBook(bookId);
    }
}
