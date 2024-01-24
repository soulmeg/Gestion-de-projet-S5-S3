package objet;

import java.sql.Date;
import java.util.Vector;

import generalisation.Generalisation;

public class PrixMateriel {
    String id ;
    String id_materiel;
    double prix;
    Date datePrix;
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
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setPrix(String prix) throws Exception{
        if(prix.equals("")) throw new Exception("Prix vide");
        this.setPrix(Double.valueOf(prix));
    }
    public Date getDatePrix() {
        return datePrix;
    }
    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }
    public void setDatePrix(String date) throws Exception{
        if(date.equals("")) throw new Exception("date null");
        this.setDatePrix(Generalisation.makeDate(date));
    }
    public void insert_PrixMateriel(String id_materiel , String prix, String datePrix) throws Exception{
        PrixMateriel newPrixMateriel = new PrixMateriel();
        newPrixMateriel.setId(Generalisation.generatePrimaryKey("PM", "seq_" + this.getClass().getSimpleName()));
        newPrixMateriel.setId_materiel(id_materiel.toUpperCase());
        newPrixMateriel.setPrix(prix);
        newPrixMateriel.setDatePrix(Generalisation.makeDate(datePrix));
        Generalisation.insert(newPrixMateriel);
    }
    
    public void findInBase(String id_materiel,String prix, String datePrix)throws Exception{
        Vector<Object> vect = Generalisation.select("where id_materiel = '" + id_materiel + "'",this);
        Vector<PrixMateriel> pm = this.convert_PrixMateriel(vect);
        if(pm.size() > 0){
            PrixMateriel p = pm.get(0);
            PrixMateriel nouveau = new PrixMateriel();
            nouveau.setId(p.getId());
            nouveau.setId_materiel(p.getId_materiel());
            nouveau.setPrix(prix);
            nouveau.setDatePrix(datePrix);
            Generalisation.update(nouveau, "id='"+p.getId()+"'");
        }
        else if(pm.size() <= 0){
            this.insert_PrixMateriel(id_materiel, prix, datePrix);
        }
    }
    public Vector<PrixMateriel> convert_PrixMateriel(Vector<Object> ob){
        Vector<PrixMateriel> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof PrixMateriel){
                        result.add((PrixMateriel) obj);
                }
        }
        return result;
    }
    
    public Vector<PrixMateriel> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<PrixMateriel> Stylemateriels = this.convert_PrixMateriel(vect);
            return Stylemateriels;
    }
    
    public PrixMateriel findById(String id) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_materiel = '" + id + "'",this);
        Vector<PrixMateriel> pm = this.convert_PrixMateriel(vect);
        if(pm.size() <= 0) throw new Exception("Cette parametre n'a pas de prix");
        return pm.get(0);
    }

}
