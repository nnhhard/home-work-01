package ru.iashinme.domain;

import org.springframework.lang.NonNull;

public class AnswerQuestion {
    private String question;
    private String answers;
    private String rightAnswer;

    public AnswerQuestion(@NonNull String question, String answers, String rightAnswer) {
        this.answers = answers;
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswers() {
        return answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
