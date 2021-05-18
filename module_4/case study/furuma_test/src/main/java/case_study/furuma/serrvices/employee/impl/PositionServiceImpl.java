package case_study.furuma.serrvices.employee.impl;

import case_study.furuma.model.employee.Position;
import case_study.furuma.repository.employee.PositionRepository;
import case_study.furuma.serrvices.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
