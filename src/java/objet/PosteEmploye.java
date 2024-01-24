/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Mégane Rakotonarivo
 */
public class PosteEmploye {
    Employe employe ;
    Personne personne;
    String poste;
    double TauxHoraire;
    double anciennete;

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getTauxHoraire() {
        return TauxHoraire;
    }

    public void setTauxHoraire(double TauxHoraire) {
        this.TauxHoraire = TauxHoraire;
    }

    public double getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(double anciennete) {
        this.anciennete = anciennete;
    }
    
    public int dateDiff(Date dateN,Date date_embauche){
        LocalDate dateA = date_embauche.toLocalDate();
        LocalDate dateNow = dateN.toLocalDate();
//        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateA, dateNow);
        return period.getYears();
    }
    
    public Vector<PosteEmploye> getPoste(Date dateN) throws Exception{
        Employe e = new Employe();
        V_Experience exp = new V_Experience();
        SalaireEmploye sal = new SalaireEmploye();
        Vector<V_Experience> exps = exp.findAll();
        Vector<Employe> employes = e.findAll();
        Vector<PosteEmploye> posteE = new Vector<>();
        for(int i=0;i<employes.size();i++){
            Employe emp = e.findById(employes.get(i).getId_employe());
            PosteEmploye pe = new PosteEmploye();
            int dateDiff = this.dateDiff(dateN,employes.get(i).getDate_embauche());
            if(dateDiff >= 0 ){
                for(int j = 0;j<exps.size();j++){
                    if(j+1 <  exps.size()){
                        System.out.println("j: "+j);
                        if( dateDiff >= exps.get(j).getAnnee() && dateDiff < exps.get(j+1).getAnnee() ){
                            pe.setEmploye(emp);
                            pe.setPersonne(emp.findByIdPersonne());
                            pe.setPoste(exps.get(j).getNom());
                            pe.setTauxHoraire(sal.getTauxHoraire(emp.getId_role()));
                            pe.setAnciennete(dateDiff);
                            posteE.add(pe);
                        }
                    }
                   
                }
            }
        }
        return posteE;
    }
}
