package ru.iashinme.dao;

import com.opencsv.exceptions.CsvException;
import ru.iashinme.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> findAll() throws IOException, CsvException;
}
