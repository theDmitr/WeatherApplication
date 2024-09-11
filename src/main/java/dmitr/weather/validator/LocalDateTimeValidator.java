package dmitr.weather.validator;

import dmitr.weather.configuration.message.MessageProvider;
import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class LocalDateTimeValidator extends Validator<LocalDateTime> {

    private final MessageProvider messageProvider;

    @Override
    public void validate(LocalDateTime value) {
        if (value == null)
            throw new ValidationException(messageProvider.get("validation.invalid.dateTime"));
    }
}
