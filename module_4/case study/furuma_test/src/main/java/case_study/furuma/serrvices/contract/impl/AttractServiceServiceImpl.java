package case_study.furuma.serrvices.contract.impl;

import case_study.furuma.model.contract.AttachService;
import case_study.furuma.repository.contract.AttachServiceRepository;
import case_study.furuma.serrvices.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttractServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }
}
