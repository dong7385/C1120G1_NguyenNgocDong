package service.service_furuma;

import model.service.RentType;
import repository.service_furuma.RentTypeRepository;
import repository.service_furuma.RentTypeRepositoryImpl;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository=new RentTypeRepositoryImpl();
    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
