/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class ImpDAOEtudiant implements DAOEtudiant{

    @Override
    public void addEtudiant(Etudiant e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        
        em.close();
        emf.close();
    }

    @Override
    public HttpSession getEtudiant(String login, String password,HttpSession session) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req = "select p from Etudiant p where p.login LIKE ?1 and p.password LIKE ?2 ";
            Query q = em.createQuery(req);
            q.setParameter(1, login);
            q.setParameter(2, password);
            List<Etudiant> liste = q.getResultList();
            
        em.close();
        emf.close();
            if(liste.size()>0){
                session.setAttribute("Session_idUser", liste.get(0).getIdUser());
                return session;
            }
                
            else return session;
    }
    
}
