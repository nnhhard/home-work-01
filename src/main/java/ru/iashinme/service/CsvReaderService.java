package ru.iashinme.service;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface CsvReaderService {
    List<String[]> inputStreamToCsv(InputStream inputStream) throws IOException, CsvException;
}
