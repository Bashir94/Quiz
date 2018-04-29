/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class ImpDAOUser implements DAOUser{

    @Override
    public HttpSession getUser(String login, String password, HttpSession session) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req = "select p from User p where p.login LIKE ?1 and p.password LIKE ?2 ";
            Query q = em.createQuery(req);
            q.setParameter(1, login);
            q.setParameter(2, password);
            User u = (User) q.getSingleResult();
             
        em.close();
        emf.close();
           // session.setAttribute("Session_type", "Etudiant");
            if(u!=null){
                session.setAttribute("Session_idUser", u.getIdUser());
                session.setAttribute("Session_nomUser", u.getNom());
                session.setAttribute("Session", true);
                if(u instanceof Prof)
                    session.setAttribute("Session_type", "Prof");
                else if (u instanceof Etudiant)
                    session.setAttribute("Session_type", "Etudiant");
                return session;
            }
               
            else return session;
    }
    
}
