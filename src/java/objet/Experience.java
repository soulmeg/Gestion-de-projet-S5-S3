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
public class Experience {
    String id;
    String id_grade;
    int annee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_grade() {
        return id_grade;
    }

    public void setId_grade(String id_grade) {
        this.id_grade = id_grade;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setAnnee(String annee) throws Exception{
        if(annee.equals("")) throw new Exception("Année vide");
        this.setAnnee(Integer.valueOf(annee));
    }
    
    public Experience() {
    }
    
     public Vector<Experience> convert_Experience(Vector<Object> ob) {
        Vector<Experience> result = new Vector<>();    
        for (Object obj : ob) {
            if(obj instanceof Experience) {
                result.add((Experience) obj);
            } 
        }
        return result;
    }
    
    public Vector<Experience> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select( "", this);
        Vector<Experience> Experiences = this.convert_Experience(vect);
        return Experiences;
    }
    
    
    
    public void insertExperience(String id_grade,String annee)throws Exception{
        Experience e = new Experience();
        e.setId(Generalisation.generatePrimaryKey("EXP", "seq_Experience"));
        e.setId_grade(id_grade);
        e.setAnnee(annee);
        Generalisation.insert(e);
    }
    
    public Experience findByIdGrade(String id_grade) throws Exception{
        Vector<Object> vect = Generalisation.select( "where id_grade='"+id_grade+"'", this);
        Vector<Experience> e = this.convert_Experience(vect);
        if(e.size() <= 0 ) return null;
        return e.get(0);
    }
    
    public void insertOrUpdate(String id_grade,String annee)throws Exception{
        Experience e = new Experience();
        e = this.findByIdGrade(id_grade);
        if( e == null){
            this.insertExperience(id_grade, annee);
        }
        else{
            Experience exp = new Experience();
            exp.setId(e.getId());
            exp.setAnnee(annee);
            exp.setId_grade(id_grade);
            Generalisation.update(exp, "id='"+e.getId()+"'");
        }
    }
    
    
    
}
