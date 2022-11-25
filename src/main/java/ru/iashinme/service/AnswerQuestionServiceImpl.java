package ru.iashinme.service;

import ru.iashinme.dao.AnswerQuestionDao;
import ru.iashinme.domain.AnswerQuestion;

import java.util.List;

public class AnswerQuestionServiceImpl implements AnswerQuestionService {
    private final AnswerQuestionDao answerQuestionDao;
    private final InputOutputService inputOutputService;

    public AnswerQuestionServiceImpl(AnswerQuestionDao answerQuestionDao, InputOutputService inputOutputService) {
        this.answerQuestionDao = answerQuestionDao;
        this.inputOutputService = inputOutputService;
    }

    @Override
    public void printAnswerQuestionList() {
        inputOutputService.printAnswerQuestionList(getListAnswerQuestion(), false);
    }

    @Override
    public List<AnswerQuestion> getListAnswerQuestion() {
        return answerQuestionDao.findAll();
    }
}
