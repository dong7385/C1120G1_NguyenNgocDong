package case_study.furuma.serrvices.contract.impl;

import case_study.furuma.model.contract.Contract;
import case_study.furuma.repository.contract.ContractRepository;
import case_study.furuma.serrvices.contract.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getClientEndStart(String inputDay, Pageable pageable) {
        return contractRepository.getClientEndStart(inputDay,pageable);
    }
}
