package objet ;

import java.util.* ;
import generalisation.* ;

public class Stylemateriel {
    String id ;
    String id_style ;
    String id_materiel ;
    String nom; 
    public Stylemateriel(){
    }
    public void setId(String newid) throws Exception{
            if(newid.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id cannot be blank String.") ;
            }
            this.id = newid;
    }
    public void setId_style(String newid_) throws Exception{
            if(newid_.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id_style cannot be blank String.") ;
            }
            this.id_style = newid_;
    }
    public void setId_materiel(String newid_) throws Exception{
            if(newid_.equals("")){
                    throw new Exception(this.getClass().getSimpleName() + " id_materiel cannot be blank String.") ;
            }
            this.id_materiel = newid_;
    }
    public String getId(){
            return this.id ; 
    }
    public String getId_style(){
            return this.id_style ; 
    }
    public String getId_materiel(){
            return this.id_materiel ; 
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
        
	public void insert_Stylemateriel(String id_style , String id_materiel,String nom) throws Exception{
            findInBase(id_style.toUpperCase() , id_materiel.toUpperCase());
            Stylemateriel newStylemateriel = new Stylemateriel();
            newStylemateriel.setId(Generalisation.generatePrimaryKey("ST" , "seq_" + this.getClass().getSimpleName()));
            newStylemateriel.setId_style(id_style.toUpperCase());
            newStylemateriel.setId_materiel(id_materiel.toUpperCase());
            newStylemateriel.setNom(nom);
            Generalisation.insert(newStylemateriel);
	}
        
	public Vector<Stylemateriel> convert_Stylemateriel(Vector<Object> ob){
            Vector<Stylemateriel> result = new Vector<>() ;
            for(Object obj : ob){
                    if(obj instanceof Stylemateriel){
                            result.add((Stylemateriel) obj);
                    }
            }
            return result;
	}
	public Vector<Stylemateriel> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<Stylemateriel> Stylemateriels = this.convert_Stylemateriel(vect);
            return Stylemateriels;
	}
	public Vector<Stylemateriel> findById(String id) throws Exception{
            Vector<Object> vect = Generalisation.select("where id_Stylemateriel = '" + id + "'",this);
            Vector<Stylemateriel> Stylemateriels = this.convert_Stylemateriel(vect);
            return Stylemateriels;
	}
	public boolean findInBase(String id_style,String id_materiel) throws Exception{
            Vector<Object> vect = Generalisation.select("where id_style = '" + id_style + "'" + " and id_materiel = '" + id_materiel + "'" , this);
            if(vect.isEmpty()){
                    return true;
            }
            throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}

}
