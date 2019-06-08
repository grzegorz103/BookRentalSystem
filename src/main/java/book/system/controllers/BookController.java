package book.system.controllers;

import book.system.dto.BookDTO;
import book.system.models.Book;
import book.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/book")
@CrossOrigin
public class BookController
{
        private final BookService bookService;

        @Autowired
        public BookController ( BookService bookService )
        {
                this.bookService = bookService;
        }

        @GetMapping
        @Secured ({"ROLE_ADMIN", "ROLE_USER"})
        public List<BookDTO> findAll ()
        {
                return bookService.findAll();
        }

        @PostMapping
        @Secured ("ROLE_ADMIN")
        public BookDTO create ( @Valid @RequestBody BookDTO bookDTO )
        {
                return bookService.create( bookDTO );
        }

        @DeleteMapping ("/{id}")
        @Secured ("ROLE_ADMIN")
        public boolean deleteById ( @PathVariable Long id )
        {
                return bookService.deleteById( id );
        }

        @DeleteMapping
        @Secured ("ROLE_ADMIN")
        public boolean delete ( @RequestBody BookDTO book )
        {
                return bookService.delete( book );
        }
}
