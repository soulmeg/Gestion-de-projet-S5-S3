package objet ;

import java.util.* ;
import generalisation.* ;

public class Materiel {
	String id_materiel ;
	String nom ;

	public Materiel(){
	}
	public void setId_materiel(String newid_) throws Exception{
		if(newid_.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " id_materiel cannot be blank String.") ;
		}
		this.id_materiel = newid_;
	}
	public void setNom(String newnom) throws Exception{
		if(newnom.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " nom cannot be blank String.") ;
		}
		this.nom = newnom;
	}
	public String getId_materiel(){
		return this.id_materiel ; 
	}
	public String getNom(){
		return this.nom ; 
	}
	public void insert_Materiel(String nom) throws Exception{
		findInBase(nom.toUpperCase());
		Materiel newMateriel = new Materiel();
		newMateriel.setId_materiel(Generalisation.generatePrimaryKey("MA" , "seq_" + this.getClass().getSimpleName()));
		newMateriel.setNom(nom.toUpperCase());
		Generalisation.insert(newMateriel);
	}
	public Vector<Materiel> convert_Materiel(Vector<Object> ob){
		Vector<Materiel> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Materiel){
				result.add((Materiel) obj);
			}
		}
		return result;
	}
	public Vector<Materiel> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Materiel> Materiels = this.convert_Materiel(vect);
		return Materiels;
	}
	public Vector<Materiel> findById(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_Materiel = '" + id + "'",this);
		Vector<Materiel> Materiels = this.convert_Materiel(vect);
		return Materiels;
	}
	public boolean findInBase(String nom) throws Exception{
		Vector<Object> vect = Generalisation.select("where nom = '" + nom + "'" , this);
		if(vect.isEmpty()){
			return true;
		}
		throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}

}
