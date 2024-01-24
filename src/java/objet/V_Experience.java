/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import generalisation.Generalisation;
import java.util.Vector;

/**
 *
 * @author Mégane Rakotonarivo
 */
public class V_Experience {
    String id;
    String id_grade;
    String nom;
    int annee;
    int nombreTaux;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_grade() {
        return id_grade;
    }

    public void setId_grade(String id_grade) {
        this.id_grade = id_grade;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreTaux() {
        return nombreTaux;
    }

    public void setNombreTaux(int nombreTaux) {
        this.nombreTaux = nombreTaux;
    }

    public V_Experience() {
    }
    
    public Vector<V_Experience> convert_V_Experience(Vector<Object> ob) {
        Vector<V_Experience> result = new Vector<>();    
        for (Object obj : ob) {
            if(obj instanceof V_Experience) {
                result.add((V_Experience) obj);
            } 
        }
        return result;
    }
    
    public Vector<V_Experience> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select( "", this);
        Vector<V_Experience> V_Experiences = this.convert_V_Experience(vect);
        return V_Experiences;
    }
    
    public V_Experience findByIdGarde(String id_grade) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_grade='"+id_grade+"'", this);
        Vector<V_Experience> V_Experiences = this.convert_V_Experience(vect);
        if(V_Experiences.size() <= 0) throw new Exception("Aucune correspondance");
        return V_Experiences.get(0);
    }
    
}
