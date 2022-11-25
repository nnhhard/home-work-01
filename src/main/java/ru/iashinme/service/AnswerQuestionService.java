package ru.iashinme.service;

import ru.iashinme.domain.AnswerQuestion;

import java.util.List;

public interface AnswerQuestionService {
    List<AnswerQuestion> getListAnswerQuestion();
    void printAnswerQuestionList();
}
