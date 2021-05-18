package controller;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Anh", "1/1/1999", "hai_phong", "images.png"));
        customerList.add(new Customer(2, "Banh", "1/2/1999", "Da_Nang", "images (1).png"));
        customerList.add(new Customer(3, "Chanh", "1/3/1999", "Sai_gon", "images (2).png"));
        customerList.add(new Customer(4, "Danh", "1/4/1999", "hai_phong", "images (3).png"));
        customerList.add(new Customer(5, "Lanh", "1/5/1999", "hai_phong", "images (4).png"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("a", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
