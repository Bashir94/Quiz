/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import Model.Exam.Exam;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

/**
 *
 * @author USER
 */
public class ImpDAOProf implements DAOProf{

    @Override
    public void addProf(Prof p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.close();

        em.close();
        emf.close();
    }

    @Override
    public HttpSession getPRof(String login, String password,HttpSession session) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req = "select p from prof p where p.login LIKE ?1 and p.password LIKE ?2 ";
            Query q = em.createQuery(req);
            q.setParameter(1, login);
            q.setParameter(2, password);
            List<Prof> liste = q.getResultList();
            
        em.close();
        emf.close();
            if(liste.size()>0){
                session.setAttribute("Session_idUser", liste.get(0).getIdUser());
                return session;
            }
               
            else return session;
    }

    @Override
    public void setExam(int idProf, Exam e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req = "select p from Prof p where p.idUser =  ?1 ";      
        Query q = em.createQuery(req);
        q.setParameter(1, idProf);
        Prof p = (Prof) q.getSingleResult();
         
        em.getTransaction().begin();
        List<Exam> exams = p.getExams();
        exams.add(e);
        p.setExams(exams);
        em.getTransaction().commit();
         
            
            
       /* String req1 = "UPDATE Prof p SET p.exams = ?1 where p.idUser= ?2 ";
        Query q1 = em.createQuery(req1);
        q1.setParameter(1, e);
        q1.setParameter(2, idProf);
        q1.executeUpdate();*/
        em.close();
        emf.close();
    }
    
}
