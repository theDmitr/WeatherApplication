package dmitr.weather.entity;

import dmitr.weather.enums.WeatherType;
import dmitr.weather.enums.WindDirection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weather_parts")
public class WeatherPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String location;

    private Float temperature;
    private Float windSpeed;
    private WindDirection windDirection;
    private Float pressure;
    private WeatherType weatherType;
}
