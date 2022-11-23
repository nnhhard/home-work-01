package ru.iashinme.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iashinme.dao.AnswerQuestionDao;

import java.util.List;

@DisplayName("Class AnswerQuestionDao")
public class AnswerQuestionDaoTest {

    @Test
    @DisplayName("Correctly created by the constructor")
    public void shouldHaveCorrectConstructor() {
        String question = "How old are you?";
        List<String> answers = List.of("My age is 12", "My age is 18", "My age is 25");

        AnswerQuestionDao aqd = new AnswerQuestionDao(question, answers);

        Assertions.assertEquals(aqd.getAnswers(), answers);
        Assertions.assertEquals(aqd.getQuestion(), question);
    }
}
