package repository.service_furuma;

import model.service.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();
    void save(Service service);
    Service findById(String id);
    void update(String id, Service service);
    void remove(String id);
    List<Service> searchCustomer(String name);
}
