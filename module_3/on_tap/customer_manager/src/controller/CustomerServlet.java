package controller;

import com.sun.prism.PresentableState;
import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.CustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
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
        int id = Integer.parseInt(request.getParameter("id"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        String customerGender = request.getParameter("customerGender");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customerTypeId")));
        Customer customer = customerService.findById(id);
        customer.setCustomerName(customerName);
        customer.setCustomerBirthday(customerBirthday);
        customer.setCustomerGender(customerGender);
        customer.setCustomerType(customerType);
        customerService.update(id, customer);
        listCustomer(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        String customerGender = request.getParameter("customerGender");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customerTypeId")));
        Customer customer = new Customer(customerName, customerBirthday, customerGender, customerType);
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
                searchForm(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        listCustomer(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/customer/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
