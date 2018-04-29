/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author USER
 */
@Entity
public class Etudiant extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String login, String password) {
        super(nom, prenom, login, password);
    }
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
