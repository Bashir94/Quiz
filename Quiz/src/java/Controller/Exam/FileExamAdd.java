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
import SousCategorie.SousCategorie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class FileExamAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     DAOExam metierExam ;
      DAOProf metierProf ;

    @Override
    public void init() throws ServletException {
        metierExam = new ImpDAOExam();
        metierProf = new ImpDAOProf();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Scanner input = new Scanner(new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Quiz\\"+request.getParameter("file")));
         //Scanner input = new Scanner(new File(""));
        List<Question> lq = new ArrayList<>();
        //String ex=input.nextLine();
        String libelle = request.getParameter("libelle");
       Long idSc= Long.parseLong(request.getParameter("sc"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        
        String req1 ="select m from SousCategorie m where m.idSC = ?1";
        
        Query q1 = em.createQuery(req1);
        q1.setParameter(1,idSc );
        SousCategorie SC = (SousCategorie) q1.getSingleResult();
        for(int i=0;i<30;i++){
            String quest = input.nextLine();
            String line1,line2,line3;
            line1 = input.nextLine();
            line2 = input.nextLine();
            line3 = input.nextLine();
            String ch1,ch2,ch3;
            Boolean v1=false,v2=false,v3=false;
            ch1 = line1.split(" - ")[0];
            ch2 = line2.split(" - ")[0];
            ch3 = line3.split(" - ")[0];
            if(line1.split(" - ")[1].equals("vrai"))
                v1=true;
            if(line2.split(" - ")[1].equals("vrai"))
                v1=true;
            if(line3.split(" - ")[1].equals("vrai"))
                v1=true;
            
            Choix c1,c2,c3;
            c1= new Choix(v1, ch1);
            c2= new Choix(v2, ch2);
            c3= new Choix(v3, ch3);
            List<Choix> lc = new ArrayList<>();
            lc.add(c1);lc.add(c2);lc.add(c3);
            
            Question q = new Question(quest, lc);
            lq.add(q);
        }
        Exam e = new Exam(libelle, lq, SC);
        metierProf.setExam((Integer)request.getSession().getAttribute("Session_idUser"),e);
        //response.sendRedirect("index.jsp");
        response.getWriter().print("<meta http-equiv='refresh' content='0; url=index.jsp' />");
       
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
