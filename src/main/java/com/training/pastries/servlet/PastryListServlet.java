package com.training.pastries.servlet;

import com.training.pastries.dao.entity.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;
@WebServlet(urlPatterns = "/pastry-list")
public class PastryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Récuperer les patisseries avec JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pastry> query = em.createQuery("SELECT p FROM Pastry p", Pastry.class);
        List<Pastry> pastryList = query.getResultList();
        em.close();
        emf.close();

        //Mettre les données dans la vue

        req.setAttribute("pastries", pastryList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-list.jsp");
        rd.forward(req, resp);




        //Retourne la resource (vue + donnees)






    }


    }

