package case_study.furuma.serrvice.customer;

import case_study.furuma.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
