package ru.iashinme.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.iashinme.domain.Answer;
import ru.iashinme.domain.Question;

import java.io.*;
import java.util.*;

public class QuestionDaoImpl implements QuestionDao {
    private final String resourceName;

    public QuestionDaoImpl(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public List<Question> findAll() throws IOException, CsvException {
        return readFileResource();
    }

    private List<Question> readFileResource() throws IOException, CsvException {
        List<Question> questionList = new ArrayList<>();

        if (resourceName != null) {
            List<String[]> allElementsFile = inputStreamToCsv(getInputStreamInFileResource(resourceName));
            for (String[] lineFile : allElementsFile) {
                if (lineFile[0].isEmpty()) continue;
                String question = lineFile[0];
                List<Answer> answers = new ArrayList<>();
                for (String row: Arrays.copyOfRange(lineFile, 1, lineFile.length)) {
                    String[] answer = row.split(";");
                    answers.add(new Answer(answer[0], answer.length > 1 ? Boolean.valueOf(answer[1]) : Boolean.FALSE));
                }

                questionList.add(new Question(
                        question,
                        answers
                ));
            }
        }
        return questionList;
    }

    private List<String[]> inputStreamToCsv(InputStream inputStream) throws IOException, CsvException {
        List<String[]> readerList;
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            readerList = reader.readAll();
        }
        return readerList == null ? Collections.emptyList() : readerList;
    }

    private InputStream getInputStreamInFileResource(String resourceName) {
        return this.getClass()
                .getClassLoader()
                .getResourceAsStream(resourceName);
    }
}
