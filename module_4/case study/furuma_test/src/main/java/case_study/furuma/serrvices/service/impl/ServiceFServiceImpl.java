package case_study.furuma.serrvices.service.impl;

import case_study.furuma.model.service.ServiceF;
import case_study.furuma.repository.service.ServiceFRepository;
import case_study.furuma.serrvices.service.ServiceFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFServiceImpl implements ServiceFService {
    @Autowired
    ServiceFRepository serviceFRepository;

    @Override
    public List<ServiceF> findAll() {
        return serviceFRepository.findAll();
    }

    @Override
    public void save(ServiceF serviceF) {
        serviceFRepository.save(serviceF);
    }

    @Override
    public ServiceF findById(String id) {
        return serviceFRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        serviceFRepository.deleteById(id);
    }
}
