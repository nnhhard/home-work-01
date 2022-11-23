package ru.iashinme.service;

import com.opencsv.exceptions.CsvException;
import ru.iashinme.dao.AnswerQuestionDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerQuestionServiceImpl implements AnswerQuestionService {
    private final List<AnswerQuestionDao> listAnswerQuestions;

    public AnswerQuestionServiceImpl(ResourceReaderService resourceReader, CsvReaderService csvReaderService) throws IOException, CsvException {
        listAnswerQuestions = new ArrayList<>();

        List<String[]> allElementsFile = csvReaderService.inputStreamToCsv(resourceReader.getInputStream());
        for (String[] lineFile : allElementsFile
        ) {
            String[] answers = Arrays.copyOfRange(lineFile, 1, lineFile.length);
            listAnswerQuestions.add(new AnswerQuestionDao(
                    lineFile[0], Arrays.asList(answers)
            ));
        }
    }

    @Override
    public void printAnswerQuestionList() {
        for (AnswerQuestionDao aqd : listAnswerQuestions) {
            System.out.println(aqd.toString());
        }
    }
}
