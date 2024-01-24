package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class Employe2 {
    String id_employe;
    String id_personne;
    String id_role;
    public String getId_employe() {
        return id_employe;
    }
    public void setId_employe(String id_employe) throws Exception{
        if (id_employe==null || id_employe.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_employe invalid");
        }
        this.id_employe = id_employe;
    }
    public String getId_personne() {
        return id_personne;
    }
    public void setId_personne(String id_personne)throws Exception {
        if (id_personne==null || id_personne.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_personne invalid");
        }
        this.id_personne = id_personne;
    }
    public String getId_role() {
        return id_role;
    }
    public void setId_role(String id_role)throws Exception {
        if (id_role==null || id_role.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_role invalid");
        }
        this.id_role = id_role;
    }
    public void insert_Employe(String id_personne , String id_role) throws Exception{
            findInBase(id_personne,id_role);
            Employe2 newEmploye = new Employe2();
            newEmploye.setId_employe(Generalisation.generatePrimaryKey("EMP" , "seq_" + this.getClass().getSimpleName()));
            newEmploye.setId_personne(id_personne);
            newEmploye.setId_role(id_role);
            Generalisation.insert(newEmploye);
	}
    public Vector<Employe2> convert_Employe(Vector<Object> ob){
            Vector<Employe2> result = new Vector<>() ;
            for(Object obj : ob){
                    if(obj instanceof Employe2){
                            result.add((Employe2) obj);
                    }
            }
            return result;
    }
    public Vector<Employe2> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<Employe2> Employes = this.convert_Employe(vect);
            return Employes;
    }
    public boolean findInBase(String id_personne , String id_role) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_personne = '" + id_personne + "' and " + "id_role = '" + id_role + "'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("Cette personne a déja un role");
    }
}
