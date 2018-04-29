/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exam;

import java.util.List;

/**
 *
 * @author USER
 */
public interface DAOExam {
    public void addExam(Exam e);
     public void editExam(Exam e);
     public void deleteExam(Exam e);
     public Exam getExam(Long idExam);
    public List<Exam> getExams();
    public List<Exam> getExams(int idProf);
    public List<Exam> getExams(Long idSC);
}
