package case_study.furuma.serrvices.employee.impl;

import case_study.furuma.model.employee.EducationDegree;
import case_study.furuma.repository.employee.EducationDegreeRepository;
import case_study.furuma.serrvices.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
