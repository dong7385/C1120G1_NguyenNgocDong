package case_study.furuma.serrvices.service.impl;

import case_study.furuma.model.service.RentType;
import case_study.furuma.repository.service.RentTypeRepository;
import case_study.furuma.serrvices.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
