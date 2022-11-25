package ru.iashinme.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.iashinme.domain.AnswerQuestion;
import ru.iashinme.service.AnswerQuestionService;

import java.util.List;

@DisplayName("Class AnswerQuestionService")
public class AnswerQuestionServiceTest {

    @Test
    @DisplayName("Should have correct raising the context and reading csv file")
    public void shouldHaveCorrectRaisingContextAndReadingCsvFile() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnswerQuestionService answerQuestionService = context.getBean(AnswerQuestionService.class);

        List<AnswerQuestion> listAnswerQuestion = answerQuestionService.getListAnswerQuestion();
        Assertions.assertEquals(5, listAnswerQuestion.size());
        Assertions.assertEquals("What value can be assigned to a variable with type boolean?", listAnswerQuestion.get(2).getQuestion());
        Assertions.assertEquals("1) \"Mikhail\"; 2) true; 3) 52;", listAnswerQuestion.get(2).getAnswers());
        Assertions.assertEquals("2", listAnswerQuestion.get(2).getRightAnswer());
    }

    @Test
    @DisplayName("Should have correct raising the context and reading csv file for rows without answers and right answer")
    public void shouldHaveCorrectRaisingContextAndReadingCsvFileWithoutAnswersAndRightAnswer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnswerQuestionService answerQuestionService = context.getBean(AnswerQuestionService.class);

        List<AnswerQuestion> listAnswerQuestion = answerQuestionService.getListAnswerQuestion();
        Assertions.assertEquals(5, listAnswerQuestion.size());
        Assertions.assertEquals("Which of the above is the interface?", listAnswerQuestion.get(0).getQuestion());
        Assertions.assertNull(listAnswerQuestion.get(0).getAnswers());
        Assertions.assertNull(listAnswerQuestion.get(0).getRightAnswer());
    }
}