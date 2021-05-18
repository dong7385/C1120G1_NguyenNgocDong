package case_study.furuma.serrvices.employee;

import case_study.furuma.model.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
