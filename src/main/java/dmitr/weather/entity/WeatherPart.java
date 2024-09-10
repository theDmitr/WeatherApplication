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
    private Float temperature;

    @Column(nullable = false)
    private Float windSpeed;

    @Column(nullable = false)
    private WindDirection windDirection;

    @Column(nullable = false)
    private Float pressure;

    @Column(nullable = false)
    private WeatherType weatherType;
}
