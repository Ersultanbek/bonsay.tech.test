package tech.bonsay.covidstat.statistics.models.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class StatisticHistoryData {
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
    @JsonProperty("capital_city")
    private String capitalCity;
    private Map<LocalDate,Long> dates = new HashMap<>();

}
