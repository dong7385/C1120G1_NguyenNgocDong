package com.test_module_4.service.request.impl;

import com.test_module_4.model.request.Product;
import com.test_module_4.model.request.Request;
import com.test_module_4.repository.request.RequestRepository;
import com.test_module_4.service.request.RequestService;
import com.test_module_4.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Page<Request> findAll(Pageable pageable) {
        return requestRepository.findAll(pageable);
    }

    @Override
    public Request findById(Integer id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        requestRepository.deleteById(id);
    }

    @Override
    public void save(Request request) {
        if (request.getRequestId() == null) {
            request.setDateRequest(DateUtil.getCurrentDate());
        }
        request.setTotal(totalMoney(request));
        requestRepository.save(request);
    }

    @Override
    public Page<Request> searchByDate(String startDate, String endDate, Pageable pageable) {
        return requestRepository.searchByDate(startDate, endDate, pageable);
    }

    @Override
    public Integer totalMoney(Request request) {
        Integer productCost = Integer.parseInt(request.getProduct().getPrice());
        Integer quantity = request.getQuantity();
        return quantity * productCost;
    }

    @Override
    public List<Request> searchByTop(Integer top) {
        return requestRepository.searchByTop(top);
    }
}
