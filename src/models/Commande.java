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
public class Commande {
    private int id;
    private int numero;
    private int date;

    public Commande() {
    }

    public Commande(int id, int numero, int date) {
        this.id = id;
        this.numero = numero;
        this.date = date;
    }

    public Commande(int numero, int date) {
        this.numero = numero;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    
    
}
