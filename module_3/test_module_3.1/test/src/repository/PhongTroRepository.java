package repository;

import model.PhongTro;

import java.util.List;

public interface PhongTroRepository {
    List<PhongTro> findAll();
    void save(PhongTro phongTro);
    PhongTro findById(String id);
    void update(String id, PhongTro phongTro);
    void remove(String id);
    List<PhongTro> searchCustomer(String name);
}
