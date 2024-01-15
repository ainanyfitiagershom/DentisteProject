package models;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import function.Dao;
public class Prix {
    int id_prix ;
    int id_teeth ;
    double price_new_teeth ;
    double price_traite_teeth ;
    Date date_price ;
    double price_traitement ;
    double price_nettoyage ;
    public int getId_prix() {
        return id_prix;
    }
    public void setId_prix(String id_prix) {
        this.id_prix = Integer.valueOf(id_prix);
    }
    public int getId_teeth() {
        return id_teeth;
    }
    public void setId_teeth(String id_teeth) {
        this.id_teeth = Integer.valueOf(id_teeth);
    }
    public double getPrice_new_teeth() {
        return price_new_teeth;
    }
    public void setPrice_new_teeth(String price_new_teeth) {
        this.price_new_teeth = Double.valueOf(price_new_teeth);
    }
    public double getPrice_traite_teeth() {
        return price_traite_teeth;
    }
    public void setPrice_traite_teeth(String price_traite_teeth) {
        this.price_traite_teeth = Double.valueOf(price_traite_teeth);
    }
    public Date getDate_price() {
        return date_price;
    }
    public void setDate_price(String date_price) {
        this.date_price = Date.valueOf(date_price);
    }
    public double getPrice_traitement() {
        return price_traitement;
    }
    public void setPrice_traitement(String price_traitement) {
        this.price_traitement = Double.valueOf(price_traitement);
    }
    public double getPrice_nettoyage() {
        return price_nettoyage;
    }
    public void setPrice_nettoyage(String price_nettoyage) {
        this.price_nettoyage = Double.valueOf(price_nettoyage);
    }
    public Prix(){}
    public Prix(String id_prix, String id_teeth, String price_new_teeth, String price_traite_teeth, String date_price, String price_traitement , String price_nettoyage) {
        setId_prix(id_prix);
        setId_teeth(id_teeth);
        setPrice_new_teeth(price_new_teeth);
        setPrice_traite_teeth(price_traite_teeth);
        setDate_price(date_price);
        setPrice_traitement(price_traitement);
        setPrice_nettoyage(price_nettoyage);
    }
    public Prix [] getAllPrice(Connection con)throws Exception{
        Object [] object_prices = new Dao().getdonnees(con, this);
        Prix [] all_prix  = new Prix[object_prices.length];
        for (int i = 0; i < all_prix.length; i++) {
            all_prix[i] = (Prix) object_prices[i];
        }
        return all_prix;
    }
    public List<Prix> Price_in_date(Connection con , String date)throws Exception{
        List<Prix> all_prix = new ArrayList<>();
        Prix [] getPrix = getAllPrice(con);
        for (int i = 0; i < getPrix.length; i++) {
            if(getPrix[i].date_price.equals(Date.valueOf(date))){
                all_prix.add(getPrix[i]);
            }
        }
        return all_prix ;
    }
    public double [] Price_teeth_date(Connection con , String date , int id_teeth) throws Exception{
        List<Prix> allprix = Price_in_date(con, date);
        double [] price = { 0 , 0 , 0 , 0} ;
        for (int i = 0; i < allprix.size(); i++) {
            if(allprix.get(i).getId_teeth() == id_teeth){
                price[0] = allprix.get(i).getPrice_new_teeth() ;
                price[1] = allprix.get(i).getPrice_traite_teeth();
                price[2] = allprix.get(i).getPrice_traitement() ; // take_teeth
                price[3] = allprix.get(i).getPrice_nettoyage();
            }
        }
        return price;
    }
}
