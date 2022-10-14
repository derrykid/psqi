package azure.line.bot.sleepsurvey.controller;

import azure.line.bot.sleepsurvey.questionnaire.Questionnaire;
import azure.line.bot.sleepsurvey.questionnaire.question.Question;
import azure.line.bot.sleepsurvey.user.User;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EventController {

    private Map<User, Integer> procedureMap;
    private Questionnaire questionnaire;

    public EventController(@Autowired Questionnaire questionnaire) {
        procedureMap = new HashMap<>();
        this.questionnaire = questionnaire;
    }

    public TextMessage handleEvent(User user, String text) {

        boolean isUserExisted = procedureMap.containsKey(user);

        if (isUserExisted) {
            var atQuestionNumber = procedureMap.get(user);

            Question q = questionnaire.getQuestion(atQuestionNumber + 1);

            return new TextMessage(q.getPrompt());

        } else {
            procedureMap.put(user, 0);
        }


        // check at which number of question is this user proceeds
        // responds with the text

        //e.g. next question is #4, we give him #4
        //when he answers #4, we save the answer in the questionnList.

        // if he answers the last question, then we calc the result
        return null;
    }

}
