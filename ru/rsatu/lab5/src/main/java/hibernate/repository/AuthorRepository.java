package hibernate.repository;

import hibernate.dto.AuthorDTO;
import hibernate.mapper.AuthorMapper;
import hibernate.entity.Author;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorRepository {
    @Inject
    EntityManager entityManager;

    @Inject
    AuthorMapper authorMapper;

    public List<Author> getAuthors() {
        return entityManager.createQuery("select a from Author a", Author.class)
                .getResultList();
    }

    @Transactional
    public Author saveAuthor(AuthorDTO authorDto) {
        Author author = authorMapper.toAuthor(authorDto);
        if (author.getId() != null) {
            entityManager.merge(author);
        } else {
            entityManager.persist(author);
        }
        entityManager.flush();
        return author;
    }

    @Transactional
    public void deleteAuthor(Long authorId) {
        Author author = entityManager.find(Author.class, authorId);
        entityManager.remove(author);
    }
}
