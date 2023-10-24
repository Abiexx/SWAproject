package book.Service.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookDtos {
    private List<BookDto> bookDtos;
}
