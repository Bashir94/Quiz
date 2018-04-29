/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public interface DAOEtudiant {
    public void addEtudiant(Etudiant e);
    public HttpSession getEtudiant(String login,String password,HttpSession session);
    
}
