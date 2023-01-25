package com.training.pastries.servlet;

import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/pastry-list/details")
public class DetailsPastryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long idPastry = Long.parseLong(idStr);
        PastryDao dao = DaoFactory.getPastryDao();
        Optional<Pastry> pastryOptional = dao.get(idPastry);
        if(pastryOptional.isPresent()) {
            //set data in view
            req.setAttribute("pastry", pastryOptional.get());
        } else {
            System.err.println("Pastry non trouvée");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-details.jsp");
        rd.forward(req, resp);
    }
}
