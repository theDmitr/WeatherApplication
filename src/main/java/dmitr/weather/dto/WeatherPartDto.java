package dmitr.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dmitr.weather.enums.WeatherType;
import dmitr.weather.enums.WindDirection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherPartDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private Float temperature;
    private Float windSpeed;
    private WindDirection windDirection;
    private Float pressure;
    private WeatherType weatherType;
    private String location;
}
