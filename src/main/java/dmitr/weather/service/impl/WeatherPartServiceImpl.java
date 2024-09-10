package dmitr.weather.service.impl;

import dmitr.weather.dto.WeatherPartDto;
import dmitr.weather.entity.WeatherPart;
import dmitr.weather.exception.extended.WeatherPartExistsException;
import dmitr.weather.exception.extended.WeatherPartNotFoundException;
import dmitr.weather.repository.WeatherPartRepository;
import dmitr.weather.service.face.WeatherPartService;
import dmitr.weather.validator.LocalDateValidator;
import dmitr.weather.validator.WeatherPartDtoValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherPartServiceImpl implements WeatherPartService {

    private final WeatherPartRepository weatherPartRepository;
    private final LocalDateValidator localDateValidator;
    private final WeatherPartDtoValidator weatherPartDtoValidator;
    private final ModelMapper modelMapper;

    @Override
    public List<WeatherPartDto> getWeatherParts(LocalDate dateTime) {
        localDateValidator.validate(dateTime);

        List<WeatherPartDto> weatherParts = weatherPartRepository.findByDate(dateTime)
                .stream()
                .map(wp -> modelMapper.map(wp, WeatherPartDto.class))
                .toList();

        if (weatherParts.isEmpty()) {
            throw new WeatherPartNotFoundException();
        }

        return weatherParts;
    }

    @Override
    public List<WeatherPartDto> getWeatherParts(LocalDate dateFrom, LocalDate dateTo) {
        localDateValidator.validate(dateFrom, dateTo);

        List<WeatherPartDto> weatherParts = weatherPartRepository.findAllByDateRange(dateFrom, dateTo)
                .stream()
                .map(wp -> modelMapper.map(wp, WeatherPartDto.class))
                .toList();

        if (weatherParts.isEmpty()) {
            throw new WeatherPartNotFoundException();
        }

        return weatherParts;
    }

    @Override
    public void createWeatherPart(WeatherPartDto weatherPartDto) {
        weatherPartDtoValidator.validate(weatherPartDto);

        if (weatherPartRepository.findByDateTime(weatherPartDto.getDateTime()).isPresent()) {
            throw new WeatherPartExistsException();
        }

        WeatherPart toSave = modelMapper.map(weatherPartDto, WeatherPart.class);
        weatherPartRepository.save(toSave);
    }
}
