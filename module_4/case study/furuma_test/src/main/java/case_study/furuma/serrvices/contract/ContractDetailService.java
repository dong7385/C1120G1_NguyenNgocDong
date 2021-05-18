package case_study.furuma.serrvices.contract;
import case_study.furuma.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    Page<ContractDetail> findAll(Pageable pageable);
    ContractDetail findById(Integer id);
    void deleteById(Integer id);
    void save(ContractDetail contractDetail);
}
