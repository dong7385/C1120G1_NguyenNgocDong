package service.service_furuma;

import model.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    ServiceType findById(int id);
    List<ServiceType> findAll();
}
