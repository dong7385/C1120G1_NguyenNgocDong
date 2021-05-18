package com.example.book.service.impl;

import com.example.book.model.Log;
import com.example.book.repository.LogRepository;
import com.example.book.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogRepository logRepository;

    @Override
    public int getSize() {
        return logRepository.findAll().size();
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public int getVisitorNumber(Integer id) {
        Log log = logRepository.findById(id).orElse(null);
        if (log != null) {
            return log.getVisitors();
        }
        return 0;
    }

    @Override
    public void addVisitor(Integer id) {
        Log log = logRepository.findById(id).orElse(null);
        if (log != null) {
            log.setVisitors(log.getVisitors() + 1);
            logRepository.save(log);
        }
    }
}
