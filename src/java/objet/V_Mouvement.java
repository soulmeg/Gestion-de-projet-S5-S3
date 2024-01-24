package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class V_Mouvement {
    String id_materiel;
    String nom;
    double sumEntrer;
    double sumSortie;
    double reste;
    public String getId_materiel() {
        return id_materiel;
    }
    public void setId_materiel(String id_materiel) {
        this.id_materiel = id_materiel;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getSumEntrer() {
        return sumEntrer;
    }
    public void setSumEntrer(double sumEntrer) {
        this.sumEntrer = sumEntrer;
    }
    public double getSumSortie() {
        return sumSortie;
    }
    public void setSumSortie(double sumSortie) {
        this.sumSortie = sumSortie;
    }
    public double getReste() {
        return reste;
    }
    public void setReste(double reste) {
        this.reste = reste;
    }
    public V_Mouvement() {
    }
    public Vector<V_Mouvement> convert_V_Mouvement(Vector<Object> ob){
		Vector<V_Mouvement> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof V_Mouvement){
				result.add((V_Mouvement) obj);
			}
		}
		return result;
	}
    public Vector<V_Mouvement> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<V_Mouvement> V_Mouvements = this.convert_V_Mouvement(vect);
		return V_Mouvements;
    }
    public Vector<V_Mouvement> filtre(String re) throws Exception{
		Vector<Object> vect = Generalisation.select("where LOWER(nom) like '%" + re + "%'" ,this);
		Vector<V_Mouvement> V_Mouvements = this.convert_V_Mouvement(vect);
		return V_Mouvements;
    }
    
    public V_Mouvement findById_materiel(String id_mat) throws Exception{
            Vector<Object> vect = Generalisation.select("where id_materiel = '" + id_mat + "'",this);
            Vector<V_Mouvement> V_Mouvements = this.convert_V_Mouvement(vect);
            if(V_Mouvements.size() <= 0) throw new Exception("Aucun mouvement corresondant a ce materiel");
            return V_Mouvements.get(0);
    }
    
    public String checkStock(String id_mat , double totalIlaina) throws Exception{
        String ex = "" ;
        V_Mouvement vm = new V_Mouvement();
        vm = findById_materiel(id_mat);
        if (vm.getReste() < totalIlaina) {
            ex =   vm.getNom() + " : " + ( totalIlaina - vm.getReste()) + "\n";
        }
        return ex ;
    }
    
}