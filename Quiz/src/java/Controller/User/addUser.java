/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Model.User.DAOEtudiant;
import Model.User.DAOProf;
import Model.User.Etudiant;
import Model.User.ImpDAOEtudiant;
import Model.User.ImpDAOProf;
import Model.User.Prof;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class addUser extends HttpServlet {

     DAOEtudiant metierEtudiant ;
     DAOProf metierProf ;
     

    @Override
    public void init() throws ServletException {
        metierProf = new ImpDAOProf();
        metierEtudiant = new ImpDAOEtudiant();
      
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        String nom,prenom,login,password;
        nom = request.getParameter("nom");
        prenom= request.getParameter("prenom");
        login = request.getParameter("login");
        password = request.getParameter("password");
        try{
            if(type.equals("Prof")){
                Prof p = new Prof(nom, prenom, login, password);
                metierProf.addProf(p);
            }
            else
            {
                Etudiant e = new Etudiant(nom, prenom, login, password);
                metierEtudiant.addEtudiant(e);
            }
        }
        catch(Exception e){}
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
