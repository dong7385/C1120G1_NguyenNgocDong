package case_study.furuma.serrvices.contract;

import case_study.furuma.model.contract.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();
    Page<AttachService> findAll(Pageable pageable);
    AttachService findById(Integer id);
    void deleteById(Integer id);
    void save(AttachService attachService);
}
