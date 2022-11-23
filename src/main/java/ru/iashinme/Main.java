package ru.iashinme;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.iashinme.service.AnswerQuestionService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnswerQuestionService answerQuestionService = context.getBean(AnswerQuestionService.class);

        answerQuestionService.printAnswerQuestionList();
    }

}
