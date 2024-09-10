package dmitr.weather.validator;

import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeValidator extends Validator<LocalDateTime> {

    @Override
    public void validate(LocalDateTime value) {
        if (value == null)
            throw new ValidationException("Invalid dateTime!");
    }
}
