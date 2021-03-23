package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.CustomerService;
import service.customer.CustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static CustomerService customerService = new CustomerServiceImpl();
    private static CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

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

    private void searchForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.searchCustomer(name);
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customer_type_id")));
        String customer_name = request.getParameter("customer_name");
        Date customer_birthday;
        customer_birthday = Date.valueOf(request.getParameter("customer_birthday"));
        Boolean customer_gender = Boolean.valueOf(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        Customer customer = customerService.findById(id);
        customer.setCustomerType(customerType);
        customer.setCustomer_name(customer_name);
        customer.setCustomer_birthday(customer_birthday);
        customer.setCustomer_gender(customer_gender);
        customer.setCustomer_id_card(customer_id_card);
        customer.setCustomer_phone(customer_phone);
        customer.setCustomer_email(customer_email);
        customer.setCustomer_address(customer_address);

        customerService.update(id, customer);
        listCustomer(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        String customer_id = request.getParameter("customer_id");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customer_type_id")));
        String customer_name = request.getParameter("customer_name");
        Date customer_birthday = Date.valueOf(request.getParameter("customer_birthday"));
        Boolean customer_gender = Boolean.valueOf(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");

        Customer customer = new Customer(customer_id, customerType, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
        customerService.save(customer);

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
                //   searchForm(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/customer/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        customerService.remove(id);
        listCustomer(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

