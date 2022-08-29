package tech.bonsay.covidstat.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.bonsay.covidstat.statistics.models.dto.StatisticHistoryData;
import tech.bonsay.covidstat.statistics.models.dto.StatisticVaccinesData;
import tech.bonsay.covidstat.statistics.models.enums.StatisticHistoryStatus;
import tech.bonsay.covidstat.statistics.models.dto.StatisticCasesData;

/**
 * Covid-19-API client
 * Feign client for covid-api.mmediagroup.fr, provides information of covid live cases and historical data.
 * */

@FeignClient(name = "easypost-client", url = "${feign.client.covidapi.url}")
public interface CovidApiFeignClient {

    /**
     * @param ab - Abbreviation of country, Example: KZ, FR etc
     * @param country - Country name, Example: France
     * @return Live cases data
     * @see StatisticCasesData
     * */
    @GetMapping("/cases")
    CovidApiResponse<StatisticCasesData> getCases(@RequestParam(value = "ab", required = false) String ab, @RequestParam(value = "country", required = false) String country);

    /**
     * @param ab - Abbreviation of country, Example: KZ, FR etc
     * @param country - Country name, Example: France
     * @param status - Filter for case data. Possible values: Confirmed, Deaths, Recovered (DEPRECIATED)
     * @return Historical data
     * @see StatisticHistoryData
     * */
    @GetMapping("/history")
    CovidApiResponse<StatisticHistoryData> getHistory(@RequestParam(value = "ab", required = false) String ab,
                                                      @RequestParam(value = "country", required = false) String country,
                                                      @RequestParam(value = "status") StatisticHistoryStatus status);

 /**
     * @param ab - Abbreviation of country, Example: KZ, FR etc
     * @param country - Country name, Example: France
     * @return Vaccines data
     * @see StatisticVaccinesData
     * */
    @GetMapping("/vaccines")
    CovidApiResponse<StatisticVaccinesData> getVaccines(@RequestParam(value = "ab", required = false) String ab,
                                                        @RequestParam(value = "country", required = false) String country);


}
