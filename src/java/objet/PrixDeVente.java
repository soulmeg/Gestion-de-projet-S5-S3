package objet;

import java.util.Vector;

import generalisation.Generalisation;
import java.sql.Date;

public class PrixDeVente {
    String id;
    String id_meuble;
    String id_volume;
    double prixDeVente;
    Date date_prix;
    
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception{
        if (id==null || id.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id invalid");
        }
        this.id = id;
    }

    public String getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(String id_meuble) {
        this.id_meuble = id_meuble;
    }
    
    public String getId_volume() {
        return id_volume;
    }
    public void setId_volume(String id_volume) throws Exception{
        if (id_volume==null || id_volume.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_volume invalid");
        }
        this.id_volume = id_volume;
    }
    public double getPrixDeVente() {
        return prixDeVente;
    }

    public Date getDate_prix() {
        return date_prix;
    }

    public void setDate_prix(Date date_prix) {
        this.date_prix = date_prix;
    }
    public void setDate_prix(String date) throws Exception{
        if(date.equals("")) throw new Exception("date null");
        this.setDate_prix(Generalisation.makeDate(date));
    }
    public void setPrixDeVente(double prixDeVente) {
        this.prixDeVente = prixDeVente;
    }
    public void setPrixDeVente(String prixDeVente) throws Exception{
        if (prixDeVente==null || prixDeVente.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : prixDeVente invalid");
        }
        this.setPrixDeVente(Double.valueOf(prixDeVente));
    }
    public void insert_PrixDeVente(String id_meuble,String id_volume,String prixDeVente,String date_prix) throws Exception{
        findInBase(id_meuble,id_volume);
        PrixDeVente pv = new PrixDeVente();
        pv.setId(Generalisation.generatePrimaryKey("PDV" , "seq_" + this.getClass().getSimpleName()));
        pv.setId_meuble(id_meuble);
        pv.setId_volume(id_volume);
        pv.setPrixDeVente(prixDeVente);
        pv.setDate_prix(date_prix);
        Generalisation.insert(pv);
    }
    
    public void update_PrixDeVente(String id_meuble,String id_volume,String prixDeVente,String daty) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_meuble = '" + id_meuble + "' and " + "id_volume = '" + id_volume + "'", this);
        Vector<PrixDeVente> prix = this.convert_PrixDeVente(vect);
        PrixDeVente pd = new PrixDeVente();
        pd.setId(prix.get(0).getId());
        pd.setId_meuble(id_meuble);
        pd.setId_volume(id_volume);
        pd.setPrixDeVente(prixDeVente);
        pd.setDate_prix(daty);
        Generalisation.update(pd, "id='"+pd.getId()+"'");
    }
    
    public void traitementPrixDevente(String id_meuble,String id_volume,String prixDeVente,String daty) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_meuble = '" + id_meuble + "' and " + "id_volume = '" + id_volume + "'", this);
        Vector<PrixDeVente> prix = this.convert_PrixDeVente(vect);
        if(prix.size() > 0){
            this.update_PrixDeVente(id_meuble, id_volume, prixDeVente, daty);
        }
        else{
            this.insert_PrixDeVente(id_meuble, id_volume, prixDeVente, daty);
        }
    }
    
    public Vector<PrixDeVente> convert_PrixDeVente(Vector<Object> ob){
        Vector<PrixDeVente> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof PrixDeVente){
                        result.add((PrixDeVente) obj);
                }
        }
        return result;
    }
    public Vector<PrixDeVente> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<PrixDeVente> PrixDeVentes = this.convert_PrixDeVente(vect);
            return PrixDeVentes;
    }
    public boolean findInBase(String id_meuble,String id_volume) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_meuble = '" + id_meuble + "' and " + "id_volume = '" + id_volume + "'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
    }
}
