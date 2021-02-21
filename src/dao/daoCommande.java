/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Commande;

/**
 *
 * @author HP
 */
public class daoCommande implements Idao<Commande>{
      private final String SQL_INSERT="INSERT INTO `commande`(`id_com`, `prix_com`, `libelle_com`, `qte_com`) VALUES (?,?,?,?)";
        private final String SQL_SELECT_ALL="SELECT * FROM commande";

    @Override
    public int insert(Commande objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
       

}
