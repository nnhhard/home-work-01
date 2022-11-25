package ru.iashinme.service;

import ru.iashinme.domain.AnswerQuestion;

import java.util.List;

public class InputOutputServiceImpl implements InputOutputService {

    private String answerQuestionToStringWithOutRightAnswer(AnswerQuestion answerQuestion) {
        String question = "Question: " + answerQuestion.getQuestion();
        String answers = answerQuestion.getAnswers() != null ? "Response options: " + answerQuestion.getAnswers() : "";

        return String.join(" ", question, answers);
    }

    private String answerQuestionToString(AnswerQuestion answerQuestion) {
        String question = "Question: " + answerQuestion.getQuestion();
        String rightAnswer = answerQuestion.getRightAnswer() != null ? "Right Answer: " + answerQuestion.getRightAnswer() : "";
        String answers = answerQuestion.getAnswers() != null ? "Response options: " + answerQuestion.getAnswers() : "";

        return String.join(" ", question, answers, rightAnswer);
    }

    @Override
    public void printAnswerQuestionList(List<AnswerQuestion> answerQuestionList, boolean withOutRightAnswer) {
        for (AnswerQuestion answerQuestion : answerQuestionList) {
            if(withOutRightAnswer) {
                System.out.println(answerQuestionToStringWithOutRightAnswer(answerQuestion));
            }
            else {
                System.out.println(answerQuestionToString(answerQuestion));
            }
        }
    }

    @Override
    public void printAnswerQuestion(AnswerQuestion answerQuestion, boolean withOutRightAnswer) {
        if(withOutRightAnswer) {
            System.out.println(answerQuestionToStringWithOutRightAnswer(answerQuestion));
        }
        else {
            System.out.println(answerQuestionToString(answerQuestion));
        }
    }
}
