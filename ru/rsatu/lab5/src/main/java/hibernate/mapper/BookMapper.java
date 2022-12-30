package hibernate.mapper;

import hibernate.dto.BookDTO;
import hibernate.entity.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import hibernate.entity.Author;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Mapper(componentModel = "cdi")
public abstract class BookMapper {

    @Inject
    EntityManager entityManager;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "authorId", source = "author.id")
    public abstract BookDTO toBookDto(Book book);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract Book toBook(BookDTO bookDto);

    @AfterMapping
    public void afterBookMapping(@MappingTarget Book result, BookDTO bookDto) {
        Author author = entityManager.getReference(Author.class, bookDto.getAuthorId());
        result.setAuthor(author);
    }

}
