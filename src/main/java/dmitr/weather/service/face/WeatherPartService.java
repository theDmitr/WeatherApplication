package dmitr.weather.service.face;

import dmitr.weather.dto.WeatherPartsSearchDto;
import dmitr.weather.dto.WeatherPartDto;

import java.util.List;

public interface WeatherPartService {

    List<WeatherPartDto> getWeatherParts(WeatherPartsSearchDto weatherPartsSearchDto);
    void createWeatherPart(WeatherPartDto weatherPart);
}
