package bookQueries.service;


import bookQueries.ExceptionHandler.BookNotFoundException;
import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;


public interface IBookQueryService {
     BookDto getBook(long isbn) throws BookNotFoundException;
     BookDtos getBooks();

}
