package case_study.furuma.serrvices.employee.impl;

import case_study.furuma.model.employee.Division;
import case_study.furuma.repository.employee.DivisionRepository;
import case_study.furuma.serrvices.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
