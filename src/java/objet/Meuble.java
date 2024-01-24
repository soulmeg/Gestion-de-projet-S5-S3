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
public class Meuble {
    String id;
    String id_categorie;
    String id_style;
    String nom_meuble;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNom_meuble() {
        return nom_meuble;
    }

    public void setNom_meuble(String nom_meuble) {
        this.nom_meuble = nom_meuble;
    }

    public Meuble(String id_categorie, String id_style, String nom_meuble) {
        this.id_categorie = id_categorie;
        this.id_style = id_style;
        this.nom_meuble = nom_meuble;
    }

    public Meuble() {
        
    }
    
    public Vector<Meuble> convert_Meuble(Vector<Object> ob){
        Vector<Meuble> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof Meuble){
                        result.add((Meuble) obj);
                }
        }
        return result;
    }
    public Vector<Meuble> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<Meuble> Meubles = this.convert_Meuble(vect);
        return Meubles;
    }
    
    public Meuble findById(String id) throws Exception{
        Vector<Object> vect = Generalisation.select("where id='"+id+"'",this);
        Vector<Meuble> Meubles = this.convert_Meuble(vect);
        if(Meubles.size()<=0) throw new Exception("Aucun Meuble correspondant");
        return Meubles.get(0);
    }
    
    public void findInBase(String id_categorie,String id_style) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_categorie='"+id_categorie+"' and id_style='"+id_style+"'",this);
        Vector<Meuble> Meubles = this.convert_Meuble(vect);
        if(Meubles.size() > 0 )throw new Exception("Ce meuble existe déja");
    }
    
    public void insertMeuble(String id_categorie,String id_style,String nom) throws Exception{
        Meuble m = new Meuble(id_categorie,id_style,nom);
        m.setId(Generalisation.generatePrimaryKey("MEU", "seq_Meuble"));
        this.findInBase(id_categorie, id_style);
        Generalisation.insert(m);
    }
    
    
}
