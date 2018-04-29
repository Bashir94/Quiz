/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import Model.Exam.Exam;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author USER
 */
@Entity
public class Prof extends User implements Serializable {


    @OneToMany (cascade = ALL)
    @JoinTable(name="jnt_Prof_Exam",
            joinColumns = @JoinColumn(name="idUser"), 
            inverseJoinColumns = @JoinColumn(name="idExam"))
    private List<Exam> exams;

    public Prof() {
    }

    public Prof(String nom, String prenom, String login, String password) {
        super(nom, prenom, login, password);
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += 235;
        return hash;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
