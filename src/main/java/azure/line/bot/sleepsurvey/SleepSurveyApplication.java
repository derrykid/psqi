package azure.line.bot.sleepsurvey;

import azure.line.bot.sleepsurvey.controller.EventController;
import azure.line.bot.sleepsurvey.user.User;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@LineMessageHandler
@RestController
public class SleepSurveyApplication {

    private static Map<String, User> registeredUser = new HashMap<>();

    @Autowired
    private EventController eventController;

    public static void main(String[] args) {
        SpringApplication.run(SleepSurveyApplication.class, args);
    }

    @EventMapping
    public TextMessage messageEvent(MessageEvent<TextMessageContent> event) {

        var userId = event.getSource().getUserId();
        var text = event.getMessage().getText();

        if (isStartCommand(text)) {

            // means the user just starts the questionnaire
            if (registeredUser.containsKey(userId)) {
                return new TextMessage("You've already started.");
            }

            User newUser = new User(userId);
            registeredUser.put(userId, newUser);
        }

        if (!registeredUser.containsKey(userId)) {
            return new TextMessage("Please user '/start' command");
        }

        // know the user has used the cmd and started the questionnaire
        User user = registeredUser.get(userId);
        return eventController.handleEvent(user, text);
    }

    private boolean isStartCommand(String text) {
        return text.toLowerCase().contains("/start");
    }

}
