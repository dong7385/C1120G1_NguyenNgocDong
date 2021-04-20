package case_study.furuma.serrvices.service.impl;
import case_study.furuma.model.service.ServiceType;
import case_study.furuma.repository.service.ServiceTypeRepository;
import case_study.furuma.serrvices.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    ;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
