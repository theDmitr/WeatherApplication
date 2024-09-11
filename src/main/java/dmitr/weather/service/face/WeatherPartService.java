package dmitr.weather.service.face;

import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.dto.WeatherPartsSearchDto;

import java.util.List;

public interface WeatherPartService {

    List<WeatherPartDto> getWeatherParts(WeatherPartsSearchDto weatherPartsSearchDto);
    void createWeatherPart(WeatherPartDto weatherPart);
}
