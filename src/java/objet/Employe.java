/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import generalisation.Generalisation;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Mégane Rakotonarivo
 */
public class Employe {
    String id_employe;
    String id_personne;
    String id_role;
    Date date_embauche;

    public void setId_employe(String newId_employe)throws Exception{
            if(newId_employe == null && newId_employe.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " newId_employe is undefined.");
            }
            this.id_employe = newId_employe;
    }

    public void setId_personne(String newId_personne)throws Exception{
            if(newId_personne == null && newId_personne.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " newId_personne is undefined.");
            }
            this.id_personne = newId_personne;
    }

    public void setDate_embauche(Date newDate_embauche)throws Exception{
            this.date_embauche = newDate_embauche;
    }

    public void setDate_embauche(String newDate_embauche)throws Exception{
            if(newDate_embauche == null && newDate_embauche.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " newDate_embauche is undefined.");
            }
            this.setDate_embauche(java.sql.Date.valueOf(newDate_embauche));
    }

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }
    
    public String getId_employe(){
            return this.id_employe;
    }

    public String getId_personne(){
            return this.id_personne;
    }

    public Date getDate_embauche(){
            return this.date_embauche;
    }

	public Vector<Employe> convert_Employe(Vector<Object> ob){
		Vector<Employe> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Employe){
				result.add((Employe) obj);
			}
		}
		return result;
	}

	public Vector<Employe> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Employe>  Employes = this.convert_Employe (vect);
		return  Employes;
	}

	public void insert_Employe(String id_personne,String id_role,String date_embauche)throws Exception{
            findInBase(id_personne);
            Employe newEmploye = new Employe();
            newEmploye.setId_employe(Generalisation.generatePrimaryKey("EMP","seq_" + this.getClass().getSimpleName()));
            newEmploye.setId_personne(id_personne);
            newEmploye.setDate_embauche(date_embauche);
            newEmploye.setId_role(id_role);
            Generalisation.insert(newEmploye);
	}

    public boolean findInBase(String id_personne) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_personne = '" + id_personne +"'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("Cette personne a déja un emploie");
    }

	public Employe findById(String id)throws Exception{
        Vector<Object> vect = Generalisation.select("where id_employe='"+id+"'",this);
        Vector<Employe> Employes = this.convert_Employe(vect);
        if(Employes.size() <= 0) throw new Exception("Aucun employe correspondant");
        return Employes.get(0);
    }
    
    public Personne findByIdPersonne()throws Exception{
       Personne p = new Personne();
       p = p.findById(this.getId_personne());
       return p;
    }

}

