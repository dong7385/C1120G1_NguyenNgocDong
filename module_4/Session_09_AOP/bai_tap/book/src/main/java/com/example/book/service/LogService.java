package com.example.book.service;

import com.example.book.model.Log;

public interface LogService {
    int getSize();

    void save(Log log);

    int getVisitorNumber(Integer id);

    void addVisitor(Integer id);
}
