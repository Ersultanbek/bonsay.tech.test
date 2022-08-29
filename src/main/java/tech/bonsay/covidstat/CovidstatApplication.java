package tech.bonsay.covidstat;

import com.google.devtools.common.options.OptionsParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tech.bonsay.covidstat.commandline.models.CommandLineOption;
import tech.bonsay.covidstat.statistics.models.dto.StatisticData;
import tech.bonsay.covidstat.statistics.service.StatisticsService;

import java.util.Collections;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
@EnableFeignClients
public class CovidstatApplication implements CommandLineRunner {

    private final StatisticsService statisticsService;

    public static void main(String[] args) {
        SpringApplication.run(CovidstatApplication.class, args);
        System.exit(0);
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
        OptionsParser parser = OptionsParser.newOptionsParser(CommandLineOption.class);
        parser.parseAndExitUponError(args);
        CommandLineOption options = parser.getOptions(CommandLineOption.class);

        if (options.help) {
            printUsage(parser);
            return;
        }

        if (options.country.isEmpty() && options.ab.isEmpty()) {
            printUsage(parser);
            return;
        }

        if(options.ab.isEmpty()) {
            options.ab = null;
        }


        if(options.country.isEmpty()) {
            options.country = null;
        }

        StatisticData statisticData = statisticsService.getStatistic(options.ab, options.country);
        printData(statisticData);
    }

    private void printData(StatisticData statisticData) {
        System.out.printf("""
                        confirmed : %s
                        recovered : %s
                        deaths : %s
                        vaccinationLevel : %s
                        newConfirmedCases : %s
                        \n""", statisticData.getConfirmed(),
                        statisticData.getRecovered(),
                        statisticData.getDeaths(),
                        statisticData.getVaccinationLevel(),
                        statisticData.getNewConfirmedCases());

    }

    private void printUsage(OptionsParser parser) {
        System.out.println("Usage: java -jar covidstat-1.0.0.jar OPTIONS");
        System.out.println(parser.describeOptions(Collections.emptyMap(), OptionsParser.HelpVerbosity.LONG));
    }

}
