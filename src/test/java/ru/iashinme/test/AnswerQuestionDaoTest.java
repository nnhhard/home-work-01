package ru.iashinme.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.iashinme.dao.AnswerQuestionDao;
import ru.iashinme.domain.AnswerQuestion;

import java.util.List;

@DisplayName("Class AnswerQuestionDao")
public class AnswerQuestionDaoTest {

    @Test
    @DisplayName("Should have correct method findAllByQuestion in AnswerQuestionDao")
    public void shouldHaveCorrectMethodFindAllByQuestionInAnswerQuestionDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnswerQuestionDao answerQuestionDao = context.getBean(AnswerQuestionDao.class);
        String question = "Which of the above is the principle of OOP?";
        List<AnswerQuestion> resultFindAllByQuestion = answerQuestionDao.findAllByQuestion(question);

        Assertions.assertEquals(1, resultFindAllByQuestion.size());
        Assertions.assertEquals(question, resultFindAllByQuestion.get(0).getQuestion());
    }
}
