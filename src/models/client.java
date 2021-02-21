/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class client extends Personne{
    private int id ;
    private int tel;
    private int adresse;

    public client() {
    }

    public client(int id, int tel, int adresse) {
        this.id = id;
        this.tel = tel;
        this.adresse = adresse;
    }

    public client(int tel, int adresse) {
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }
    
    
}
