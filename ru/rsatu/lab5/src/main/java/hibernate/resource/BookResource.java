package hibernate.resource;

import hibernate.dto.BookDTO;
import hibernate.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books/api/v1")
public class BookResource {
    @Inject
    BookService bookService;

    @GET
    @Path("/loadBookList")
    public List<BookDTO> loadBookList() {
        return bookService.loadBookList();
    }

    @GET
    @Path("/book/author/{authorId}")
    public List<BookDTO> getBooksByAuthor(@PathParam("authorId") Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

    @DELETE
    @Path("/book/{bookId}")
    public void deleteBook(@PathParam("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveBook")
    public BookDTO saveBook(BookDTO bookDto) {
        return bookService.saveBook(bookDto);
    }
}
