package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.Dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookUpdateListener {
    @Autowired
    BookQueryDAO bookQueryDAO;



    @KafkaListener(topics = {"updatebooktopic"}, groupId = "gid4")
    public void receive(@Payload String bookDtoString) {
//       log.info("updatebooktopic received :---- ");
//        Book book = BookAdapter.getBookFromBookDto(bookDTO);
//        book.setIsbn(bookDTO.getIsbn());
//        book.setTitle(bookDTO.getTitle());
//        book.setDescription(bookDTO.getDescription());
//        book.setAuthor(bookDTO.getAuthor());
//        bookQueryDAO.save(book);
//    }

        ObjectMapper objectMapper = new ObjectMapper();

        log.info("updatebooktopic received :--- " + bookDtoString);

        BookDto bookDto;
        try {
            bookDto = objectMapper.readValue(bookDtoString, BookDto.class);
            Optional<Book> optBook = bookQueryDAO.findById(bookDto.getIsbn());
            if (optBook.isPresent()) {
                Book book = optBook.get();
                book.setIsbn(bookDto.getIsbn());
                book.setTitle(bookDto.getTitle());
                book.setDescription(bookDto.getDescription());
                book.setAuthor(bookDto.getAuthor());
                bookQueryDAO.save(book);
            } else {
                throw new RuntimeException("Book Not Found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
