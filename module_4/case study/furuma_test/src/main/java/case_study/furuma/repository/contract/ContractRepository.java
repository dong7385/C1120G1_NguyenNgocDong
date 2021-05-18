package case_study.furuma.repository.contract;

import case_study.furuma.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);
    @Query (value = "select * from contract where contract_end_day >= ?1" , nativeQuery = true)
    Page<Contract>getClientEndStart(String inputDay,Pageable pageable);
}

