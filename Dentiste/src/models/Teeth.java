package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import function.Dao;

public class Teeth {
    int id_teeth ;
    int numero_teeth ;
    int emplacement ; 
    int coefficient ;
    public int getId_teeth() {
        return id_teeth;
    }
    public void setId_teeth(String id_teeth) {
        this.id_teeth = Integer.valueOf(id_teeth);
    }
    public int getNumero_teeth() {
        return numero_teeth;
    }
    public void setNumero_teeth(String numero_teeth) {
        this.numero_teeth = Integer.valueOf(numero_teeth);
    }
    public int getEmplacement() {
        return emplacement;
    }
    public void setEmplacement(String emplacement) {
        this.emplacement = Integer.valueOf(emplacement);
    }
    public int getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(String coefficient) {
        this.coefficient = Integer.valueOf(coefficient);
    }
    public Teeth() {
    }
    public Teeth(String id_teeth, String numero_teeth, String emplacement, String coefficient) {
        setId_teeth(id_teeth);
        setNumero_teeth(numero_teeth);
        setEmplacement(emplacement);
        setCoefficient(coefficient);
    }
    public Teeth [] allTeeths(Connection con) throws Exception {
        Object [] object_teeths = new Dao().getdonnees(con, this);
        Teeth [] teeths = new Teeth[object_teeths.length];
        for (int i = 0; i < teeths.length; i++) {
            teeths[i] = (Teeth) object_teeths[i];
        }
        return teeths ;
    }
    public Teeth getTeeth(Connection con , int id_teeth)throws Exception{
        Teeth [] alTeeths = allTeeths(con) ;
        for (int i = 0; i < alTeeths.length; i++) {
            if(alTeeths[i].getId_teeth() == id_teeth){
                return alTeeths[i];
            }
        }
        return null;
    }
    public List<Teeth> getTeethsPriorisation(Connection con , int priorisation){
        List<Teeth> allTeeths = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sql = "" ;
            if(priorisation == 0){
                // beaute
                // script au cas ou ambony daoly izay vao ambany 
                // emplacement , coefficient , numero_teeth
                sql = "SELECT * FROM teeth order by coefficient , numero_teeth , emplacement" ;
            }else{
                // sanitaire
                // emplacement , coefficient , numero_teeth
                sql = "SELECT * FROM teeth order by coefficient  DESC , numero_teeth , emplacement ASC" ;
            }
            ResultSet results = statement.executeQuery(sql);
            while(results.next()){
                allTeeths.add(new Teeth(results.getString("id_teeth"), results.getString("numero_teeth") , results.getString("emplacement") , results.getString("coefficient")));
            }    
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allTeeths ;
    }
    public String getPosition(){
        if(this.emplacement == 0){
            return "Haut";
        } 
        return "Bas";
    }
}
