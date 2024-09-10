package dmitr.weather.exception.handler;

import dmitr.weather.exception.extended.WeatherPartExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class WeatherPartExistsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WeatherPartExistsException.class)
    public ResponseEntity<Object> handleWeatherPartExistsException(WeatherPartExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Weather part for this date already exists!");
    }
}
