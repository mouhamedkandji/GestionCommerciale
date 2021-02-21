/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Article;

/**
 *
 * @author HP
 */
public class daoArticle implements Idao<Article>{
    
    private final String SQL_INSERT ="INSERT INTO `article`(`id`, `reference`, `id_categorie`, `stock`, `prix`) VALUES (?,?,?,?,?)";
    private final String SQL_SELECT_ALL="SELECT * FROM article";
    private daoMysql mysql;

    public daoArticle() {
        mysql=new daoMysql();
    }

    @Override
     public int insert(Article article){
         int nbreLigne =0;
        try {
            //1-Ouvrir Connexion
            mysql.ouvrirConnexionBD();
            //2-Preparer la requete
              //a-Passer la requete
                  mysql.preparerRequete(SQL_INSERT);
              //b(facultative)-injecter les variables de la requere
              //Objet vers BD 
              mysql.getPs().setString(1,article.getLibelle());
              mysql.getPs().setString(1,article.getReference());
                mysql.getPs().setInt(2, article.getPrix());
                mysql.getPs().setInt(2, article.getStock());
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
     public List<Article> findAll(){
        List<Article>lArticles=new ArrayList<>();       
        
        try {
            //1-Ouvrir Connexion
            mysql.ouvrirConnexionBD();
            //2-Preparer la requete
              //a-Passer la requete
                  mysql.preparerRequete(SQL_SELECT_ALL);
           //3- Execution de la requete
           ResultSet rs=  mysql.executeSelect();
            //Parcourir le resultat de la requete
            while(rs.next()){
                Article atcl=new Article();
                //Hydrater l'objet Cl
                //BD=> Objet
                 atcl.setId(rs.getInt("id"));
                atcl.setLibelle(rs.getString("libelle"));
                atcl.setReference(rs.getString("reference"));
                 atcl.setPrix(rs.getInt("prix"));
                 atcl.setStock(rs.getInt("stock"));
                 
                lArticles.add(atcl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lArticles;
    }
}
