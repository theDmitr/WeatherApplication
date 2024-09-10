package dmitr.weather.repository;

import dmitr.weather.entity.WeatherPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherPartRepository extends JpaRepository<WeatherPart, Long> {

    Optional<WeatherPart> findByDateTime(LocalDateTime dateTime);

    @Query(value = "SELECT * FROM weather_parts WHERE CAST(weather_parts.date_time AS DATE) = :date", nativeQuery = true)
    List<WeatherPart> findByDate(@Param("date") LocalDate date);

    @Query(value = "SELECT * FROM weather_parts WHERE date_time BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    List<WeatherPart> findAllByDateRange(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
