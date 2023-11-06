package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.Adapter.BookAdapter;
import bookQueries.service.Dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;



@Service
public class BookAddListener {
    @Autowired
    BookQueryDAO bookQueryDAO;

    private Logger logger = LoggerFactory.getLogger(BookAddListener.class);

    @KafkaListener(topics = {"addbooktopic"}, groupId = "gid")
    public void receive(@Payload String bookDtoString) {
        ObjectMapper objectMapper = new ObjectMapper();

        logger.info("addbooktopic received :--- "+bookDtoString);

        BookDto bookDto;
        try {
            bookDto = objectMapper.readValue(bookDtoString , BookDto.class);
            Book book = BookAdapter.getBookFromBookDto(bookDto);
            bookQueryDAO.save(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

