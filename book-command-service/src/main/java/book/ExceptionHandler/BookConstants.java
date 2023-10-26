package book.ExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


public enum BookConstants {

    BOOK_NOT_FOUND("book.not.found"),
    GENERAL_EXCEPTION_MESSAGE("general.exception");

    BookConstants(String s) {
    }
}
