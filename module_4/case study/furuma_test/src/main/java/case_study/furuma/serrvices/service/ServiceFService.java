package case_study.furuma.serrvices.service;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.model.service.ServiceF;

import java.util.List;

public interface ServiceFService {
    List<ServiceF> findAll();
    void save(ServiceF serviceF);
    ServiceF findById(String id);
    void deleteById(String id);
}
