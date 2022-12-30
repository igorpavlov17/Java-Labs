package hibernate.service;

import hibernate.dto.AuthorDTO;
import hibernate.repository.AuthorRepository;
import hibernate.mapper.AuthorMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorMapper authorMapper;

    @Inject
    AuthorRepository authorRepository;

    public List<AuthorDTO> getAuthors() {
        return authorRepository.getAuthors().stream().map(authorMapper::toAuthorDto).toList();
    }

    public AuthorDTO saveAuthor(AuthorDTO authorDto) {
        return authorMapper.toAuthorDto(authorRepository.saveAuthor(authorDto));
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteAuthor(authorId);
    }
}
