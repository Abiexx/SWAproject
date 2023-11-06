package bookQueries.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
    private int errorCode;
    private String message;
}
