package hibernate.mapper;

import hibernate.dto.AuthorDTO;
import hibernate.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public abstract class AuthorMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "nickName", source = "nickName")
    public abstract AuthorDTO toAuthorDto(Author author);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "nickName", source = "nickName")
    public abstract Author toAuthor(AuthorDTO authorDto);
}
