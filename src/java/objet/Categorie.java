package objet ;

import java.util.* ;
import generalisation.* ;

public class Categorie {
	String id_categorie ;
	String nom ;

	public Categorie(){
	}
	public void setId_categorie(String newid_categorie) throws Exception{
		if(newid_categorie.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " id_categorie cannot be blank String.") ;
		}
		this.id_categorie = newid_categorie;
	}
	public void setNom(String newnom) throws Exception{
		if(newnom.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " nom cannot be blank String.") ;
		}
		this.nom = newnom;
	}
	public String getId_categorie(){
		return this.id_categorie ; 
	}
	public String getNom(){
		return this.nom ; 
	}
	public void insert_Categorie(String nom) throws Exception{
		findInBase(nom.toUpperCase());
		Categorie newCategorie = new Categorie();
		newCategorie.setId_categorie(Generalisation.generatePrimaryKey("CA" , "seq_" + this.getClass().getSimpleName()));
		newCategorie.setNom(nom.toUpperCase());
		Generalisation.insert(newCategorie);
	}
	public Vector<Categorie> convert_Categorie(Vector<Object> ob){
		Vector<Categorie> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Categorie){
				result.add((Categorie) obj);
			}
		}
		return result;
	}
	public Vector<Categorie> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Categorie> Categories = this.convert_Categorie(vect);
		return Categories;
	}
	public Vector<Categorie> findById(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_Categorie = '" + id + "'",this);
		Vector<Categorie> Categories = this.convert_Categorie(vect);
		return Categories;
	}
	public boolean findInBase(String nom) throws Exception{
		Vector<Object> vect = Generalisation.select("where nom = '" + nom + "'" , this);
		if(vect.isEmpty()){
			return true;
		}
		throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}

}
