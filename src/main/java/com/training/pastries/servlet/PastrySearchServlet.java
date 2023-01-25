package com.training.pastries.servlet;

import com.training.pastries.JPAUtil;
import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.PastryJpaDao;
import com.training.pastries.dao.entity.Pastry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class PastrySearchServlet extends HttpServlet {


    public PastrySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("name");
        PastryDao pastryDao = new PastryJpaDao();
        List<Pastry> searchResult = pastryDao.findByName(searchName);
        request.setAttribute("searchResult", searchResult);
        request.getRequestDispatcher("/WEB-INF/SearchResult.jsp").forward(request, response);
        ;
    }
}