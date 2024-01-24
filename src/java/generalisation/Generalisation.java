/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generalisation;

import connection.Connexion;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.Time;
/**
 *
 * @author Mégane Rakotonarivo
 */

public class Generalisation {
 
    public static String generatePrimaryKey(String idPrefix, String sequenceName) throws Exception {
        String query = "SELECT nextval(?)";
        Connection con = Connexion.connect();
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, sequenceName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int nextVal = resultSet.getInt(1);
                    return String.format("%s%03d", idPrefix, nextVal);
                }
            }
        }
        throw new RuntimeException("Failed to generate primary key");
    }
    

    public static void insert(Object obj) throws Exception{
        Connection con = Connexion.connect();
        Statement state=con.createStatement();
        String nomDeTable = obj.getClass().getSimpleName();
        String inserer="INSERT INTO "+nomDeTable+" VALUES("+concatenation(obj)+")"; 
        state.executeUpdate(inserer);
        System.out.println(inserer);
         // con.commit();
        con.close();
        state.close();
    }

    public static void update(Object o,String condition) throws Exception{
        Connection con = Connexion.connect();
        Statement state=con.createStatement();
        String nomDeTable = o.getClass().getSimpleName();
        // String updating="UPDATE emp SET EMPNO='6590', ENAME='KANTO', JOB='HOTESSE_H', MGR='7839', HIREDATE='01-01-01', SAL='32', COMM='0', DEPTNO='10' WHERE ENAME='KANTOoo'";
        //          String updating="UPDATE "+nomDeTable+" SET "+ av_hupdate(o)+ " WHERE "+o.getClass().getDeclaredFields()[0].getName()+"='"+condition+"'";
        String updating="UPDATE "+nomDeTable+" SET "+ av_hupdate(o)+ " WHERE "+condition;
        System.out.println("UPDATE VITAAAAA"+updating);
         state.executeUpdate(updating);
        //    con.commit();
         con.close();
         state.close();
    }
    
     public static Vector<Object> select(String condition, Object ob) throws Exception ,InstantiationException, NoSuchMethodException{
        Connexion c = new Connexion();
        Connection con = c.connect();
        Statement state=con.createStatement();
        String nomDeTable = ob.getClass().getSimpleName();
        String select="select * from "+nomDeTable+" "+condition;
        System.out.println(select);
        Vector <Object> objects=new Vector<>();
        // getMethod(anarana fonction,type class )
        ResultSet result=state.executeQuery(select);
        while(result.next()){
            Object objet= ob.getClass().newInstance();
            for (int i = 0; i < objet.getClass().getDeclaredFields().length; i++) {
                String att = ob.getClass().getDeclaredFields()[i].getName();
                String Attribut_nom = upper(att);
                Class[] params;
                params = new Class[1];
                if (ob.getClass().getDeclaredFields()[i].getType().getName().equals("int")){
                    ob.getClass().getMethod("set"+Attribut_nom , params[0] = int.class).invoke(objet,result.getInt(i+1));
                    // System.out.println(ob.getClass().getMethod("set"+Attribut_nom , params[0] = int.class).invoke(objet,result.getInt(i+1)));
                }
                if (ob.getClass().getDeclaredFields()[i].getType().getName().equals("double")){
                    ob.getClass().getMethod("set"+Attribut_nom , params[0] = double.class).invoke(objet,result.getDouble(i+1));
                }
                if (ob.getClass().getDeclaredFields()[i].getType().getName().equals("java.lang.String")){
                    ob.getClass().getMethod("set"+Attribut_nom , params[0] = String.class).invoke(objet,result.getString(i+1));
                }
                if (ob.getClass().getDeclaredFields()[i].getType().getName().equals("java.sql.Date")){
                    ob.getClass().getMethod("set"+Attribut_nom, params[0] = Date.class).invoke(objet,result.getDate(i+1));
               
                }
                if (ob.getClass().getDeclaredFields()[i].getType().getName().equals("java.sql.Timestamp")){
                    ob.getClass().getMethod("set"+Attribut_nom, params[0] = Timestamp.class).invoke(objet,result.getTimestamp(i+1));
                }
            }
            objects.add(objet);
        }
        con.close();
        return objects;
    }
     
      
     public void update_with_id(Object o,String condition) throws Exception{
        String nomDeTable = o.getClass().getName();
        Statement state;
        Connection con = Connexion.connect();
        state = con.createStatement();
        // String updating="UPDATE emp SET EMPNO='6590', ENAME='KANTO', JOB='HOTESSE_H', MGR='7839', HIREDATE='01-01-01', SAL='32', COMM='0', DEPTNO='10' WHERE ENAME='KANTOoo'";
        String updating="UPDATE "+nomDeTable+" SET "+ av_hupdate(o)+ " WHERE "+o.getClass().getDeclaredFields()[0].getName()+"='"+condition+"'";
        System.out.println("UPDATE VITAAAAA"+updating);
        state.executeUpdate(updating);
         //    con.commit();
        state.close();
    }
     
     


    public static String [] change(Object o)throws Exception{
        String get="get";
        Object [] attribut=o.getClass().getDeclaredFields();
        String [] tab=new String[attribut.length];
        String [] izy=new String[attribut.length];
        for (int i = 0; i <attribut.length; i++) {
            tab[i]=new String();
            izy[i]=new String();

            tab[i]=get+upper(o.getClass().getDeclaredFields()[i].getName());
            if (o.getClass().getDeclaredFields()[i].getType()==Date.class){
                //    izy[i]="to_date('"+tab[i]+"','yyyy-mm-dd')";
                izy[i]="to_date('"+o.getClass().getMethod(tab[i]).invoke(o)+"','yyyy-mm-dd')";
                
            }
            if (o.getClass().getDeclaredFields()[i].getType()==String.class || o.getClass().getDeclaredFields()[i].getType()==Timestamp.class){
                izy[i]="'"+o.getClass().getMethod(tab[i]).invoke(o)+"'";
            }
            else if(o.getClass().getDeclaredFields()[i].getType() != Date.class && o.getClass().getDeclaredFields()[i].getType() != String.class){
                izy[i]=""+o.getClass().getMethod(tab[i]).invoke(o);
                System.out.println("izy : "+izy[i]);           
           }
        }
        return izy;
    }

    public static String concatenation(Object obj) throws Exception{ //ato le manambatra sisa
        String [] one=change(obj);
        String virgule=",";
        String fi=new String();
            for (int j = 0; j < one.length-1 ; j++) {   
                fi=fi+one[j]+virgule;
            }   
            fi=fi+one[one.length-1];
            System.out.println(fi);
        return fi;
    }


    public static String av_hupdate(Object objet) throws Exception{
        Object [] attribut=objet.getClass().getDeclaredFields();
        String [] tab=new String[attribut.length];
        String f=new String();
        for (int i = 0; i < attribut.length-1; i++) {
            // if(i!=4){
                tab[i]=new String();
                tab[i]="get"+upper(objet.getClass().getDeclaredFields()[i].getName());       
                f=f+objet.getClass().getDeclaredFields()[i].getName()+"='"+objet.getClass().getMethod(tab[i]).invoke(objet)+"', ";

            // }
        }
        f=f+objet.getClass().getDeclaredFields()[attribut.length-1].getName()+"='"+objet.getClass().getMethod("get"+upper(objet.getClass().getDeclaredFields()[attribut.length-1].getName())).invoke(objet)+"'";
    System.out.println(f);
        return f;
    }


    public String concat_vector(Vector<String>condi){
        String virgule=",";
        String fi=new String();
        if(condi.size()>=2){
            for (int j = 0; j < condi.size()-1 ; j++) {   
                fi=fi+condi.get(j)+virgule;
            }   
            fi=fi+condi.get(condi.size()-1);
        }
        else fi=fi+condi.get(0);
        return fi;
    }

    // GENERALISATION SANS AUTRE OBJET
    public static void updateObject(Object obj, String condition) throws Exception {
        Connection con = Connexion.connect();
        Statement state = con.createStatement();
        String tableName = obj.getClass().getSimpleName();
        String updating = "UPDATE " + tableName + " SET " + av_hupdateObject(obj) + " WHERE " + condition;
        System.out.println("UPDATE VITAAAAA : " + updating);
        state.executeUpdate(updating);
        con.close();
        state.close();
    }
    
    
   

    public static void insertObject(Object objet) throws Exception {
        Connection con = Connexion.connect();
        Statement state = con.createStatement();
        String tableName = objet.getClass().getSimpleName();
        String insertion = "INSERT INTO " + tableName + " (" + getColumnNames(objet) + ") VALUES (" + getColumnValues(objet) + ")";
        System.out.println(insertion);
        state.executeUpdate(insertion);
        con.close();
        state.close();
    }

        
    public static Vector<Object> selectObject(String condition, Object objet) throws Exception {
        Connection con = Connexion.connect();
        Statement state = con.createStatement();
        String tableName = objet.getClass().getSimpleName();
        String select = "SELECT * FROM " + tableName + " " + condition;
        System.out.println(select);
        Vector<Object> objects = new Vector<>();
        ResultSet result = state.executeQuery(select);
    
        while (result.next()) {
            Object instance = objet.getClass().newInstance();
            for (Field field : objet.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (isPrimitiveOrStringType(field.getType())) {
                    field.set(instance, result.getObject(fieldName));
                }
            }
            objects.add(instance);
        }
    
        con.close();
        return objects;
    }
    

    private static String getColumnNames(Object objet) {
        Field[] attributs = objet.getClass().getDeclaredFields();
        StringBuilder columnNames = new StringBuilder();
        boolean firstColumn = true;
    
        for (Field field : attributs) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (isPrimitiveOrStringType(field.getType())) {
                if (!firstColumn) {
                    columnNames.append(", ");
                }
                columnNames.append(fieldName);
                firstColumn = false;
            }
        }
        return columnNames.toString();
    }
    
    private static String getColumnValues(Object objet) throws Exception {
        Field[] attributs = objet.getClass().getDeclaredFields();
        StringBuilder columnValues = new StringBuilder();
        boolean firstColumn = true;
    
        for (Field field : attributs) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (isPrimitiveOrStringType(field.getType())) {
                if (!firstColumn) {
                    columnValues.append(", ");
                }
                columnValues.append("'").append(field.get(objet)).append("'");
                firstColumn = false;
            }
        }
        return columnValues.toString();
    }
    
     public static String av_hupdateObject(Object objet) throws Exception {
        Field[] attributs = objet.getClass().getDeclaredFields();
        StringBuilder f = new StringBuilder();
        boolean firstColumn = true;

        for (int i = 0; i < attributs.length - 1; i++) {
            Field field = attributs[i];
            field.setAccessible(true); // Pour accéder à un champ privé
            String fieldName = field.getName();
            if (isPrimitiveOrStringType(field.getType())) {
                if (!firstColumn) {
                    f.append(", ");
                }
                f.append(fieldName)
                        .append("='")
                        .append(field.get(objet))
                        .append("'");
                firstColumn = false;
            }
        }

        // Ajouter la dernière colonne sans la virgule
        Field lastField = attributs[attributs.length - 1];
        lastField.setAccessible(true);
        String lastFieldName = lastField.getName();
        if (isPrimitiveOrStringType(lastField.getType())) {
            if (!firstColumn) {
                f.append(", ");
            }
            f.append(lastFieldName)
                    .append("='")
                    .append(lastField.get(objet))
                    .append("'");
        }

        System.out.println(f);
        return f.toString();
    }

    private static boolean isPrimitiveOrStringType(Class<?> type) {
        return type.isPrimitive() || type.equals(Integer.class) || type.equals(Double.class) || type.equals(String.class) || type.equals(Timestamp.class) || type.equals(Date.class) || type.equals(Time.class);
    }


    // JUSTE DES OUTILS 

    public static String upper(String word){
        String lettre=String.valueOf(word.charAt(0)).toUpperCase();
        String reste=word.substring(1);
        String mot=lettre+reste;
        return mot;
    }  

    public static Date makeDate(String dateString) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(dateString);
        Date daty = new Date(utilDate.getTime());
        return daty;
    }

    public int maxi(Vector<Integer> max){
        int m=0;
        for (int i = 0; i < max.size(); i++) {
            if(m<=max.get(i)){
                m=max.get(i);
            }
        }
        return m;
    }

    public int somme(Vector<Integer> s){
        int a=0;
        for (int i = 0; i < s.size(); i++) {
            a=a+s.get(i);
        }
        return a;
    }

    // public String av_hist(Object objet) throws Exception{
    //     Object [] attribut=objet.getClass().getDeclaredFields();
    //     String [] tab=new String[attribut.length];
    //     String f=new String();
    //     for (int i = 0; i < attribut.length; i++) {
            
    //             tab[i]=new String();
    //             tab[i]="get"+objet.getClass().getDeclaredFields()[i].getName();       
    //             f=f+objet.getClass().getDeclaredFields()[i].getName()+":"+objet.getClass().getMethod(tab[i]).invoke(objet)+";";
    //     }
    //     return f;
    // }


        // public void historiser(Object Amodifier,Object ob,String table_name,Vector<String> condi)throws Exception{
    //     String a=(String)ob.getClass().getMethod("getID").invoke(ob);
    //     String b="id='"+a+"'";
    //     condi.add(b);
    //     select(table_name, condi, ob);
    //     insert("historique", Amodifier);
    // }        
    
   
}