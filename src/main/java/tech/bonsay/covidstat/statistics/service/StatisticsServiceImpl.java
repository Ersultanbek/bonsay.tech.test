package tech.bonsay.covidstat.statistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bonsay.covidstat.feign.client.CovidApiFeignClient;
import tech.bonsay.covidstat.statistics.models.dto.StatisticCasesData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticHistoryData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticVaccinesData;
import tech.bonsay.covidstat.statistics.models.enums.StatisticHistoryStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final CovidApiFeignClient covidApiFeignClient;

    /**
     * @param ab - Abbreviation of country, Example: KZ, FR etc
     * @param country - Country name, Example: France
     * @return the information of cases for the current moment:
     *   confirmed
     *   recovered
     *   deaths
     *   vaccinated level in % of total population
     *   based on historical data:
             * new confirmed cases since last data available
     * @see StatisticData
     * */
    @Override
    public StatisticData getStatistic(String ab, String country) {

        StatisticCasesData casesData = covidApiFeignClient.getCases(ab,country).getData();

        StatisticHistoryData confirmedHistoryData = covidApiFeignClient.getHistory(ab,country, StatisticHistoryStatus.Confirmed).getData();
        Long prevDayConfirmed = confirmedHistoryData.getDates().get(LocalDate.now().minusDays(1));
        StatisticVaccinesData vaccinesData = covidApiFeignClient.getVaccines(ab,country).getData();

        return StatisticData.builder()
                .confirmed(casesData.getConfirmed())
                .recovered(casesData.getRecovered())
                .deaths(casesData.getDeaths())
                .vaccinationLevel(vaccinesData.getPeopleVaccinated().divide(vaccinesData.getPopulation(), 2,RoundingMode.HALF_UP).multiply(new BigDecimal(100)))
                .newConfirmedCases(casesData.getConfirmed() - prevDayConfirmed)
                .build();
    }


}
