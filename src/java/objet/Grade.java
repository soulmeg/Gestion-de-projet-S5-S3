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
public class Grade {
    String id;
    String nom;

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

    public Grade() {
    }
    
    public Vector<Grade> convert_Grade(Vector<Object> ob) {
        Vector<Grade> result = new Vector<>();    
        for (Object obj : ob) {
            if(obj instanceof Grade) {
                result.add((Grade) obj);
            } 
        }
        return result;
    }
    
    public Vector<Grade> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select( "", this);
        Vector<Grade> Grades = this.convert_Grade(vect);
        return Grades;
    }
    
}
