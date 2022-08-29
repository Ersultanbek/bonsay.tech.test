package tech.bonsay.covidstat.statistics.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticCasesData {

    private Long confirmed;
    private Long recovered;
    private Long deaths;
    private String country;
    private Long population;
    @JsonProperty("sq_km_area")
    private Long sqKmArea;
    @JsonProperty("life_expectancy")
    private BigDecimal lifeExpectancy;
    @JsonProperty("elevation_in_meters")
    private Long elevationInMeters;
    private String continent;
    private String abbreviation;
    private String location;
    private String iso;
    private String capital_city;
}
