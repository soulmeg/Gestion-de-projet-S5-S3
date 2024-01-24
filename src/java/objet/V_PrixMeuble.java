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
public class V_PrixMeuble {
    String id_categorie;
    String nom_categorie;
    String id_style;
    String nom_style;
    String id_volume;
    String volume;
    double prix;

    public V_PrixMeuble() {
    }

    public String getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(String id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getId_style() {
        return id_style;
    }

    public void setId_style(String id_style) {
        this.id_style = id_style;
    }

    public String getId_volume() {
        return id_volume;
    }

    public void setId_volume(String id_volume) {
        this.id_volume = id_volume;
    }

    
    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getNom_style() {
        return nom_style;
    }

    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Vector<V_PrixMeuble> convert_V_PrixMeuble(Vector<Object> ob){
		Vector<V_PrixMeuble> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof V_PrixMeuble){
				result.add((V_PrixMeuble) obj);
			}
		}
		return result;
	}
    public Vector<V_PrixMeuble> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<V_PrixMeuble> V_PrixMeubles = this.convert_V_PrixMeuble(vect);
        return V_PrixMeubles;
    }
    
    public Vector<V_PrixMeuble> findByIdMateriel(String id) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_materiel = '" + id + "'",this);
        Vector<V_PrixMeuble> V_PrixMeubles = this.convert_V_PrixMeuble(vect);
        return V_PrixMeubles;
    }
    
    public Vector<V_PrixMeuble> findByMinMax(double min , double max) throws Exception{
        Vector<Object> vect = Generalisation.select("where prix >= " + min + " and prix <= " + max ,this);
        Vector<V_PrixMeuble> V_PrixMeubles = this.convert_V_PrixMeuble(vect);
        return V_PrixMeubles;
    }
}
