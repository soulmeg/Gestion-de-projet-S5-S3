/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import generalisation.Generalisation;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Mégane Rakotonarivo
 */
public class Identifiant {
    String id;
    String nom;
    String prenom;
    Date date_naissance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Identifiant() {
    }
    
    public Vector<Identifiant> convert_Identifiant(Vector<Object> ob) {
        Vector<Identifiant> result = new Vector<>();    
        for (Object obj : ob) {
            if(obj instanceof Identifiant) {
                result.add((Identifiant) obj);
            } 
        }
        return result;
    }
    
    public Vector<Identifiant> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select( "", this);
        Vector<Identifiant> Identifiants = this.convert_Identifiant(vect);
        return Identifiants;
    }
    
    public static void main(String[] args) throws Exception {
        Identifiant id = new Identifiant();
        System.out.println("identifiant: " + id.findAll().get(0).getNom());
    }
}
