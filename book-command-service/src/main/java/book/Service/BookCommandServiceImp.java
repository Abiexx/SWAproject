package book.Service;


import book.ExceptionHandler.BookNotFoundException;
import book.Service.dto.BookDto;
import book.domain.Book;
import book.Repository.IBookDAO;
import book.Service.adapter.BookAddapter;

import book.integration.KafkaSender;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PropertySource("classpath:ValidationMessages.properties")
@Slf4j
public class BookCommandServiceImp implements IBookCommandService {

    @Autowired
    private IBookDAO bookDAO;

    @Autowired
    private KafkaSender kafkaSender;
    @Autowired
    private Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(BookCommandServiceImp.class);
    @Override
    public BookDto addBook(BookDto bookDTO) {
        Book book = BookAddapter.getBookFromBookDTO(bookDTO);
        bookDAO.save(book);
        kafkaSender.send("addbooktopic",bookDTO);
        return bookDTO;

    }

    @Override
    public BookDto updateBook(long isbn, BookDto bookDTO) throws BookNotFoundException{

        Optional<Book> optionalBook = bookDAO.findById(isbn);
        Book book = null;
        if (optionalBook.isPresent()){
             book = optionalBook.get();
            bookDAO.save(book);
            kafkaSender.send("updatebooktopic",bookDTO);

        }else {
           throw new BookNotFoundException(environment.getProperty("book.not.found") +" :- " +isbn);
        }
        return BookAddapter.getBookDTOFromBook(book);
    }


    @Override
    public BookDto deleteBook(long isbn) {
        Book book = bookDAO.findById(isbn).get();
        BookDto bookDTO = BookAddapter.getBookDTOFromBook(book);
        bookDAO.deleteById(isbn);
        kafkaSender.send("deletebooktopic",bookDTO);
        return bookDTO;
    }
}
