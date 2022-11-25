package ru.iashinme.dao;

import ru.iashinme.domain.AnswerQuestion;
import java.util.List;
import java.util.Optional;

public interface AnswerQuestionDao {

    List<AnswerQuestion> findAll();
    List<AnswerQuestion> findAllByQuestion(String question);
    Optional<AnswerQuestion> findFirstByQuestion(String question);
}
