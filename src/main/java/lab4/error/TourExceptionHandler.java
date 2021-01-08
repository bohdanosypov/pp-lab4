package lab4.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TourExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TourException.class)
    protected ResponseEntity<ErrorData> handleEntityNotFound(TourException ex) {
        return new ResponseEntity<>(new ErrorData(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
