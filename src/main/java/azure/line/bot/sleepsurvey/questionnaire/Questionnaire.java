package azure.line.bot.sleepsurvey.questionnaire;

import azure.line.bot.sleepsurvey.questionnaire.question.Question;
import azure.line.bot.sleepsurvey.questionnaire.question.Question1;
import azure.line.bot.sleepsurvey.user.User;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class Questionnaire {

    private List<Question> questionnaire;

    public Questionnaire() {

        questionnaire = new ArrayList<>();

        questionnaire.add(new Question1());

        // q1, q2.....q9
    }

    public Question getQuestion(int number) {
        return questionnaire.get(number);
    }


}
