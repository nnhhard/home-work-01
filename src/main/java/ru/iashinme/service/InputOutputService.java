package ru.iashinme.service;

import ru.iashinme.domain.AnswerQuestion;

import java.util.List;

public interface InputOutputService {

    void printAnswerQuestionList(List<AnswerQuestion> answerQuestionList, boolean withOutRightAnswer);
    void printAnswerQuestion(AnswerQuestion answerQuestion, boolean withOutRightAnswer);
}
