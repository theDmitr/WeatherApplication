package dmitr.weather.validator;

import dmitr.weather.configuration.message.MessageProvider;
import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class LocalDateValidator extends Validator<LocalDate> {

    private final MessageProvider messageProvider;

    @Override
    public void validate(LocalDate value) {
        if (value == null)
            throw new ValidationException(messageProvider.get("validation.invalid.date"));
    }
}
