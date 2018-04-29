/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exam;

import Model.Question.Question;
import SousCategorie.SousCategorie;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author USER
 */
@Entity
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExam;
    private String libelle;
    @OneToMany (cascade = ALL)
    @JoinTable(name="jnt_Exam_Question",
            joinColumns = @JoinColumn(name="idExam"), 
            inverseJoinColumns = @JoinColumn(name="idQuestion"))
    private List<Question> questions;
    private SousCategorie sc;

    public Exam() {
    }
    
    public Exam(String libelle, List<Question> questions, SousCategorie sc) {
        this.libelle = libelle;
        this.questions = questions;
        this.sc = sc;
    }

    public Exam(Long idExam, String libelle, List<Question> questions, SousCategorie sc) {
        this.idExam = idExam;
        this.libelle = libelle;
        this.questions = questions;
        this.sc = sc;
    }

    public Exam(Long idExam, String libelle, SousCategorie sc) {
        this.idExam = idExam;
        this.libelle = libelle;
        this.sc = sc;
    }
    
    public Exam(String libelle, SousCategorie sc) {
        this.libelle = libelle;
        this.sc = sc;
    }

    public Long getIdExam() {
        return idExam;
    }

    public void setId(Long idExam) {
        this.idExam = idExam;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public SousCategorie getSc() {
        return sc;
    }

    public void setSc(SousCategorie sc) {
        this.sc = sc;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExam != null ? idExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Exam.Exam[ id=" + idExam + " ]";
    }
    
}
