package ru.iashinme.domain;

import org.springframework.lang.NonNull;
import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String question;
    private List<Answer> answers;

    public Question(@NonNull String question, @NonNull List<Answer> answers) {
        this.answers = List.copyOf(answers);
        this.question = question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    public void setAnswers(@NonNull List<Answer> answers) {
        this.answers = List.copyOf(answers);
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        String stringAnswers = answers.stream()
                .map(Answer::toString)
                .collect(Collectors.joining(", ", "Answer options: ", ""));
        return String.join(" ", "Question:", question, stringAnswers);
    }
}
