package objet;

import java.sql.Date;
import java.util.Vector;

import generalisation.Generalisation;

public class StockSortie {
    String id;
    String id_materiel;
    double quantite;
    Date dateSortie;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId_materiel() {
        return id_materiel;
    }
    public void setId_materiel(String id_materiel) {
        this.id_materiel = id_materiel;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public Date getDateEntrer() {
        return dateSortie;
    }
    public void setDateEntrer(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
    public StockSortie() {
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
    
    public void insert_StockSortie(String id_materiel , double quantite , Date dateSortie) throws Exception{
        StockSortie newStockSortie = new StockSortie();
        newStockSortie.setId(Generalisation.generatePrimaryKey("SE", "seq_" + this.getClass().getSimpleName()));
        newStockSortie.setId_materiel(id_materiel);
        newStockSortie.setQuantite(quantite);
        newStockSortie.setDateEntrer(dateSortie);
        Generalisation.insert(newStockSortie);
    }
    
    public Vector<StockSortie> convert_StockSortie(Vector<Object> ob){
		Vector<StockSortie> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof StockSortie){
				result.add((StockSortie) obj);
			}
		}
		return result;
    }
    
    public Vector<StockSortie> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<StockSortie> StockSorties = this.convert_StockSortie(vect);
		return StockSorties;
    }
    
    public Vector<StockSortie> findByMateriel(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_materiel = '" + id + "'",this);
		Vector<StockSortie> StockSorties = this.convert_StockSortie(vect);
		return StockSorties;
    }
}
