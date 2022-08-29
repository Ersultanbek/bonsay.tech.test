package tech.bonsay.covidstat.statistics.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.bonsay.covidstat.feign.client.CovidApiFeignClient;
import tech.bonsay.covidstat.feign.client.CovidApiResponse;
import tech.bonsay.covidstat.statistics.models.dto.StatisticCasesData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticHistoryData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticVaccinesData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceImplTest {

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    @Mock
    private CovidApiFeignClient covidApiFeignClient;


    @Test
    public void getStatisticTest() {
        StatisticHistoryData historyData = new StatisticHistoryData();
        HashMap<LocalDate, Long> hashMap = new HashMap<>();
        hashMap.put(LocalDate.now(),90L);
        hashMap.put(LocalDate.now().minusDays(1),80L);
        hashMap.put(LocalDate.now().minusDays(2),70L);
        historyData.setDates(hashMap);
        CovidApiResponse<StatisticHistoryData> historyDataCovidApiResponse = new CovidApiResponse<>();
        historyDataCovidApiResponse.setAll(historyData);
        CovidApiResponse< StatisticCasesData> casesDataCovidApiResponse = new CovidApiResponse<>();
        casesDataCovidApiResponse.setAll(new StatisticCasesData(100L,10L,25L,"Kazakhstan", 100_000L, null, null, null, "Asia", "KZ", null, null, "Astana"));
        CovidApiResponse<StatisticVaccinesData> vaccinesDataCovidApiResponse = new CovidApiResponse<>();
        StatisticVaccinesData statisticVaccinesData = new StatisticVaccinesData();
        statisticVaccinesData.setPopulation(BigDecimal.valueOf(100_000));
        statisticVaccinesData.setPeopleVaccinated(BigDecimal.valueOf(10_000));
        vaccinesDataCovidApiResponse.setAll(statisticVaccinesData);

        Mockito.when(covidApiFeignClient.getCases(Mockito.anyString(),Mockito.anyString())).thenReturn(casesDataCovidApiResponse);
        Mockito.when(covidApiFeignClient.getHistory(Mockito.anyString(),Mockito.anyString(), Mockito.any())).thenReturn(historyDataCovidApiResponse);
        Mockito.when(covidApiFeignClient.getVaccines(Mockito.anyString(),Mockito.anyString())).thenReturn(vaccinesDataCovidApiResponse);

        String ab = "KZ";
        String country = "Kazakhstan";
        //Method call
        StatisticData data = statisticsService.getStatistic(ab, country);

        assertThat(data).isNotNull();
        assertThat(data.getConfirmed()).isNotNull().isEqualTo(100L);
        assertThat(data.getDeaths()).isNotNull().isEqualTo(25L);
        assertThat(data.getRecovered()).isNotNull().isEqualTo(10L);
        //100 - 80
        assertThat(data.getNewConfirmedCases()).isNotNull().isEqualTo(20L);
        //(10 000 / 100 000) * 100
        assertThat(data.getVaccinationLevel()).isNotNull();
        assertThat(data.getVaccinationLevel().compareTo(BigDecimal.valueOf(10.00)) == 0).isTrue();

    }


}
