package main;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import connect.Connect;
import models.About_teeth_person;
import models.Personne;
public class Main{
    public static void main(String[] args) {
        int age = Integer.valueOf("" + LocalDate.now().getYear()) - Integer.valueOf("19");
        System.out.println(age);
        
    }
}