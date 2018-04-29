/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Categorie.Categorie;
import Model.Exam.Exam;
import Model.User.Etudiant;
import Model.User.Prof;
import Model.User.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
    public class NewServlet extends HttpServlet {

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
       
       /* Etudiant p = new Etudiant(" nom", "prenom", "login", "password");
        //Exam p = new Exam();
        p.setNom("d");
        EntityTransaction et = em.getTransaction();
        et.begin();
      //  em.persist(p);
      //   et.commit();
      //  em.close();
        
        /* String req1 ="select m from Prof m";
        Query q1 = em.createQuery(req1);
        List<Prof> liste = q1.getResultList();
        response.getWriter().print(liste.size());*/
         /*String req = "select p from User p where p.login LIKE ?1 and p.password LIKE ?2 ";
            Query q = em.createQuery(req);
            q.setParameter(1, "aloulou");
            q.setParameter(2, "123");
            List<User> liste = q.getResultList();
        for(User m : liste)
            response.getWriter().print(m instanceof Prof);
        
        em.close();*/
      //  emf.close();
        //response.getWriter().print(et.commit());
        
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        //                                EntityManager em = emf.createEntityManager();    
                                        String req1 ="select m from Categorie m";
                                        Query q1 = em.createQuery(req1);
                                        List<Categorie> liste;
                                        liste= q1.getResultList();
                                        em.close();
                                        emf.close();
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
