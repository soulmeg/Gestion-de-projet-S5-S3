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
public class TauxExperience {
    String id;
    String id_grade;
    int nombreTaux;

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

    public int getNombreTaux() {
        return nombreTaux;
    }

    public void setNombreTaux(int nombreTaux) {
        this.nombreTaux = nombreTaux;
    }

    public void setNombreTaux(String n) throws Exception{
        if(n.equals("")) throw new Exception("Taux vide");
        this.setNombreTaux(Integer.valueOf(n));
    }
    public TauxExperience() {
    }
    
      public Vector<TauxExperience> convert_TauxExperience(Vector<Object> ob) {
        Vector<TauxExperience> result = new Vector<>();    
        for (Object obj : ob) {
            if(obj instanceof TauxExperience) {
                result.add((TauxExperience) obj);
            } 
        }
        return result;
    }
    
    public Vector<TauxExperience> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select( "", this);
        Vector<TauxExperience> TauxExperiences = this.convert_TauxExperience(vect);
        return TauxExperiences;
    }
    
    public void insertTauxExperience(String id_grade,String taux) throws Exception {
        TauxExperience t = new TauxExperience();
        t.setId(Generalisation.generatePrimaryKey("TAUE", "seq_TauxExperience"));
        t.setId_grade(id_grade);
        t.setNombreTaux(taux);
        Generalisation.insert(t);
    }
    public TauxExperience findByIdGrade(String id_grade) throws Exception{
        Vector<Object> vect = Generalisation.select( "where id_grade='"+id_grade+"'", this);
        Vector<TauxExperience> e = this.convert_TauxExperience(vect);
        if(e.size() <= 0 ) return null;
        return e.get(0);
    }
    
    public void insertOrUpdate(String id_grade,String taux)throws Exception{
        TauxExperience e = new TauxExperience();
        e = this.findByIdGrade(id_grade);
        if( e == null){
            this.insertTauxExperience(id_grade, taux);
        }
        else{
            TauxExperience exp = new TauxExperience();
            exp.setId(e.getId());
            exp.setNombreTaux(taux);
            exp.setId_grade(id_grade);
            Generalisation.update(exp, "id='"+e.getId()+"'");
        }
    }
}
