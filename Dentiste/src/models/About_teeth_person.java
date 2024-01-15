package models;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import function.Dao;
public class About_teeth_person {
    int id_about_teeth_person ;
    int id_personne ;
    int id_teeth ;
    int etat ;
    public int getId_about_teeth_person() {
        return id_about_teeth_person;
    }
    public void setId_about_teeth_person(String id_about_teeth_person) {
        this.id_about_teeth_person = Integer.valueOf(id_about_teeth_person);
    }
    public int getId_personne() {
        return id_personne;
    }
    public void setId_personne(String id_personne) {
        this.id_personne = Integer.valueOf(id_personne);
    }
    public int getId_teeth() {
        return id_teeth;
    }
    public void setId_teeth(String id_teeth) {
        this.id_teeth = Integer.valueOf(id_teeth);
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = Integer.valueOf(etat);
    }
    public About_teeth_person() {
    } 
    public About_teeth_person(String id_about_teeth_person, String id_personne, String id_teeth, String etat) {
        setId_about_teeth_person(id_about_teeth_person);
        setId_personne(id_personne);
        setId_teeth(id_teeth);
        setEtat(etat);
    }
    public About_teeth_person(String id_personne, String id_teeth, String etat) {
        setId_personne(id_personne);
        setId_teeth(id_teeth);
        setEtat(etat);
    }
    public About_teeth_person [] getAllAbout_teeth_persons(Connection con) throws Exception {
        Object [] all = new Dao().getdonnees(con, this);
        About_teeth_person [] about = new About_teeth_person[all.length];
        for (int i = 0; i < about.length; i++) {
            about[i] = (About_teeth_person) all[i] ;
        }
        return about;
    }
    public int get_Etat_AfterTraitement(int etat , double price_traitement , double price_nettoyage , Personne personne){
        boolean arret = true ;
        int etat_entier = (etat) ;
        while(arret){
            if((personne.getArgent() < price_traitement) || (etat_entier > 6)){
                arret = false ;
            }else{
                if((etat_entier >= 4) &&  (etat_entier <= 6) ){
                    etat_entier += 1 ;
                    double reste_money = personne.getArgent() - price_traitement ;
                    personne.setArgent(reste_money);
                }
            }
        }
        System.out.println("argent apres traitement : " + personne.getArgent());
        if((etat_entier >= 7) && (etat_entier <=9)){
            int etat_final = get_Etat_AfterNettoyage(etat_entier, price_nettoyage, personne) ;
            return etat_final ;
        }
        return etat_entier ;
    }
    public int get_Etat_AfterNettoyage(int etat , double price_nettoyage , Personne personne){
        boolean arret = true ;
        int etat_entier = (etat) ;
        while(arret){
            if((personne.getArgent() < price_nettoyage) || (etat_entier > 9)){
                arret = false ;
            }else{
                if((etat_entier >= 7) &&  (etat_entier <= 9) ){
                    etat_entier += 1 ;
                    double reste_money = personne.getArgent() - price_nettoyage ;
                    personne.setArgent(reste_money);
                }
            }
        }
        System.out.println("argent apres nettoyagge : " + personne.getArgent());
        return etat_entier ;
    }
    public int get_Etat_AfterBroyer(int etat , double price_new_teeth , double price_take_teeth , Personne personne){
        int etat_entier = (etat) ;
        if(/*(price_new_teeth + price_take_teeth)*/ price_take_teeth <= personne.getArgent()){
            etat_entier = 0 ;
            personne.setArgent(personne.getArgent() - price_take_teeth);
            System.out.println("argent apres take teeth : " + personne.getArgent());
            etat_entier = getEtat_AfterPutTeeth(etat_entier, price_new_teeth, personne) ;
        }
        return etat_entier ;
    }
    public int getEtat_AfterPutTeeth(int etat , double price_new_teeth , Personne personne){
        if(personne.getArgent() >= price_new_teeth){
            etat = 10 ;
            personne.setArgent(personne.getArgent() - price_new_teeth);
        }
        System.out.println("argent apres new teeth : " + personne.getArgent());
        return etat ;
    }
    public Vector<Object> getNewTeeth_person(Connection con , Personne me  , int priorisation)throws Exception{
        List<About_teeth_person> new_teeth = new ArrayList<>();
        Vector<Object> content = new Vector<>();
        List<About_teeth_person> original_teeth = me.getAbout_teeth_persons(con);
        List<Teeth> teeths_menu = new Teeth().getTeethsPriorisation(con, priorisation);
        for (int i = 0; i < teeths_menu.size(); i++) {
            for (int j = 0; j < original_teeth.size(); j++) {
                if(original_teeth.get(j).id_teeth == teeths_menu.get(i).getId_teeth()){
                    double [] price = new Prix().Price_teeth_date(con, ""+me.getDate_come(), teeths_menu.get(i).getId_teeth());
                    if(original_teeth.get(j).getEtat() == 10){
                        new_teeth.add(original_teeth.get(j));
                    }
                    if(original_teeth.get(j).getEtat() == 0){
                        int teeth_etat_ = getEtat_AfterPutTeeth(original_teeth.get(j).getEtat(), price[0], me) ;
                        original_teeth.get(j).setEtat(""+teeth_etat_);
                        new_teeth.add(original_teeth.get(j));
                    }
                    if((original_teeth.get(j).getEtat() >=1) && (original_teeth.get(j).getEtat() <= 3)){
                        int teeth_etat_ = get_Etat_AfterBroyer(original_teeth.get(j).getEtat(), price[0], price[2], me);
                        original_teeth.get(j).setEtat(""+teeth_etat_);
                        new_teeth.add(original_teeth.get(j));
                    }
                    if((original_teeth.get(j).getEtat() >= 4) && (original_teeth.get(j).getEtat() <= 6)){
                        int teeth_etat_ = get_Etat_AfterTraitement(original_teeth.get(j).getEtat(), price[1], price[3], me) ;
                        original_teeth.get(j).setEtat(""+teeth_etat_);
                        new_teeth.add(original_teeth.get(j));
                    }
                    if((original_teeth.get(j).getEtat() >= 7) && (original_teeth.get(j).getEtat() <= 9)){
                        int teeth_etat_ = get_Etat_AfterNettoyage(original_teeth.get(j).getEtat(),price[3], me) ;
                        original_teeth.get(j).setEtat(""+teeth_etat_);
                        new_teeth.add(original_teeth.get(j));
                        
                    }
                }
            }
        }
        content.add(new_teeth);
        content.add(me.getArgent());
        return content;
    }
}
