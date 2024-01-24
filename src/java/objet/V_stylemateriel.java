package objet ;

import java.util.* ;
import generalisation.* ;

public class V_stylemateriel {
	String id ;
	String id_materiel ;
	String nom ;

	public V_stylemateriel(){
	}
	public void setId(String newid) throws Exception{
		if(newid.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " id cannot be blank String.") ;
		}
		this.id = newid;
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
	public String getId(){
		return this.id ; 
	}
	public String getId_materiel(){
		return this.id_materiel ; 
	}
	public String getNom(){
		return this.nom ; 
	}
	public Vector<V_stylemateriel> convert_V_stylemateriel(Vector<Object> ob){
		Vector<V_stylemateriel> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof V_stylemateriel){
				result.add((V_stylemateriel) obj);
			}
		}
		return result;
	}
	public Vector<V_stylemateriel> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<V_stylemateriel> V_stylemateriels = this.convert_V_stylemateriel(vect);
		return V_stylemateriels;
	}
	public Vector<V_stylemateriel> findById(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id = '" + id + "'",this);
		Vector<V_stylemateriel> V_stylemateriels = this.convert_V_stylemateriel(vect);
		return V_stylemateriels;
	}
}
