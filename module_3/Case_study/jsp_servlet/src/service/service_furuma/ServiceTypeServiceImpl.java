package service.service_furuma;

import model.service.ServiceType;
import repository.service_furuma.ServiceTypeRepository;
import repository.service_furuma.ServiceTypeRepositoryImpl;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService{
    ServiceTypeRepository serviceTypeRepository=new ServiceTypeRepositoryImpl();
    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
