package controller;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import connect.Connect;
import models.About_teeth_person;
import models.New_teeth_person;
import models.Personne;
@WebServlet("/getdonnee")
@MultipartConfig
public class GetController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   
        Gson gson = new Gson();
        resp.setContentType("application/json");
        try {
            Connection con = new Connect().Connecter("dentiste", "postgres", "1776");
            String priorisation = req.getParameter("priorisation");
            String idpersonne = req.getParameter("idpersonne");
            Personne me = new Personne().getMe(con, Integer.valueOf(idpersonne));
            Vector<Object> myteeth = new About_teeth_person().getNewTeeth_person(con, me, Integer.valueOf(priorisation));
            List<About_teeth_person> teeth_new_personne = (List<About_teeth_person>) myteeth.elementAt(0);
            double reste_money = (double) myteeth.elementAt(1);
            List<New_teeth_person> teeth_new_data = new New_teeth_person().getNew_teeth_people(con ,teeth_new_personne);
            Vector<Object> containt_new_data = new Vector<>() ;
            containt_new_data.add(teeth_new_data);
            containt_new_data.add(reste_money) ; 
            String json =  gson.toJson(containt_new_data);
            if(con!=null){
                con.close();
            }
            resp.getWriter().write(json);
        } catch (Exception e) {
            resp.getWriter().write("{404 not found}");
            e.printStackTrace();
        }                
    }
}
