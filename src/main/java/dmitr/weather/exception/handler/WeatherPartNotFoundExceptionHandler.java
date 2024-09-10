package dmitr.weather.exception.handler;

import dmitr.weather.exception.extended.WeatherPartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class WeatherPartNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WeatherPartNotFoundException.class)
    public ResponseEntity<String> handleWeatherPart(WeatherPartNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Weather parts not found for this date range!");
    }
}
