/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.categorie;

import Model.SousCategorie.SousCategorie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class ImpDAOCategorie implements DAOCategorie{

    @Override
    public List<SousCategorie> getListeSC(Long idC) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
        EntityManager em = emf.createEntityManager();
        String req1 ="select m from SousCategorie m where m.categorie.idCategorie = 1?";
        Query q1 = em.createQuery(req1);
        q1.setParameter(1, idC);
        List<SousCategorie> liste = q1.getResultList();
        
        em.close();
        emf.close();
        return liste;
    }
    
}
