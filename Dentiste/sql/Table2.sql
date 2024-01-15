CREATE DATABASE Dentiste2;
\c Dentiste2
-- emplacement haut ou bas  : 0 haut et 1 bas
-- coefficients pour la priorisation 

CREATE TABLE IF NOT EXISTS Teeth(
    id_teeth SERIAL PRIMARY KEY ,
    numero_teeth int ,
    emplacement int , 
    coefficient int
);
CREATE TABLE IF NOT EXISTS Prix(
    id_prix SERIAL PRIMARY KEY ,
    id_teeth int REFERENCES Teeth(id_teeth) ,
    price_new_teeth float ,
    price_traite_teeth float ,
    Date_price date
);
ALTER TABLE Prix Add Column price_traitement float ;
ALTER TABLE Prix Add Column price_nettoyage float ;
CREATE TABLE IF NOT EXISTS Personne(
    id_personne SERIAL PRIMARY KEY ,
    name_Personne varchar(255) NOT NULL,
    datenaissance Date ,
    argent float ,
    Date_come date
);
CREATE TABLE IF NOT EXISTS About_teeth_person(
    id_about_teeth_person SERIAL PRIMARY KEY ,
    id_personne int REFERENCES Personne(id_personne) ,
    id_teeth int REFERENCES Teeth(id_teeth) ,
    etat int 
);
-- etat  : 
    --  0 : sans dent 
    -- [1 , 3] : broyer 
    -- [4 , 6] : Traitement 
    -- [7 , 9] : Nettoyagge
    -- 10 : perfect 









      INSERT INTO personne (name_Personne , datenaissance , argent , Date_come) 
    VALUES 
        ('Fitia' , '2005-04-12','95000', current_date);
-- about_teeth_person
INSERT INTO About_teeth_person (id_personne , id_teeth , etat)
    VALUES
        (2 , 1 , 9),
        (2 , 2 , 8),
        (2 , 3 , 4),
        (2 , 4 , 10),
        (2 , 5 , 10),
        (2 , 6 , 10),
        (2 , 7 , 10),
        (2 , 8 , 10),
        (2 , 9 , 1),
        (2 , 10 , 9),
        (2 , 11 , 5),
        (2 , 12 , 7),
        (2 , 13 , 10),
        (2 , 14 , 10),
        (2 , 15 , 10),
        (2 , 16 , 10),
        (2 , 17 , 10),
        (2 , 18 , 6),
        (2 , 19 , 0),
        (2 , 20 , 10),
        (2 , 21 , 9),
        (2 , 22 , 9),
        (2 , 23 , 7),
        (2 , 24 , 6),
        (2 , 25 , 4),
        (2 , 26 , 5),
        (2 , 27 , 3),
        (2 , 28 , 7),
        (2 , 29 , 9),
        (2 , 30 , 6),
        (2 , 31 , 7),
        (2 , 32 , 9);
