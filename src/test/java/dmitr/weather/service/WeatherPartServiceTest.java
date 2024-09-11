package dmitr.weather.service;

import dmitr.weather.WeatherApplication;
import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.enums.WeatherType;
import dmitr.weather.enums.WindDirection;
import dmitr.weather.service.face.WeatherPartService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WeatherApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class WeatherPartServiceTest {

    private final WeatherPartService weatherPartService;

    private WeatherPartDto newWeatherPartDto;

    @BeforeAll
    public void init() {
        newWeatherPartDto = new WeatherPartDto(LocalDateTime.now(), 15.0f, 3.0f,
                WindDirection.NORTH, 1.0f, WeatherType.CLOUDY);
    }

    @Test
    public void createWeatherPart() {
        weatherPartService.createWeatherPart(newWeatherPartDto);
    }

    @Test
    public void getWeatherParts() {
        LocalDate date = LocalDate.from(newWeatherPartDto.getDateTime());
        weatherPartService.getWeatherParts(date);
    }
}