package com.test_module_4.service.request;

import com.test_module_4.model.request.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequestService {
    List<Request> findAll();

    Page<Request> findAll(Pageable pageable);

    Request findById(Integer id);

    void deleteById(Integer id);

    void save(Request request);

    Page<Request> searchByDate(String startDate, String endDate, Pageable pageable);

    Integer totalMoney(Request request);

    List<Request>searchByTop(Integer top);
}
