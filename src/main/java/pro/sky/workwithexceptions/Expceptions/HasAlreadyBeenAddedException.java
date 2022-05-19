package pro.sky.workwithexceptions.Expceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HasAlreadyBeenAddedException extends RuntimeException{
    public HasAlreadyBeenAddedException(String message) {
        super(message);
    }
}

