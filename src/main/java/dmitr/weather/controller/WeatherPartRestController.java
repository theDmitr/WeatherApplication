package dmitr.weather.controller;

import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.service.face.WeatherPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weatherPart")
public class WeatherPartRestController {

    private final WeatherPartService weatherPartService;

    @GetMapping("/{date}")
    public List<WeatherPartDto> getWeatherPart(@PathVariable("date") LocalDate date) {
        return weatherPartService.getWeatherParts(date);
    }

    @GetMapping("/{dateFrom}/{dateTo}")
    public List<WeatherPartDto> getWeatherParts(@PathVariable("dateFrom") LocalDate dateFrom,
                                                @PathVariable("dateTo") LocalDate dateTo) {
        return weatherPartService.getWeatherParts(dateFrom, dateTo);
    }

    @PostMapping
    public void addWeatherPart(@RequestBody WeatherPartDto weatherPartDto) {
        weatherPartService.createWeatherPart(weatherPartDto);
    }
}
