package dmitr.weather.validator;

import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.validator.face.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WeatherPartDtoValidator extends Validator<WeatherPartDto> {

    private final LocalDateTimeValidator localDateTimeValidator;

    @Override
    public void validate(WeatherPartDto value) {
        localDateTimeValidator.validate(value.getDateTime());
    }
}
