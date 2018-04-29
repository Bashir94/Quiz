/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Question;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class ImpDAOQuestion implements DAOQuestion{

    @Override
    public Question getQuestion(int idQ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req1 ="select q from Question q where q.idQuestion = ?1";
        Query q1 = em.createQuery(req1);
        q1.setParameter(1, idQ);
        Question q =(Question) q1.getSingleResult();
        
        em.close();
        emf.close();
        return q;
    }
    
}
