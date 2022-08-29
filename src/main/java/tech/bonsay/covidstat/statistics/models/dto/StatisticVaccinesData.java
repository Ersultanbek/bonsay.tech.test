package tech.bonsay.covidstat.statistics.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticVaccinesData {
    private Long administered;
    @JsonProperty("people_vaccinated")
    private BigDecimal peopleVaccinated;
    @JsonProperty("people_partially_vaccinated")
    private Long peoplePartiallyVaccinated;
    private String country;
    private BigDecimal population;
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
    private String updated;
}
