package ru.iashinme.service;

import java.io.InputStream;

public class ResourceReaderServiceImpl implements ResourceReaderService {
    private final InputStream inputStream;

    public ResourceReaderServiceImpl(String resourceName) {
        inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(resourceName);
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }
}
