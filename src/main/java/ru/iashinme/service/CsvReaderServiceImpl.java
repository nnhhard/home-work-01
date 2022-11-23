package ru.iashinme.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvReaderServiceImpl implements CsvReaderService {

    @Override
    public List<String[]> inputStreamToCsv(InputStream inputStream) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
        return reader.readAll();
    }
}
