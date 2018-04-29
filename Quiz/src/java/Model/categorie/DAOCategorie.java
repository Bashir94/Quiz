/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.categorie;

import java.util.List;
import SousCategorie.SousCategorie;

/**
 *
 * @author USER
 */
public interface DAOCategorie {
    public List<SousCategorie> getListeSC(Long idC);
}
