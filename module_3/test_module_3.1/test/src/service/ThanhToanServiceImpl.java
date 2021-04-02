package service;

import model.ThanhToan;
import repository.ThanhToanRepository;
import repository.ThanhToanRepositoryImpl;

import java.util.List;

public class ThanhToanServiceImpl implements ThanhToanService {
ThanhToanRepository thanhToanRepository=new ThanhToanRepositoryImpl();

    @Override
    public ThanhToan findById(int id) {
        return thanhToanRepository.findById(id);
    }

    @Override
    public List<ThanhToan> findAll() {
        return thanhToanRepository.findAll();
    }
}
