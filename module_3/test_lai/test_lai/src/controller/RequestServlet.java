package controller;

import model.Request;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import service.request.RequestService;
import service.request.RequestServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RequestServlet",urlPatterns = {"/request"})
public class RequestServlet extends HttpServlet {
    private static ProductService productService=new ProductServiceImpl();
    private static EmployeeService employeeService=new EmployeeServiceImpl();
    private static CustomerService customerService=new CustomerServiceImpl();
    private static RequestService requestService=new RequestServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
              //  showCreateForm(request, response);
                break;
            case "edit":
             //   showEditForm(request, response);
                break;
            case "delete":
              //  deleteForm(request, response);
                break;
            case "view":
                break;
            case "search":
                //   searchForm(request, response);
                break;
            default:
                listRequest(request, response);
                break;
        }
    }

    private void listRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Request> requestList = requestService.findAll();
        request.setAttribute("requestList", requestList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/request/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    }
