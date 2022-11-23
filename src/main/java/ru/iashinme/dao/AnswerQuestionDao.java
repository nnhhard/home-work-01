package ru.iashinme.dao;

import org.springframework.lang.NonNull;

import java.util.List;

public class AnswerQuestionDao {
    private final String question;
    private final List<String> answers;

    public AnswerQuestionDao(@NonNull String localQuestion, @NonNull List<String> localAnswers) {
        answers = List.copyOf(localAnswers);
        question = localQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Question: " + question + " Answers: " + String.join(", ", answers);
    }
}
