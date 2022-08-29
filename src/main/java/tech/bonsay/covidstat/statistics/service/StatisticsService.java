package tech.bonsay.covidstat.statistics.service;

import tech.bonsay.covidstat.statistics.models.dto.StatisticData;

public interface StatisticsService {
    StatisticData getStatistic(String ab, String country);
}
