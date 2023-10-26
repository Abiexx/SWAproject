package book.Service;


import book.ExceptionHandler.BookNotFoundException;
import book.Service.dto.BookDto;

public interface IBookCommandService {

    public BookDto addBook(BookDto bookDTO);
    public BookDto updateBook(long isbn, BookDto bookDTO) throws BookNotFoundException;
    public BookDto deleteBook(long isbn);

}
