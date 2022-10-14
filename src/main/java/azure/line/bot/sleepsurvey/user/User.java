package azure.line.bot.sleepsurvey.user;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private List<Integer> answerList;

    public User(String userId) {
        this.userId = userId;
        this.answerList = new ArrayList<>();
    }

    public List<Integer> getQuestionList() {
        return this.answerList;
    }

}
