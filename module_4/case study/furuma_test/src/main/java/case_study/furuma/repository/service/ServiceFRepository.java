package case_study.furuma.repository.service;
import case_study.furuma.model.service.ServiceF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ServiceFRepository extends JpaRepository<ServiceF,String> {
    List<ServiceF> findAll();


}
