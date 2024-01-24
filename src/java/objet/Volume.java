/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import generalisation.Generalisation;
import java.util.Vector;

/**
 *
 * @author Mégane Rakotonarivo
 */

public class Volume {
	String id_volume ;
	String volume ;

	public Volume(){
	}
	public void setId_volume(String newid_) throws Exception{
		if(newid_.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " id_volume cannot be blank String.") ;
		}
		this.id_volume = newid_;
	}
	public void setVolume(String newvol) throws Exception{
		if(newvol.equals("")){
			throw new Exception(this.getClass().getSimpleName() + " volume cannot be blank String.") ;
		}
		this.volume = newvol;
	}
	public String getId_volume(){
		return this.id_volume ; 
	}
	public String getVolume(){
		return this.volume ; 
	}
	public void insert_Volume(String volume) throws Exception{
		findInBase(volume.toUpperCase());
		Volume newVolume = new Volume();
		newVolume.setId_volume(Generalisation.generatePrimaryKey("VO" , "seq_" + this.getClass().getSimpleName()));
		newVolume.setVolume(volume.toUpperCase());
		Generalisation.insert(newVolume);
	}
	public Vector<Volume> convert_Volume(Vector<Object> ob){
		Vector<Volume> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Volume){
				result.add((Volume) obj);
			}
		}
		return result;
	}
	public Vector<Volume> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Volume> Volumes = this.convert_Volume(vect);
		return Volumes;
	}
	public Vector<Volume> findById(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_Volume = '" + id + "'",this);
		Vector<Volume> Volumes = this.convert_Volume(vect);
		return Volumes;
	}
	public boolean findInBase(String volume) throws Exception{
		Vector<Object> vect = Generalisation.select("where volume = '" + volume + "'" , this);
		if(vect.isEmpty()){
			return true;
		}
		throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}

}
