package hibernate.resource;

import hibernate.dto.AuthorDTO;
import hibernate.service.AuthorService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books/api/v1")
public class AuthorResource {
    @Inject
    AuthorService authorService;

    @GET
    @Path("/author")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/author")
    public AuthorDTO saveAuthor(AuthorDTO authorDto) {
        return authorService.saveAuthor(authorDto);
    }

    @DELETE
    @Path("/author/{authorId}")
    public void deleteAuthor(@PathParam("authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }
}
