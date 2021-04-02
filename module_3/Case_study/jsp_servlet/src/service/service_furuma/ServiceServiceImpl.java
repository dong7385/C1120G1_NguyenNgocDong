package service.service_furuma;

import model.service.Service;
import repository.service_furuma.ServiceRepository;
import repository.service_furuma.ServiceRepositoryImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService{
ServiceRepository serviceRepository=new ServiceRepositoryImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
serviceRepository.save(service);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void update(String id, Service service) {
serviceRepository.update(id,service);
    }

    @Override
    public void remove(String id) {
serviceRepository.remove(id);
    }

    @Override
    public List<Service> searchCustomer(String name) {
        return serviceRepository.searchCustomer(name);
    }
}
