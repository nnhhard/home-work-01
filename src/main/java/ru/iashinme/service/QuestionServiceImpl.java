package ru.iashinme.service;

import ru.iashinme.dao.QuestionDao;
import ru.iashinme.domain.Question;

import java.util.Collections;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final InputOutputService inputOutputService;

    public QuestionServiceImpl(QuestionDao questionDao, InputOutputService inputOutputService) {
        this.questionDao = questionDao;
        this.inputOutputService = inputOutputService;
    }

    @Override
    public void printQuestionList() {
        List<Question> questionList = getQuestionList();
        for (Question row: questionList) {
            var a = row.toString();
            inputOutputService.printMessage(a);
        }
    }

    private List<Question> getQuestionList() {
        List<Question> questionList = Collections.emptyList();
        try {
            questionList = questionDao.findAll();
        } catch (Exception e) {
            System.out.println("Exception! " + e.getMessage());
        }
        return questionList;
    }
}
