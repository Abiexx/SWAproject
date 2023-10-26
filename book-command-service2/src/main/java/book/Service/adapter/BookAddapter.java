package book.Service.adapter;

import book.Service.dto.BookDto;
import book.Service.dto.BookDtos;
import book.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAddapter {

    public static Book getBookFromBookDTO(BookDto bookDTO){
        return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getAuthor(),bookDTO.getReviews());
    }
    public static BookDto getBookDTOFromBook(Book book){
        return new BookDto(book.getIsbn(), book.getTitle(), book.getDescription(), book.getAuthor(), book.getReviews());
    }

    public static BookDtos getBooksDTOFromBooks(List<Book> books){
        List<BookDto> listBookDtos = new ArrayList<>();
        for(Book book: books){
            listBookDtos.add(new BookDto(book.getIsbn(),book.getTitle(),book.getDescription(),book.getAuthor(), book.getReviews()));
        }
        BookDtos booksDto = new BookDtos(listBookDtos);
        return booksDto;
    }


}
