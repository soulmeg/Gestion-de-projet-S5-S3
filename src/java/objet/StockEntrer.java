package objet;

import java.sql.Date;
import java.util.Vector;

import generalisation.Generalisation;

public class StockEntrer {
    String id;
    String id_materiel;
    double quantite;
    Date dateEntrer;
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
    public void setQuantite(String q) throws Exception{
        if (q.equals("")) {
            throw new Exception("tsy mety");
        }
        setQuantite(Double.valueOf(q));
    }
    public Date getDateEntrer() {
        return dateEntrer;
    }
    public void setDateEntrer(Date dateEntrer) {
        this.dateEntrer = dateEntrer;
    }
    public void setDateEntrer(String dateEntrer) throws Exception {
        if (dateEntrer.equals("")) {
            throw new Exception("tsy mety");
        }
        setDateEntrer(Generalisation.makeDate(dateEntrer));
    }
    public StockEntrer() {
    }
    public void insert_StockEntrer(String id_materiel , String quantite , String dateEnter) throws Exception{
        StockEntrer newStockEntrer = new StockEntrer();
        newStockEntrer.setId(Generalisation.generatePrimaryKey("SE", "seq_" + this.getClass().getSimpleName()));
        newStockEntrer.setId_materiel(id_materiel);
        newStockEntrer.setQuantite(quantite);
        newStockEntrer.setDateEntrer(dateEnter);
        Generalisation.insert(newStockEntrer);
    }
    public Vector<StockEntrer> convert_StockEntrer(Vector<Object> ob){
		Vector<StockEntrer> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof StockEntrer){
				result.add((StockEntrer) obj);
			}
		}
		return result;
	}
    public Vector<StockEntrer> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<StockEntrer> StockEntrers = this.convert_StockEntrer(vect);
		return StockEntrers;
	}
    public Vector<StockEntrer> findByMateriel(String id) throws Exception{
		Vector<Object> vect = Generalisation.select("where id_materiel = '" + id + "'",this);
		Vector<StockEntrer> StockEntrers = this.convert_StockEntrer(vect);
		return StockEntrers;
	}
}
