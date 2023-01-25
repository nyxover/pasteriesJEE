package com.training.pastries.servlet;

import com.training.pastries.dao.Dao;
import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/pastry-list/add")
public class PastryAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pastry-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    String name = request.getParameter("pastryName");
    String description = request.getParameter("pastryDescription");

        Pastry pastry = new Pastry(name, description);
        Dao<Pastry> pastryDao = DaoFactory.getPastryDao();
        pastryDao.save(pastry);

        resp.sendRedirect(request.getContextPath() + "/pastry-list");
    }
}
