package controllers;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login", loadOnStartup = 0)
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Khoi tao servlet Login");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Phuong thuc cua request là: " + req.getMethod());
    }

    @Override
    public void destroy() {
        System.out.println("Ket thuc vong doi Servlet Login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        request.setAttribute("ten", username);
        request.setAttribute("matKhau", password);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/complete.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("name");
//        String password = request.getParameter("pass");
//        System.out.println("Ten cua ban la: " + username);
//        System.out.println("Mat khau: " + password);
//
//        request.setAttribute("ten", username);
//        request.setAttribute("matKhau", password);

//        response.sendRedirect("/login/login.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/login/login.jsp");
    }
}
