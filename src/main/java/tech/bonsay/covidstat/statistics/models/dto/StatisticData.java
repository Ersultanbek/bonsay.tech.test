package tech.bonsay.covidstat.statistics.models.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class StatisticData {
    private Long confirmed;
    private Long recovered;
    private Long deaths;
    private BigDecimal vaccinationLevel;
    private Long newConfirmedCases;
}
