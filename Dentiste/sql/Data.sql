-- plus
INSERT INTO Teeth (numero_teeth , emplacement , coefficient)
    VALUES 
        (1 , 0 , 160),
        (1 , 1 , 160),
        (2 , 0 , 150),
        (2 , 1 , 150),
        (3 , 0 , 140),
        (3 , 1 , 140),
        (4 , 0 , 130),
        (4 , 1 , 130),
        (5 , 0 , 120),
        (5 , 1 , 120),
        (6 , 0 , 110),
        (6 , 1 , 110),
        (7 , 0 , 100),
        (7 , 1 , 100),
        (8 , 0 , 90),
        (8 , 1 , 90),
        (9 , 0 , 90),
        (9 , 1 , 90),
        (10 , 0 , 100),
        (10 , 1 , 100),
        (11 , 0 , 110),
        (11 , 1 , 110),
        (12 , 0 , 120),
        (12 , 1 , 120),
        (13 , 0 , 130),
        (13 , 1 , 130),
        (14 , 0 , 140),
        (14 , 1 , 140),
        (15 , 0 , 150),
        (15 , 1 , 150),
        (16 , 0 , 160),
        (16 , 1 , 160) ;
INSERT INTO Prix (id_teeth , price_new_teeth , price_traite_teeth,Date_price,price_traitement , price_nettoyage)
    VALUES
        (1 , 10000 , 3000 , current_date , 6000 , 1000) ,
        (2 , 10000 , 3000 , current_date , 6000 , 1000) ,
        (3 , 9000 , 3000 , current_date , 6000 , 1000) ,
        (4 , 9000 , 3000 , current_date , 6000 , 1000) ,
        (5 , 8000 , 3000 , current_date , 6000 , 1000) ,
        (6 , 8000 , 3000 , current_date , 6000 , 1000) ,
        (7 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (8 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (9 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (10 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (11 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (12 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (13 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (14 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (15 , 15000 , 3000 , current_date , 6000 , 1000) ,
        (16 , 15000 , 3000 , current_date , 6000 , 1000) ,
        (17 , 15000 , 3000 , current_date , 6000 , 1000) ,
        (18 , 15000 , 3000 , current_date , 6000 , 1000) ,
        (19 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (20 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (21 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (22 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (23 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (24 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (25 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (26 , 5000 , 3000 , current_date , 6000 , 1000) ,
        (27 , 8000 , 3000 , current_date , 6000 , 1000) ,
        (28 , 8000 , 3000 , current_date , 6000 , 1000) ,
        (29 , 9000 , 3000 , current_date , 6000 , 1000) ,
        (30 , 9000 , 3000 , current_date , 6000 , 1000) ,
        (31 , 10000 , 3000 , current_date , 6000 , 1000) ,
        (32 , 10000 , 3000 , current_date , 6000 , 1000) ;
-- personne

    INSERT INTO personne (name_Personne , datenaissance , argent , Date_come) 
    VALUES 
        ('Fitia' , '2005-04-12','95000', current_date);
-- about_teeth_person
INSERT INTO About_teeth_person (id_personne , id_teeth , etat)
    VALUES
        (1 , 1 , 9),
        (1 , 2 , 8),
        (1 , 3 , 4),
        (1 , 4 , 10),
        (1 , 5 , 10),
        (1 , 6 , 10),
        (1 , 7 , 10),
        (1 , 8 , 10),
        (1 , 9 , 1),
        (1 , 10 , 9),
        (1 , 11 , 5),
        (1 , 12 , 7),
        (1 , 13 , 10),
        (1 , 14 , 10),
        (1 , 15 , 10),
        (1 , 16 , 10),
        (1 , 17 , 10),
        (1 , 18 , 6),
        (1 , 19 , 0),
        (1 , 20 , 10),
        (1 , 21 , 9),
        (1 , 22 , 9),
        (1 , 23 , 7),
        (1 , 24 , 6),
        (1 , 25 , 4),
        (1 , 26 , 5),
        (1 , 27 , 3),
        (1 , 28 , 7),
        (1 , 29 , 9),
        (1 , 30 , 6),
        (1 , 31 , 7),
        (1 , 32 , 9);



        INSERT INTO personne (name_Personne , datenaissance , argent , Date_come) 
    VALUES 
        ('Kalo' , '2006-04-12','95000', current_date);
-- about_teeth_person
INSERT INTO About_teeth_person (id_personne , id_teeth , etat)
    VALUES
        (3 , 1 , 9),
        (3 , 2 , 8),
        (3 , 3 , 4),
        (3 , 4 , 10),
        (3 , 5 , 10),
        (3 , 6 , 10),
        (3 , 7 , 10),
        (3 , 8 , 10),
        (3 , 9 , 1),
        (3 , 10 , 9),
        (3 , 11 , 5),
        (3 , 12 , 7),
        (3 , 13 , 10),
        (3 , 14 , 10),
        (3 , 15 , 10),
        (3 , 16 , 10),
        (3 , 17 , 10),
        (3 , 18 , 6),
        (3 , 19 , 0),
        (3 , 20 , 10),
        (3 , 21 , 9),
        (3 , 22 , 9),
        (3 , 23 , 7),
        (3 , 24 , 6),
        (3 , 25 , 4),
        (3 , 26 , 5),
        (3 , 27 , 3),
        (3 , 28 , 7),
        (3 , 29 , 9),
        (3 , 30 , 6),
        (3 , 31 , 7),
        (3 , 32 , 9);


        -- about_teeth_person
INSERT INTO About_teeth_person (id_personne , id_teeth , etat)
    VALUES
        (1 , 1 , 9),
        (1 , 2 , 8),
        (1 , 3 , 4),
        (1 , 4 , 10),
        (1 , 5 , 10),
        (1 , 6 , 10),
        (1 , 7 , 10),
        (1 , 8 , 10),
        (1 , 9 , 1),
        (1 , 10 , 9),
        (1 , 11 , 5),
        (1 , 12 , 7),
        (1 , 13 , 10),
        (1 , 14 , 10),
        (1 , 15 , 10),
        (1 , 16 , 10),
        (1 , 17 , 10),
        (1 , 18 , 6),
        (1 , 19 , 0),
        (1 , 20 , 10),
        (1 , 21 , 9),
        (1 , 22 , 9),
        (1 , 23 , 7),
        (1 , 24 , 6),
        (1 , 25 , 4),
        (1 , 26 , 5),
        (1 , 27 , 3),
        (1 , 28 , 7),
        (1 , 29 , 9),
        (1 , 30 , 6),
        (1 , 31 , 7),
        (1 , 32 , 9);


         INSERT INTO personne (name_Personne , datenaissance , argent , Date_come) 
    VALUES 
        ('Autre' , '2000-04-12','95000', current_date);

        INSERT INTO personne (name_Personne , datenaissance , argent , Date_come) 
    VALUES 
        ('Autre' , '2003-04-12','1900', current_date);