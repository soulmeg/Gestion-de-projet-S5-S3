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
public class V_Benefice {
    String id_meuble;
    String id_categorie;
    String nom_categorie;
    String id_style;
    String nom_style;
    String id_volume;
    String volume;
    int nombreEmploye;
    double benefice;

    public String getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(String id_meuble) {
        this.id_meuble = id_meuble;
    }

    
    public String getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(String id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getId_style() {
        return id_style;
    }

    public void setId_style(String id_style) {
        this.id_style = id_style;
    }

    public String getNom_style() {
        return nom_style;
    }

    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }

    public String getId_volume() {
        return id_volume;
    }

    public void setId_volume(String id_volume) {
        this.id_volume = id_volume;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getNombreEmploye() {
        return nombreEmploye;
    }

    public void setNombreEmploye(int nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }
    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public V_Benefice() {
    }
    public Vector<V_Benefice> convert_V_Benefice(Vector<Object> ob){
        Vector<V_Benefice> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof V_Benefice){
                        result.add((V_Benefice) obj);
                }
        }
        return result;
    }
    
    public Vector<V_Benefice> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<V_Benefice> V_Benefices = this.convert_V_Benefice(vect);
            return V_Benefices;
    }
    
     public Vector<V_Benefice> filtrePrix(String min, String max) throws Exception{
            Vector<Object> vect = Generalisation.select("where benefice >= "+min+" and benefice <= "+max,this);
            Vector<V_Benefice> V_Benefices = this.convert_V_Benefice(vect);
            return V_Benefices;
    }
    
}
