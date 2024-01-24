/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import java.util.* ;
import generalisation.* ;
/**
 *
 * @author Mégane Rakotonarivo
 */

public class Quantitemateriel {
    String id ;
    String id_categorie ;
    String id_styleMateriel;
    String id_volume ;
    double quantite ;

    public Quantitemateriel(){
    }

    public String getId_styleMateriel() {
        return id_styleMateriel;
    }

    public void setId_styleMateriel(String id_styleMateriel) {
        this.id_styleMateriel = id_styleMateriel;
    }
    
    public void setId(String newid) throws Exception{
            if(newid.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id cannot be blank String.") ;
            }
            this.id = newid;
    }
 
    public void setId_categorie(String newid_) throws Exception{
            if(newid_.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id_categorie cannot be blank String.") ;
            }
            this.id_categorie = newid_;
    }
   
    public void setId_volume(String newid_) throws Exception{
            if(newid_.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id_volume cannot be blank String.") ;
            }
            this.id_volume = newid_;
    }
    public void setQuantite(double newqua){
            this.quantite = newqua;
    }
    public String getId(){
            return this.id ; 
    }
    
    public String getId_categorie(){
            return this.id_categorie ; 
    }
    
    public String getId_volume(){
            return this.id_volume ; 
    }
    public double getQuantite(){
            return this.quantite ; 
    }
    
    public void insert_Quantitemateriel(String id_categorie , String id_styleMateriel , String id_volume , double quantite) throws Exception{
            findInBase(id_categorie , id_styleMateriel , id_volume);
            Quantitemateriel newQuantitemateriel = new Quantitemateriel();
            newQuantitemateriel.setId(Generalisation.generatePrimaryKey("QU" , "seq_" + this.getClass().getSimpleName()));
            newQuantitemateriel.setId_categorie(id_categorie);
            newQuantitemateriel.setId_styleMateriel(id_styleMateriel);
            newQuantitemateriel.setId_volume(id_volume);
            newQuantitemateriel.setQuantite(quantite);
            Generalisation.insert(newQuantitemateriel);
    }
    
    public Vector<Quantitemateriel> convert_Quantitemateriel(Vector<Object> ob){
            Vector<Quantitemateriel> result = new Vector<>() ;
            for(Object obj : ob){
                    if(obj instanceof Quantitemateriel){
                            result.add((Quantitemateriel) obj);
                    }
            }
            return result;
    }
    public Vector<Quantitemateriel> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<Quantitemateriel> Quantitemateriels = this.convert_Quantitemateriel(vect);
            return Quantitemateriels;
    }
    public Vector<Quantitemateriel> findById(String id) throws Exception{
            Vector<Object> vect = Generalisation.select("where id_Quantitemateriel = '" + id + "'",this);
            Vector<Quantitemateriel> Quantitemateriels = this.convert_Quantitemateriel(vect);
            return Quantitemateriels;
    }
    
    public boolean findInBase(String id_categorie,String id_styleMateriel,String id_volume) throws Exception{
            Vector<Object> vect = Generalisation.select("where id_styleMateriel = '" + id_styleMateriel + "'" + " and id_categorie = '" + id_categorie + "' and id_volume = '" + id_volume + "'"  , this);
            if(vect.isEmpty()){
                    return true;
            }
            throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
    }
    public static void main(String[] args) {

    }

}
