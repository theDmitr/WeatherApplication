package dmitr.weather.validator;

import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocalDateValidator extends Validator<LocalDate> {

    @Override
    public void validate(LocalDate value) {
        if (value == null)
            throw new ValidationException("Invalid date!");
    }
}
