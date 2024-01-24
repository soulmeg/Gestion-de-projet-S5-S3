package objet;

import java.sql.Date;
import java.util.Vector;

import generalisation.Generalisation;

public class Personne {
    String id_personne;
    String nom;
    String prenom;
    Date dateNaissance;
    String sexe;
    public String getId_personne() {
        return id_personne;
    }
    public void setId_personne(String id_personne) throws Exception{
        if (id_personne==null || id_personne.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_personne invalid");
        }
        this.id_personne = id_personne;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) throws Exception{
        if (nom==null || nom.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : nom invalid");
        }
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setDateNaissance(String dateNaissance)throws Exception{
        if (dateNaissance==null || dateNaissance.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : dateNaissance invalid");
        }
        this.setDateNaissance(Generalisation.makeDate(dateNaissance));
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) throws Exception{
        if (sexe==null || sexe.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : sexe invalid");
        }
        this.sexe = sexe;
    }
    
    public void insert_Personne(String nom,String prenom,String dateNaissance,String sexe) throws Exception{
        Personne newPersonne = new Personne();
        newPersonne.setId_personne(Generalisation.generatePrimaryKey("PRS" , "seq_" + this.getClass().getSimpleName()));
        newPersonne.setNom(nom);
        newPersonne.setPrenom(prenom);
        newPersonne.setDateNaissance(dateNaissance);
        newPersonne.setSexe(sexe);
        Generalisation.insert(newPersonne);
    }
    
    public Vector<Personne> convert_Personne(Vector<Object> ob){
            Vector<Personne> result = new Vector<>() ;
            for(Object obj : ob){
                    if(obj instanceof Personne){
                            result.add((Personne) obj);
                    }
            }
            return result;
    }
    public Vector<Personne> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<Personne> Personnes = this.convert_Personne(vect);
        return Personnes;
    }
    public Personne findById(String id) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_personne='"+id+"'",this);
        Vector<Personne> p = this.convert_Personne(vect);
        if(p.size() <= 0)throw new Exception("Aucun correspondant");
        return p.get(0);
    } 
    
    
}
