package ru.iashinme.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.iashinme.domain.AnswerQuestion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnswerQuestionDaoImpl implements AnswerQuestionDao {
    private final String resourceName;

    private InputStream getInputStreamInFileResource(String resourceName) {
        return this.getClass()
                .getClassLoader()
                .getResourceAsStream(resourceName);
    }

    private List<String[]> inputStreamToCsv(InputStream inputStream) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
        return reader.readAll();
    }

    private List<AnswerQuestion> readFileResource() {
        List<AnswerQuestion> answerQuestionList = new ArrayList<>();
        if(resourceName != null) {
            try {
                List<String[]> allElementsFile = inputStreamToCsv(getInputStreamInFileResource(resourceName));
                for (String[] lineFile : allElementsFile) {
                    if (lineFile[0].isEmpty()) continue;
                    answerQuestionList.add(new AnswerQuestion(
                            lineFile[0],
                            lineFile.length > 1 ? lineFile[1] : null,
                            lineFile.length > 2 ? lineFile[2] : null
                    ));
                }
            } catch (Exception e) {
                System.out.println("Exception! " + e.getMessage());
            }
        }
        return answerQuestionList;
    }

    public AnswerQuestionDaoImpl(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public List<AnswerQuestion> findAll() {
        return readFileResource();
    }

    @Override
    public List<AnswerQuestion> findAllByQuestion(String question) {
        return readFileResource()
                .stream()
                .filter(i -> Objects.equals(i.getQuestion(), question))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnswerQuestion> findFirstByQuestion(String question) {
        return readFileResource()
                .stream()
                .filter(i -> Objects.equals(i.getQuestion(), question))
                .findFirst();
    }
}
