package service.service_furuma;

import model.service.RentType;

import java.util.List;

public interface RentTypeService {
    RentType findById(int id);
    List<RentType> findAll();
}
