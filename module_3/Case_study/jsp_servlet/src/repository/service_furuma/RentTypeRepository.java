package repository.service_furuma;

import model.service.RentType;

import java.util.List;

public interface RentTypeRepository {
    RentType findById(int id);
    List<RentType> findAll();
}
