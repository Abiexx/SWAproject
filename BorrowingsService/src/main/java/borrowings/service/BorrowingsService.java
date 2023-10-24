package borrowings.service;


import borrowings.service.Dto.BorrowStartingDTO;
import borrowings.service.Dto.BorrowingDto;
import borrowings.service.Dto.BorrowingsDto;

public interface BorrowingsService {

    public BorrowingDto getBorrowing(long borrowingNumber);

    public BorrowingsDto getBorrowings();

    public BorrowingDto addBorrowing( long customerNumber,long isbn, BorrowStartingDTO borrowingDto);

    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowStartingDTO borrowingDto); // Miki


    public BorrowingDto deleteBorrowing(long borrowingNumber);



}
