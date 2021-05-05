package controller;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import service.service_furuma.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static ServiceService serviceService = new ServiceServiceImpl();
    private static RentTypeService rentTypeService = new RentTypeServiceImpl();
    private static ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                 createForm(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            case "search":
                searchForm(request, response);
                break;
            default:
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("id");
        String service_name = request.getParameter("service_name");
        int service_area =Integer.parseInt(request.getParameter("service_area"));
        double service_cost = request.getDateHeader("service_cost");
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        RentType rentType=rentTypeService.findById(Integer.parseInt(request.getParameter("rent_type_id")));
        ServiceType serviceType =serviceTypeService.findById(Integer.parseInt(request.getParameter("service_type_id")));
        String standard_room =request.getParameter("standard_room");
        String description_other_convenience =request.getParameter("description_other_convenience");
        double pool_area =request.getDateHeader("pool_area");
        int number_of_floors =Integer.parseInt(request.getParameter("number_of_floors"));
        Service service;
        service = new Service(id,service_name,service_area,service_cost,service_max_people,rentType,serviceType,standard_room,description_other_convenience,pool_area,number_of_floors);

        serviceService.update(id, service);
        listCustomer(request, response);
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serviceService.remove(id);
        listCustomer(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        String service_id =request.getParameter("service_id");
        String service_name = request.getParameter("service_name");
        int service_area =Integer.parseInt(request.getParameter("service_area"));
        double service_cost = request.getDateHeader("service_cost");
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        RentType rentType=rentTypeService.findById(Integer.parseInt(request.getParameter("rent_type_id")));
        ServiceType serviceType =serviceTypeService.findById(Integer.parseInt(request.getParameter("service_type_id")));
        String standard_room =request.getParameter("standard_room");
        String description_other_convenience =request.getParameter("description_other_convenience");
        double pool_area =request.getDateHeader("pool_area");
        int number_of_floors =Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(service_id,service_name,service_area,service_cost,service_max_people,rentType,serviceType,standard_room,description_other_convenience,pool_area,number_of_floors);
        serviceService.save(service);

        listCustomer(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            case "view":
                break;
            case "search":
                searchForm(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void searchForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Service> serviceList = serviceService.searchCustomer(name);
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/service/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceService.findById(id);
        request.setAttribute("service", service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/service/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/service/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/service/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

