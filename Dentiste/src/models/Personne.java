package models;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import function.Dao;
public class Personne {
    int id_personne ;
    String name_Personne ;
    Date datenaissance ;
    double argent ;
    Date date_come ;
    public int getId_personne() {
        return id_personne;
    }
    public void setId_personne(String id_personne) {
        this.id_personne = Integer.valueOf(id_personne);
    }
    public String getName_Personne() {
        return name_Personne;
    }
    public void setName_Personne(String name_Personne) {
        this.name_Personne = name_Personne;
    }
    public Date getDatenaissance() {
        return datenaissance;
    }
    public void setDatenaissance(String datenaissance) {
        this.datenaissance =  Date.valueOf(datenaissance);
    }
    public double getArgent() {
        return argent;
    }
    public void setArgent(String argent) {
        this.argent = Double.valueOf(argent) ;
    }
    public void setArgent(double argent) {
        this.argent = argent;
    }
    public Date getDate_come() {
        return date_come;
    }
    public void setDate_come(String date_come) {
        this.date_come = Date.valueOf(date_come);
    }
    public Personne(){}
    public Personne(String id_personne, String name_Personne, String datenaissance, String argent, String date_come) {
      setId_personne(id_personne);
      setName_Personne(name_Personne);
      setDatenaissance(datenaissance);
      setArgent(argent);
      setDate_come(date_come);
    }
    public Personne [] getallPersonnes(Connection con)throws Exception{
        Object [] object_personnes = new Dao().getdonnees(con, this);
        Personne [] personnes = new Personne[object_personnes.length];
        for (int i = 0; i < personnes.length; i++) {
            personnes[i] = (Personne) object_personnes[i];
        }
        return personnes ;
    }
    public List<About_teeth_person> getAbout_teeth_persons(Connection con)throws Exception{
        List<About_teeth_person> about = new ArrayList<>();
        About_teeth_person [] about_teeth_persons = new About_teeth_person().getAllAbout_teeth_persons(con);
        for (int i = 0; i < about_teeth_persons.length; i++) {
            if(about_teeth_persons[i].getId_personne() == this.getId_personne()) {
                about.add(about_teeth_persons[i]);
            }
        }
        return about;
    }
    public Personne getMe(Connection con , int id_personne)throws Exception{
        Personne [] getPersonnes = getallPersonnes(con);
        for (int i = 0; i < getPersonnes.length; i++) {
            if(getPersonnes[i].id_personne == id_personne){
                return getPersonnes[i];
            }
        }
        return null;
    }
    public int getMyAge(){
        return Integer.valueOf("" + LocalDate.now().getYear()) - Integer.valueOf((""+this.datenaissance).split("-")[0]);
    }
}
