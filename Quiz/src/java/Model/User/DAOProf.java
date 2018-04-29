/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import Model.Exam.Exam;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public interface DAOProf {
    public void addProf(Prof p);
    public HttpSession getPRof(String login,String password,HttpSession session);
    public void setExam(int idProf,Exam e);
    
}
