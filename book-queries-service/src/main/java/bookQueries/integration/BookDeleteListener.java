package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.Adapter.BookAdapter;
import bookQueries.service.Dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookDeleteListener {
    @Autowired
    BookQueryDAO bookQueryDAO;


    @KafkaListener(topics = {"deletebooktopic"}, groupId = "gid2")
    public void receive(@Payload String bookDtoString) {

        ObjectMapper objectMapper = new ObjectMapper();

      log.info("deletebooktopic received :--- "+bookDtoString);

        BookDto bookDto;
        try {
            bookDto = objectMapper.readValue(bookDtoString , BookDto.class);
            Book book = BookAdapter.getBookFromBookDto(bookDto);
            bookQueryDAO.delete(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
