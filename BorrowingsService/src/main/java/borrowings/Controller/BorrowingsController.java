package borrowings.Controller;

import borrowings.service.BorrowingsService;

import borrowings.service.Dto.BorrowStartingDTO;
import borrowings.service.Dto.BorrowingDto;
import borrowings.service.Dto.BorrowingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/borrowings"})
public class BorrowingsController {

    @Autowired
    BorrowingsService borrowingsService;


    @GetMapping("/{borrowingNumber}")
  public ResponseEntity<BorrowingDto> getBorrowing(@PathVariable long borrowingNumber){
       BorrowingDto borrowingDto = borrowingsService.getBorrowing(borrowingNumber);
        return  new ResponseEntity<>(borrowingDto, HttpStatus.OK);
  }

    @GetMapping
    public ResponseEntity<BorrowingsDto> getBorrowings(){
        BorrowingsDto borrowingsDto = borrowingsService.getBorrowings();
    return  new ResponseEntity<>(borrowingsDto, HttpStatus.OK);
}


    @PostMapping("/{customerNumber}/{isbn}")
    public ResponseEntity<BorrowingDto> addBorrowing(@PathVariable long customerNumber, @PathVariable long isbn, @RequestBody BorrowStartingDTO borrowingDto){
        BorrowingDto borrowingDto1 = borrowingsService.addBorrowing(customerNumber,isbn, borrowingDto);
        return new ResponseEntity<>(borrowingDto1, HttpStatus.OK);
    }

    @PutMapping("/borrowingNumber")
    public ResponseEntity<BorrowingDto> updateBorrowing(@PathVariable long borrowingNumber, @RequestBody BorrowStartingDTO borrowingDto){
        BorrowingDto borrowingDto1 = borrowingsService.updateBorrowing(borrowingNumber, borrowingDto);
        return new ResponseEntity<>(borrowingDto1, HttpStatus.OK);
    }

    //abi
    @DeleteMapping("/{borrowingNumber}")
    public ResponseEntity<BorrowingDto> deleteBurrowing(@PathVariable long borrowingNumber){
        BorrowingDto borrowingDto = borrowingsService.deleteBorrowing(borrowingNumber);
        return new ResponseEntity<>(borrowingDto, HttpStatus.OK);

    }
}
