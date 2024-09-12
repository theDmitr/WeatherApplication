package dmitr.weather.service.impl;

import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.dto.WeatherPartsSearchDto;
import dmitr.weather.entity.WeatherPart;
import dmitr.weather.exception.extended.WeatherPartExistsException;
import dmitr.weather.repository.WeatherPartRepository;
import dmitr.weather.service.face.WeatherPartService;
import dmitr.weather.validator.SearchWeatherPartsDtoValidator;
import dmitr.weather.validator.WeatherPartDtoValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherPartServiceImpl implements WeatherPartService {

    private final WeatherPartRepository weatherPartRepository;
    private final WeatherPartDtoValidator weatherPartDtoValidator;
    private final ModelMapper modelMapper;
    private final SearchWeatherPartsDtoValidator searchWeatherPartsDtoValidator;

    @Override
    public List<WeatherPartDto> getWeatherParts(WeatherPartsSearchDto weatherPartsSearchDto) {
        searchWeatherPartsDtoValidator.validate(weatherPartsSearchDto);

        if (weatherPartsSearchDto.getDateSecond() == null) {
            weatherPartsSearchDto.setDateSecond(weatherPartsSearchDto.getDateFirst());
        }

        return weatherPartRepository.findAllByDateRangeAndLocation(
                        weatherPartsSearchDto.getDateFirst(),
                        weatherPartsSearchDto.getDateSecond(),
                        weatherPartsSearchDto.getLocation())
                .stream()
                .map(wp -> modelMapper.map(wp, WeatherPartDto.class))
                .toList();
    }

    @Override
    public void createWeatherPart(WeatherPartDto weatherPartDto) {
        weatherPartDtoValidator.validate(weatherPartDto);

        if (weatherPartRepository.findByDateTimeAndLocation(weatherPartDto.getDateTime(),
                weatherPartDto.getLocation()).isPresent()) {
            throw new WeatherPartExistsException();
        }

        WeatherPart toSave = modelMapper.map(weatherPartDto, WeatherPart.class);
        weatherPartRepository.save(toSave);
    }
}
