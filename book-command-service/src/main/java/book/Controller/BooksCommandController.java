package book.Controller;

import book.ExceptionHandler.BookNotFoundException;
import book.Service.IBookCommandService;
import book.Service.dto.BookDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/books")
@OpenAPIDefinition(info = @Info(title = "Book API",version = "3.0",description = "Book Information"))
public class BooksCommandController {

       @Autowired
        private IBookCommandService iBookCommandService;

        @PostMapping
        public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        iBookCommandService.addBook(bookDto);
        return new ResponseEntity<>( bookDto, HttpStatus.CREATED);
    }
        @PutMapping("/{isbn}")
        public ResponseEntity<BookDto> updateBook(@PathVariable long isbn, @RequestBody BookDto bookDto) throws BookNotFoundException {
        iBookCommandService.updateBook(isbn,bookDto);
        return new ResponseEntity<>( bookDto, HttpStatus.OK);
    }


        @DeleteMapping("/{isbn}")
        public ResponseEntity<BookDto> deleteBook(@PathVariable long isbn){
        BookDto bookDto = iBookCommandService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}
