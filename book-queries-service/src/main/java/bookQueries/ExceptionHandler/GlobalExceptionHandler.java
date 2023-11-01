package book.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> bookNotFoundExceptionHandler(BookNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage();
          errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
            errorMessage.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> generalExceptionHandler(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorMessage.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
