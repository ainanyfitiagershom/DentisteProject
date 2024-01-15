// package controller;

// import java.io.IOException;
// import java.sql.Connection;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.MultipartConfig;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import connect.Connect;
// import models.Personne;
// import models.Personne_newTeeth;
// @WebServlet("/choix")

// public class ChoixPersonne extends HttpServlet{
//      @Override
  
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         try {
//             Connection con = new Connect().Connecter("dentiste", "postgres", "1776");
//             Personne [] personnes = new Personne().getallPersonnes(con);
//             RequestDispatcher dispatcher = req.getRequestDispatcher("formulaire.jsp");
//             dispatcher.forward(req, resp);
//             if (con !=null){
//                 con.close();
//             }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
           
       
//     }
// }
