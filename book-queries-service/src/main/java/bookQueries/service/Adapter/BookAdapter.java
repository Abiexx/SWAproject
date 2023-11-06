package bookQueries.service.Adapter;

import bookQueries.domain.Book;
import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter {

    public static Book getBookFromBookDto(BookDto bookDTO){
        return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getDescription(), bookDTO.getReviews());
    }
    public static BookDto getBookDtoFromBook(Book book){
        return new BookDto(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getReviews());
    }
    public static BookDtos getBookDtosFromBooks(List<Book> books){
        List<BookDto> listBooksDTO = new ArrayList<>();
        for(Book book: books){
            listBooksDTO.add(getBookDtoFromBook(book));
        }
        BookDtos bookDTOs = new BookDtos(listBooksDTO);
        return bookDTOs;
    }
}
