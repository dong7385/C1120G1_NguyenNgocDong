package service.request;

import model.Request;
import repository.request.RequestRepository;
import repository.request.RequestRepositoryImpl;

import java.util.List;

public class RequestServiceImpl implements RequestService{
    RequestRepository requestRepository=new RequestRepositoryImpl();
    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public void save(Request request) {

    }

    @Override
    public Request findById(String id) {
        return null;
    }

    @Override
    public void update(String id, Request request) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Request> searchCustomer(String name) {
        return null;
    }
}
