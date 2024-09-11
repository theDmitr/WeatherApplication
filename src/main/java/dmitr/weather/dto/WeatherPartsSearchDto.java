package dmitr.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherPartsSearchDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFirst;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSecond;

    private String location;

    public WeatherPartsSearchDto(LocalDate dateFirst, String location) {
        this.dateFirst = dateFirst;
        this.location = location;
    }
}

