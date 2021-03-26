package service;

import model.ThanhToan;

import java.util.List;

public interface ThanhToanService {
    ThanhToan findById(int id);
    List<ThanhToan> findAll();
}
