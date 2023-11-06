package bookQueries.service;

import bookQueries.ExceptionHandler.BookNotFoundException;
import bookQueries.service.Adapter.BookAdapter;
import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;
import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class BookQueryServiceImpl implements IBookQueryService {

    @Autowired
    private BookQueryDAO bookQueryDAO;

    @Autowired
    Environment environment;

    public BookDto getBook(long isbn) throws BookNotFoundException {
        Optional<Book> optionalBook = bookQueryDAO.findById(isbn);
        Book book;
        if(optionalBook.isPresent()) {
            book = optionalBook.get();
        } else {
            throw new BookNotFoundException(environment.getProperty("book.not.found") +" :- " +isbn);
        }
        return BookAdapter.getBookDtoFromBook(book);
    }

    public BookDtos getBooks(){
        BookDtos bookDTOs = BookAdapter.getBookDtosFromBooks(bookQueryDAO.findAll());
        return bookDTOs;
    }
}
