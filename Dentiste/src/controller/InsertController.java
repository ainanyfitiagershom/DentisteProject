package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Connect;
import function.Dao;
import models.About_teeth_person;
@WebServlet("/insert")
public class InsertController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getIdpersonne = req.getParameter("idpersonne");
        String teeth = req.getParameter("idteeth") ;
        String etat = req.getParameter("etat");
        Connection con = new Connect().Connecter("dentiste", "postgres", "1776");
        if(teeth.contains("-")){
            String [] idteeth_array = teeth.split("-") ;
            for (int i = 0; i < idteeth_array.length; i++) {
                About_teeth_person about =  new About_teeth_person(getIdpersonne , idteeth_array[i] , etat);
                new Dao().Insert(con, about);

            }
        }
        if(teeth.contains(";")){
            String [] idteeth_array = teeth.split(";") ;
            String [] etat_array = etat.split(";");
            for (int i = 0; i < idteeth_array.length; i++) {
                About_teeth_person about =  new About_teeth_person(getIdpersonne , idteeth_array[i] , etat_array[i]);
                new Dao().Insert(con, about);
            }
        }
        try {
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("first");
    }
}
