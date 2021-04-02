package repository.service_furuma;

import model.service.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    ServiceType findById(int id);
    List<ServiceType> findAll();
}
