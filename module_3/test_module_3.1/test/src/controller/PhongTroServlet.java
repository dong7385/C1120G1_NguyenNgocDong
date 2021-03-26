package controller;

import model.PhongTro;
import service.PhongTroService;
import service.PhongTroServiceImpl;
import service.ThanhToanService;
import service.ThanhToanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongTroServlet", urlPatterns = {"/phongtro"})
public class PhongTroServlet extends HttpServlet {
    private static PhongTroService phongTroService = new PhongTroServiceImpl();
    private static ThanhToanService thanhToanService = new ThanhToanServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //createForm(request, response);
                break;
            case "edit":
                // updateCustomer(request, response);
                break;
            case "delete":
                // deleteForm(request, response);
                break;
            case "search":
                //  searchForm(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //howCreateForm(request, response);
                break;
            case "edit":
                // showEditForm(request, response);
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
                listPhongTro(request, response);
                break;
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        phongTroService.remove(id);
        listPhongTro(request, response);
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/phongtro/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

