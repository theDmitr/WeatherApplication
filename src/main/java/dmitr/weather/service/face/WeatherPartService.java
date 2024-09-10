package dmitr.weather.service.face;

import dmitr.weather.dto.WeatherPartDto;

import java.time.LocalDate;
import java.util.List;

public interface WeatherPartService {

    List<WeatherPartDto> getWeatherParts(LocalDate date);

    List<WeatherPartDto> getWeatherParts(LocalDate dateFrom, LocalDate dateTo);

    void createWeatherPart(WeatherPartDto weatherPart);
}
