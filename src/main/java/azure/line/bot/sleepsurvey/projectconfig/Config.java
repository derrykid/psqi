package azure.line.bot.sleepsurvey.projectconfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    CommandLineRunner initQuestionnaire() {
        return args -> {
        };
    }
}
