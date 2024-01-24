package objet ;

import java.util.* ;
import generalisation.* ;

public class Style {
	String id_style ;
	String nom ;

	public Style(){
	}
	public void setId_style(String newid_style) throws Exception{
		if(newid_style.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " id_style cannot be blank String.") ;
		}
		this.id_style = newid_style;
	}
	public void setNom(String newnom) throws Exception{
		if(newnom.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " nom cannot be blank String.") ;
		}
		this.nom = newnom;
	}
	public String getId_style(){
		return this.id_style ; 
	}
	public String getNom(){
		return this.nom ; 
	}
	public void insert_Style(String nom) throws Exception{
		findInBase(nom.toUpperCase());
		Style newStyle = new Style();
		newStyle.setId_style(Generalisation.generatePrimaryKey("ST" , "seq_" + this.getClass().getSimpleName()));
		newStyle.setNom(nom.toUpperCase());
		Generalisation.insert(newStyle);
	}
	public Vector<Style> convert_Style(Vector<Object> ob){
		Vector<Style> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Style){
				result.add((Style) obj);
			}
		}
		return result;
	}
	public Vector<Style> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Style> Styles = this.convert_Style(vect);
		return Styles;
	}
	public Vector<Style> findById(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_Style = '" + id + "'",this);
		Vector<Style> Styles = this.convert_Style(vect);
		return Styles;
	}
	public boolean findInBase(String nom) throws Exception{
		Vector<Object> vect = Generalisation.select("where nom = '" + nom + "'" , this);
		if(vect.isEmpty()){
			return true;
		}
		throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}

}
