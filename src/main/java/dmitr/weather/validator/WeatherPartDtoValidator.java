package dmitr.weather.validator;

import dmitr.weather.configuration.message.MessageProvider;
import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WeatherPartDtoValidator extends Validator<WeatherPartDto> {

    private final LocalDateTimeValidator localDateTimeValidator;
    private final MessageProvider messageProvider;

    @Override
    public void validate(WeatherPartDto value) {
        localDateTimeValidator.validate(value.getDateTime());

        if (value.getLocation() == null || value.getLocation().isEmpty()) {
            throw new ValidationException(messageProvider.get("validation.invalid.location"));
        }
    }
}
