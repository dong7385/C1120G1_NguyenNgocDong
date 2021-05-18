package case_study.furuma.repository.service;

import case_study.furuma.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
}
