package controller;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connect.Connect;
import models.Personne;
import models.Personne_newTeeth;
@WebServlet("/first")
public class FirstController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = new Connect().Connecter("dentiste", "postgres", "1776");
            System.out.println(con);
            try {
                Personne [] all_Personnes = new Personne().getallPersonnes(con);
                Personne_newTeeth [] personnes = new Personne_newTeeth().getAllDonnee(con);
                req.setAttribute("all", personnes);
                req.setAttribute("personne", all_Personnes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                if(con!=null){
                    con.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("Dentiste.jsp");
        dispatcher.forward(req, resp);
    }
}
