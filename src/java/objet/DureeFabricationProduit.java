package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class DureeFabricationProduit {
    String id;
    String id_meuble;
    String id_volume;
    String id_role;
    double duree;

    
    public DureeFabricationProduit() {
    }
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
    public double getDuree() {
        return duree;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    public void setDuree(String duree) throws Exception{
        if (duree==null || duree.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : Duree invalid");
        }
        this.setDuree(Double.valueOf(duree));
    }

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }
    
    public void insert_DureeFabricationProduit(String id_meuble,String id_volume,String id_role,String duree) throws Exception{
        findInBase(id_meuble,id_volume,id_role);
        DureeFabricationProduit df = new DureeFabricationProduit();
        df.setId(Generalisation.generatePrimaryKey("DFP" , "seq_" + this.getClass().getSimpleName()));
        df.setId_meuble(id_meuble);
        df.setId_volume(id_volume);
        df.setId_role(id_role);
        df.setDuree(duree);
        Generalisation.insert(df);
    }
    
    public Vector<DureeFabricationProduit> convert_DureeFabricationProduit(Vector<Object> ob){
        Vector<DureeFabricationProduit> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof DureeFabricationProduit){
                        result.add((DureeFabricationProduit) obj);
                }
        }
        return result;
    }
    
    public Vector<DureeFabricationProduit> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<DureeFabricationProduit> DureeFabricationProduits = this.convert_DureeFabricationProduit(vect);
        return DureeFabricationProduits;
    }
    
    public boolean findInBase(String id_meuble,String id_volume,String id_role) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_meuble = '" + id_meuble + "' and id_volume = '" + id_volume + "' and id_role='"+id_role+"'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
    }

    
}
