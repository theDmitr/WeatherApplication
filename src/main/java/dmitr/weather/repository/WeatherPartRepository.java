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

    Optional<WeatherPart> findByDateTimeAndLocation(LocalDateTime dateTime,
                                                    String location);

    @Query(value = "SELECT * FROM weather_parts " +
            "WHERE CAST(date_time AS DATE) BETWEEN :dateFrom AND :dateTo " +
            "AND location = :location", nativeQuery = true)
    List<WeatherPart> findAllByDateRangeAndLocation(@Param("dateFrom") LocalDate dateFrom,
                                                    @Param("dateTo") LocalDate dateTo,
                                                    @Param("location") String location);
}
