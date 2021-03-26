package repository.request;

import model.Request;

import java.util.List;

public interface RequestRepository {
    List<Request> findAll();
    void save(Request request);
    Request findById(String id);
    void update(String id, Request request);
    void remove(String id);
    List<Request> searchCustomer(String name);
}
