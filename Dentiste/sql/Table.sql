CREATE DATABASE Dentiste;

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