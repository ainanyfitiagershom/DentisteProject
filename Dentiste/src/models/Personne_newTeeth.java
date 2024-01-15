package models;

import java.sql.Connection;
import java.util.List;
import java.util.Vector;

public class Personne_newTeeth {
    Personne client ;
    List<New_teeth_person> teeth_personne ;
    Vector<Object> new_teeth_person ;
    public Personne_newTeeth() {}
    public Personne_newTeeth(Personne client, List<New_teeth_person> teeth_personne,Vector<Object> new_teeth_person) {
        this.client = client;
        this.teeth_personne = teeth_personne;
        this.new_teeth_person = new_teeth_person;
    }
    public Personne getClient() {
        return client;
    }
    public void setClient(Personne client) {
        this.client = client;
    }
    public List<New_teeth_person> getTeeth_personne() {
        return teeth_personne;
    }
    public void setTeeth_personne(List<New_teeth_person> teeth_personne) {
        this.teeth_personne = teeth_personne;
    }
    public Vector<Object> getNew_teeth_person() {
        return new_teeth_person;
    }
    public void setNew_teeth_person(Vector<Object> new_teeth_person) {
        this.new_teeth_person = new_teeth_person;
    }
    public Personne_newTeeth [] getAllDonnee(Connection con)throws Exception{
        Personne [] client = new Personne().getallPersonnes(con);
        Personne_newTeeth [] all_donnee = new Personne_newTeeth[client.length];
        for (int i = 0; i < client.length; i++) {
            List<About_teeth_person> original = client[i].getAbout_teeth_persons(con);
            List<New_teeth_person> about = new New_teeth_person().getNew_teeth_people(con, original);
            // 1 priorisation par defaut
            Vector<Object> myteeth = new About_teeth_person().getNewTeeth_person(con, client[i], 1);
            List<About_teeth_person> teeth_new_personne = (List<About_teeth_person>) myteeth.elementAt(0);
            double reste_money = (double) myteeth.elementAt(1);
            List<New_teeth_person> teeth_new_data = new New_teeth_person().getNew_teeth_people(con , teeth_new_personne);
            Vector<Object> containt_new_data = new Vector<>() ;
            containt_new_data.add(teeth_new_data);
            containt_new_data.add(reste_money) ; 
            all_donnee[i] = new Personne_newTeeth(client[i] , about , containt_new_data) ;
        }
        return all_donnee ;
    }
}
