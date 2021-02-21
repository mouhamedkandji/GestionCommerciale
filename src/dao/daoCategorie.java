/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categorie;

/**
 *
 * @author HP
 */
public class daoCategorie implements Idao<Categorie>{
    
    private final String SQL_INSERT ="INSERT INTO `categorie`(`id_categorie`, `nom_categorie`) VALUES (?,?)";
    private final String SQL_SELECT_ALL="SELECT * FROM categorie";
    private daoMysql mysql;
    
    
    public daoCategorie() {
        mysql=new daoMysql();
    }

    @Override
    public int insert(Categorie categorie) {
         int nbreLigne =0;
        try {
            //1-Ouvrir Connexion
            mysql.ouvrirConnexionBD();
            //2-Preparer la requete
              //a-Passer la requete
                  mysql.preparerRequete(SQL_INSERT);
              //b(facultative)-injecter les variables de la requere
              //Objet vers BD 
              mysql.getPs().setString(1,categorie.getLibelle());
             //3- Execution de la requete
             //Requte mis a jour :insert-update-delete
                nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex)  {
            Logger.getLogger(daoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnexion();
        }
        return nbreLigne;
    }
    
}
