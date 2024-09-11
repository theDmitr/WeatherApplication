package dmitr.weather.controller;

import dmitr.weather.dto.WeatherPartsSearchDto;
import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.service.face.WeatherPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weatherPart")
public class WeatherPartRestController {

    private final WeatherPartService weatherPartService;

    @GetMapping
    public List<WeatherPartDto> getWeatherPart(@RequestBody WeatherPartsSearchDto weatherPartsSearchDto) {
        return weatherPartService.getWeatherParts(weatherPartsSearchDto);
    }

    @PostMapping
    public void addWeatherPart(@RequestBody WeatherPartDto weatherPartDto) {
        weatherPartService.createWeatherPart(weatherPartDto);
    }
}
