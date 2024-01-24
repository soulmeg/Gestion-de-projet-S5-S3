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
public class V_QuantiteMateriel {
    String id;
    String id_materiel;
    String nom_materiel;
    String id_categorie;
    String nom_categorie;
    String id_style;
    String nom_style;
    String id_volume;
    String volume;
    double quantite;

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

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_materiel() {
        return id_materiel;
    }

    public void setId_materiel(String id_materiel) {
        this.id_materiel = id_materiel;
    }

    public String getNom_materiel() {
        return nom_materiel;
    }

    public void setNom_materiel(String nom_materiel) {
        this.nom_materiel = nom_materiel;
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

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public V_QuantiteMateriel() {
    }
    
    public Vector<V_QuantiteMateriel> convert_V_QuantiteMateriel(Vector<Object> ob){
        Vector<V_QuantiteMateriel> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof V_QuantiteMateriel){
                        result.add((V_QuantiteMateriel) obj);
                }
        }
        return result;
    }
    
    public Vector<V_QuantiteMateriel> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<V_QuantiteMateriel> V_QuantiteMateriels = this.convert_V_QuantiteMateriel(vect);
        return V_QuantiteMateriels;
    }
    
    public Vector<V_QuantiteMateriel> findByIdMateriel(String id) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_materiel = '" + id + "'",this);
        Vector<V_QuantiteMateriel> V_QuantiteMateriels = this.convert_V_QuantiteMateriel(vect);
        return V_QuantiteMateriels;
    }
    
    public Vector<V_QuantiteMateriel> findByCritere(String idCategorie , String id_style ,String idVolume) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_categorie = '" + idCategorie + "' and id_style = '" + id_style +"' and id_volume = '" + idVolume + "'",this);
        Vector<V_QuantiteMateriel> Quantitemateriels = this.convert_V_QuantiteMateriel(vect);
        return Quantitemateriels;
    }
}
