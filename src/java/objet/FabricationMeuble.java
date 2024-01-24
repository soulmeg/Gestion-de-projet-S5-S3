package objet;

import java.sql.Date;
import java.util.Vector;

import generalisation.Generalisation;

public class FabricationMeuble {
    String id;
    String id_meuble;
    String id_volume;
    double quantite;
    Date dateFabrication;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId_volume() {
        return id_volume;
    }
    public void setId_volume(String id_volume) {
        this.id_volume = id_volume;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public Date getDateFabrication() {
        return dateFabrication;
    }
    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public String getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(String id_meuble) {
        this.id_meuble = id_meuble;
    }
    
    public FabricationMeuble() {
    }
    public void insert_FabricationMeuble(String id_meuble , String id_volume , double quantite , Date dateFabrication) throws Exception{
        FabricationMeuble fm = new FabricationMeuble();
        fm.setId(Generalisation.generatePrimaryKey("FM", "seq_" + this.getClass().getSimpleName()));
        fm.setId_meuble(id_meuble);
        fm.setId_volume(id_volume);
        fm.setQuantite(quantite);
        fm.setDateFabrication(dateFabrication);
        Generalisation.insert(fm);
    }
    
    public Vector<FabricationMeuble> convert_FabricationMeuble(Vector<Object> ob){
        Vector<FabricationMeuble> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof FabricationMeuble){
                        result.add((FabricationMeuble) obj);
                }
        }
        return result;
    }
    public Vector<FabricationMeuble> findAll() throws Exception{
            Vector<Object> vect = Generalisation.select("",this);
            Vector<FabricationMeuble> FabricationMeubles = this.convert_FabricationMeuble(vect);
            return FabricationMeubles;
    }
        
    public String checkQuantiter(String id_meuble , String id_volume , double quantite) throws Exception{
        String ex = "" ;
        V_QuantiteMateriel qm = new V_QuantiteMateriel();
        V_Mouvement vm = new V_Mouvement();
        Meuble m = new Meuble();
        String id_categorie = m.findById(id_meuble).getId_categorie();
        String id_style = m.findById(id_meuble).getId_style();
        Vector<V_QuantiteMateriel> vqm = qm.findByCritere(id_categorie, id_style, id_volume);
        int ilaina = 0 ;
        for (int i = 0; i < vqm.size(); i++) {
            ilaina = (int) (vqm.get(i).getQuantite() * quantite) ;
            ex += vm.checkStock(vqm.get(i).getId_materiel() , ilaina);
        }
        return ex;
    }

    public void validation(String id_meuble , String id_volume , Date dateFabrication , double quantite) throws Exception{
        String ex = checkQuantiter(id_meuble, id_volume, quantite) ;
        V_QuantiteMateriel qm = new V_QuantiteMateriel();
        StockSortie ss = new StockSortie() ;
        Meuble m = new Meuble();
        String id_categorie = m.findById(id_meuble).getId_categorie();
        String id_style = m.findById(id_meuble).getId_style();
        Vector<V_QuantiteMateriel> vqm = qm.findByCritere(id_categorie, id_style, id_volume);
        int ilaina = 0 ;
            if (ex.equals("")) {
                for (int i = 0; i < vqm.size(); i++) {
                    ilaina = (int) (vqm.get(i).getQuantite() * quantite) ;
                    ss.insert_StockSortie(vqm.get(i).getId_materiel(), ilaina , dateFabrication);
                }
                insert_FabricationMeuble(id_meuble, id_volume, quantite, dateFabrication);
                return;
            }
            else if(!ex.equals(""))throw new Exception("Manque: \n"+ex);
            
    }

    public Vector<FabricationMeuble> findById(String idCategorie , String idStyle ,String idVolume) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_categorie = '" + idCategorie + "' and id__style = '" + idStyle +"' and id_volume = '" + idVolume + "'",this);
        Vector<FabricationMeuble> FabricationMeubles = this.convert_FabricationMeuble(vect);
        return FabricationMeubles;
    }
    
}
