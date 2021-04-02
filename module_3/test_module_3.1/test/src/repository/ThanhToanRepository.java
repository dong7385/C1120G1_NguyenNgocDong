package repository;

import model.ThanhToan;

import java.util.List;

public interface ThanhToanRepository {
    ThanhToan findById(int id);
    List<ThanhToan> findAll();
}
