package dmitr.weather.exception.handler;

import dmitr.weather.configuration.message.MessageProvider;
import dmitr.weather.exception.extended.WeatherPartExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequiredArgsConstructor
@RestControllerAdvice
public class WeatherPartExistsExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageProvider messageProvider;

    @ExceptionHandler(WeatherPartExistsException.class)
    public ResponseEntity<Object> handleWeatherPartExistsException(WeatherPartExistsException ignored) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(messageProvider.get("weatherPart.exists"));
    }
}
