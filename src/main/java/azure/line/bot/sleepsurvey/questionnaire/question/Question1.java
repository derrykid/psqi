package azure.line.bot.sleepsurvey.questionnaire.question;

public class Question1 implements Question {

    private static final String questionPrompt =
            "During the past month, what time have you usually gone to bed at night?";

    private int sleepAt;

    public Question1() {

    }

    public void setSleepAt(int clock) {
        this.sleepAt = clock;
    }

    public int getSleepAt() {
        return this.sleepAt;
    }

    public String getQuestionPrompt() {
        return questionPrompt;
    }

    @Override
    public String getPrompt() {
        return questionPrompt;
    }
}
