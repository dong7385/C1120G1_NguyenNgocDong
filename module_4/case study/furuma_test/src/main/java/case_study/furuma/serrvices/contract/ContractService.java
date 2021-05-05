package case_study.furuma.serrvices.contract;

import case_study.furuma.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Integer id);
    void deleteById(Integer id);
    void save(Contract contract);
    Page<Contract>getClientEndStart(String inputDay,Pageable pageable);
}
