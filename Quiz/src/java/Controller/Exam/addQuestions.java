/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Exam;

import Model.Choix.Choix;
import Model.Exam.DAOExam;
import Model.Exam.Exam;
import Model.Exam.ImpDAOExam;
import Model.Question.Question;
import Model.User.DAOProf;
import Model.User.ImpDAOProf;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class addQuestions extends HttpServlet {

    
     DAOExam metierExam ;
      DAOProf metierProf ;

    @Override
    public void init() throws ServletException {
        metierExam = new ImpDAOExam();
        metierProf = new ImpDAOProf();
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
        List<Question> questions = new ArrayList<Question>();
        for(int i=0;i<30;i++){
            int val = Integer.parseInt(request.getParameter("optradio"+(i+1)));
            String libelle = request.getParameter("libelle"+(i+1));
            
            String choix1 = request.getParameter("choix1-"+(i+1));
            String choix2 = request.getParameter("choix2-"+(i+1));
            String choix3 = request.getParameter("choix3-"+(i+1));
            
            Choix ch1 = new Choix(choix1);
            Choix ch2 = new Choix(choix2);
            Choix ch3 = new Choix(choix3);
            
            if(val==1)
                ch1.setValue(true);
            else if(val==2)
                ch2.setValue(true);
            else
                ch3.setValue(true);
            
            List<Choix> choices = new ArrayList<Choix>();
            choices.add(ch1);
            choices.add(ch2);
            choices.add(ch3);
            
            
            
            Question quest = new Question(libelle,choices);
            questions.add(quest);
        }
        
        Exam e =(Exam) request.getSession().getAttribute("e");
        e.setQuestions(questions);
        response.getWriter().print(e.getIdExam());
       //metierExam.addExam(e);
        metierProf.setExam((Integer)request.getSession().getAttribute("Session_idUser"),e);
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
