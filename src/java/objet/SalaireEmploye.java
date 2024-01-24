package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class SalaireEmploye {
    String id;
    String id_role;
    double tauxHoraire;
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception{
        if (id==null || id.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id invalid");
        }
        this.id = id;
    }
    public String getId_role() {
        return id_role;
    }
    public void setId_role(String id_role) throws Exception{
        if (id_role==null || id_role.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_role invalid");
        }
        this.id_role = id_role;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    
    public void setTauxHoraire(String taux) throws Exception{
        if(taux.equals("")) throw new Exception("Taux vide");
        this.setTauxHoraire(Double.parseDouble(taux));
    }
    
    public void insert_SalaireEmploye(String id_role , String salaire) throws Exception{
        findInBase(id_role);
        SalaireEmploye newSalaireEmploye = new SalaireEmploye();
        newSalaireEmploye.setId(Generalisation.generatePrimaryKey("SALEMP" , "seq_" + this.getClass().getSimpleName()));
        newSalaireEmploye.setId_role(id_role);
        newSalaireEmploye.setTauxHoraire(salaire);
        Generalisation.insert(newSalaireEmploye);
    }
    
    public Vector<SalaireEmploye> convert_SalaireEmploye(Vector<Object> ob){
            Vector<SalaireEmploye> result = new Vector<>() ;
            for(Object obj : ob){
                    if(obj instanceof SalaireEmploye){
                            result.add((SalaireEmploye) obj);
                    }
            }
            return result;
    }
    public Vector<SalaireEmploye> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<SalaireEmploye> SalaireEmployes = this.convert_SalaireEmploye(vect);
            return SalaireEmployes;
    }
    
    public double getTauxHoraire(String id_role)throws Exception{
        Vector<Object> vect = Generalisation.select("where id_role = '" + id_role + "'",this);
        Vector<SalaireEmploye> s = this.convert_SalaireEmploye(vect);
        if(s.size() <= 0) throw new Exception("Ce role n'a pas de correspondant");
        return s.get(0).getTauxHoraire();
    }
    
    public boolean findInBase(String id_role) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_role = '" + id_role + "'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
    }
}
