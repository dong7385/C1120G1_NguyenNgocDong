package service;

import model.PhongTro;
import repository.PhongTroRepository;
import repository.PhongTroRepositoryImpl;

import java.util.List;

public class PhongTroServiceImpl  implements PhongTroService{
    PhongTroRepository phongTroRepository=new PhongTroRepositoryImpl();
    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }

    @Override
    public void save(PhongTro phongTro) {
phongTroRepository.save(phongTro);
    }

    @Override
    public PhongTro findById(String id) {

        return phongTroRepository.findById(id);
    }

    @Override
    public void update(String id, PhongTro phongTro) {
phongTroRepository.update(id,phongTro);
    }

    @Override
    public void remove(String id) {
phongTroRepository.remove(id);
    }

    @Override
    public List<PhongTro> searchCustomer(String name) {
        return phongTroRepository.searchCustomer(name);
    }
}
