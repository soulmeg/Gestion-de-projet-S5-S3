package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class EmployeFabrication {
    String id;
    String id_meuble;
    String id_volume;
    String id_role;
    int nombre;
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception{
        if (id==null || id.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id invalid");
        }
        this.id = id;
    }

    public String getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(String id_meuble) {
        this.id_meuble = id_meuble;
    }
    
    public String getId_volume() {
        return id_volume;
    }
    public void setId_volume(String id_volume) throws Exception{
        if (id_volume==null || id_volume.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_volume invalid");
        }
        this.id_volume = id_volume;
    }
    public String getId_role() {
        return id_role;
    }
    
    public void setId_role(String id_role) throws Exception{
        if (id_role==null || id_role.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_role invalid");
        }
        this.id_role = id_role;
    }
    
    public int getNombre() {
        return nombre;
    }
    
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        if (nombre==null || nombre.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : nombre invalid");
        }
        this.setNombre(Integer.valueOf(nombre));
    }
    
    public void insert_EmployeFabrication(String id_meuble,String id_volume,String id_role ,String nombre) throws Exception{
        findInBase(id_meuble,id_volume,id_role);
        EmployeFabrication ef = new EmployeFabrication();
        ef.setId(Generalisation.generatePrimaryKey("EMPFAB" , "seq_" + this.getClass().getSimpleName()));
        ef.setId_meuble(id_meuble);
        ef.setId_volume(id_volume);
        ef.setId_role(id_role);
        ef.setNombre(nombre);
        Generalisation.insert(ef);
    }
    
    public void insertDoubleEF(String id_meuble,String id_volume,String id_role ,String nombre) throws Exception{
        if(id_volume.equals("VOL001")){
            int nombreInt = Integer.valueOf(nombre) *2;
            String two = String.valueOf(nombreInt);
            this.insert_EmployeFabrication(id_meuble, id_volume, id_role, nombre);
            this.insert_EmployeFabrication(id_meuble, "VOL002", id_role,two );
        }
        else{
            this.insert_EmployeFabrication(id_meuble, id_volume, id_role, nombre);
        }
    }
    
    public Vector<EmployeFabrication> convert_EmployeFabrication(Vector<Object> ob){
        Vector<EmployeFabrication> result = new Vector<>() ;
        for(Object obj : ob){
                if(obj instanceof EmployeFabrication){
                        result.add((EmployeFabrication) obj);
                }
        }
        return result;
    }
    
    public Vector<EmployeFabrication> findAll() throws Exception{
        Vector<Object> vect = Generalisation.select("",this);
        Vector<EmployeFabrication> EmployeFabrications = this.convert_EmployeFabrication(vect);
        return EmployeFabrications;
    }
    
    public boolean findInBase(String id_meuble,String id_volume , String id_role) throws Exception{
        Vector<Object> vect = Generalisation.select("where id_meuble = '" + id_meuble + "' and " + "id_volume = '" + id_volume + "' and " + "id_role = '" + id_role + "'", this);
        if(vect.isEmpty()){
                return true;
        }
        throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
    }
}
