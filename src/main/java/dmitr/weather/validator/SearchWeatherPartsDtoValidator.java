package dmitr.weather.validator;

import dmitr.weather.configuration.message.MessageProvider;
import dmitr.weather.dto.WeatherPartsSearchDto;
import dmitr.weather.exception.extended.ValidationException;
import dmitr.weather.validator.face.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SearchWeatherPartsDtoValidator extends Validator<WeatherPartsSearchDto> {

    private final LocalDateValidator localDateValidator;
    private final MessageProvider messageProvider;

    @Override
    public void validate(WeatherPartsSearchDto value) {
        localDateValidator.validate(value.getDateFirst());

        if (value.getLocation() == null || value.getLocation().isEmpty()) {
            throw new ValidationException(messageProvider.get("validation.invalid.location"));
        }
    }
}
