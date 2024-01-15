package models;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
public class New_teeth_person {
    int numeroDent ;
    String emplacement ;
    int	etat;
    String classe_css ;
    public int getNumeroDent() {
        return numeroDent;
    }
    public void setNumeroDent(int numeroDent) {
        this.numeroDent = numeroDent;
    }
    public String getEmplacement() {
        return emplacement;
    }
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public String getClasse_css() {
        return classe_css;
    }
    public void setClasse_css(String classe_css) {
        this.classe_css = classe_css;
    }
    public New_teeth_person(){}
    public New_teeth_person(int numeroDent, String emplacement, int etat, String classe_css) {
        this.numeroDent = numeroDent;
        this.emplacement = emplacement;
        this.etat = etat;
        this.classe_css = classe_css;
    }
    public List<New_teeth_person> getNew_teeth_people(Connection con , List<About_teeth_person> new_teeth) throws Exception {
        List<New_teeth_person> new_teets_new = new ArrayList<>();
        for(int i = 0 ; i< new_teeth.size() ; i++) {
            Teeth about_teeth = new Teeth().getTeeth(con, new_teeth.get(i).getId_teeth());
            if(new_teeth.get(i).getEtat() == 5 || new_teeth.get(i).getEtat() == 6 || new_teeth.get(i).getEtat() == 4){
                new_teets_new.add(new New_teeth_person(about_teeth.getNumero_teeth(), about_teeth.getPosition(), new_teeth.get(i).getEtat(), "traitement"));
            }
            if(new_teeth.get(i).getEtat() == 1 || new_teeth.get(i).getEtat() == 2 || new_teeth.get(i).getEtat() == 3){
                new_teets_new.add(new New_teeth_person(about_teeth.getNumero_teeth(), about_teeth.getPosition(), new_teeth.get(i).getEtat(), "broyer"));
            }
            if(new_teeth.get(i).getEtat() == 7 || new_teeth.get(i).getEtat() == 8 || new_teeth.get(i).getEtat() == 9){
                new_teets_new.add(new New_teeth_person(about_teeth.getNumero_teeth(), about_teeth.getPosition(), new_teeth.get(i).getEtat(), "nettoyage"));
            }
            if(new_teeth.get(i).getEtat() == 0){
                new_teets_new.add(new New_teeth_person(about_teeth.getNumero_teeth(), about_teeth.getPosition(), new_teeth.get(i).getEtat(), "null"));
            }
            if(new_teeth.get(i).getEtat() == 10){
                new_teets_new.add(new New_teeth_person(about_teeth.getNumero_teeth(), about_teeth.getPosition(), new_teeth.get(i).getEtat(), "ok"));
            }
        }
        return new_teets_new;
    }
}
