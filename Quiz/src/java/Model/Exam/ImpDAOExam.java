/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exam;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class ImpDAOExam implements DAOExam{

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
    @Override
    public void addExam(Exam e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
    }

    @Override
    public List<Exam> getExams() {
        String req1 ="select m from Exam m";
        Query q1 = em.createQuery(req1);
        List<Exam> liste = q1.getResultList();
        return liste;
    }

    @Override
    public List<Exam> getExams(int idProf) {
       String req1 ="SELECT p.exams FROM Prof p WHERE p.idUser = :id";
        List<Exam> exams = (List<Exam>) em.createQuery(req1).setParameter("id", idProf).getResultList();
        return exams;
    }

    @Override
    public List<Exam> getExams(Long idSC) {
        String req1 ="select m from Exam m where m.sc.idSC = ?1";
        Query q1 = em.createQuery(req1);
        q1.setParameter(1, idSC);
        List<Exam> liste = q1.getResultList();
        
       
        return liste;
    }

    @Override
    public Exam getExam(Long idExam) {
        String req1 ="select e from Exam e where e.idExam = ?1";
        Query q1 = em.createQuery(req1);
        q1.setParameter(1, idExam);
        Exam e =(Exam) q1.getSingleResult();
        //em.close();
       // emf.close();
        return e;
    }

    @Override
    public void editExam(Exam e) {
        Exam ex=getExam(e.getIdExam());
        em.getTransaction().begin();
        for(int i=0;i<30;i++){
             em.remove(ex.getQuestions().get(i));
            for(int j=0;j<3;j++)
                em.remove(ex.getQuestions().get(i).getChoix().get(j));
        }
        ex.setQuestions(e.getQuestions());
        em.getTransaction().commit();
    }

    @Override
    public void deleteExam(Exam e) {
        Exam ex=getExam(e.getIdExam());
        em.getTransaction().begin();
        for(int i=0;i<30;i++){
             em.remove(ex.getQuestions().get(i));
            for(int j=0;j<3;j++)
                em.remove(ex.getQuestions().get(i).getChoix().get(j));
        }
        em.remove(ex);
        em.getTransaction().commit();
    }
    
}
