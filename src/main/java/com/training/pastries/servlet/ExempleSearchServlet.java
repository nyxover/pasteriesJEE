package com.training.pastries.servlet;

import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/searchPastry")
public class ExempleSearchServlet extends HttpServlet {


    //www.monsite.fr/app/search?zipcode=593000&minPrice150000&maxPrice=300000


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pastryName = req.getParameter("name");

        Optional<Pastry> pastryOpt = searchPastryByName(pastryName);
        if(pastryOpt.isPresent()){
            Pastry pastry = pastryOpt.get();
        }else {
        System.out.println("pastry bot founnd");
        }
        //on pourait rajoute des truc ici exemple
        //pastryOpt.orElseThrow(Supplier<Throwable>)...
    }

    private Optional<Pastry> searchPastryByName(String pastryName){
        if(Math.random() > 0.5){
            Pastry p = new Pastry();
            p.setName(pastryName);
            return Optional.of(p);
        }else{
            return Optional.empty();
        }
    }
}
