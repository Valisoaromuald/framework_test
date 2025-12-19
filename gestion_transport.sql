CREATE TABLE parametre(
   id SERIAL,
   code VARCHAR(50) NOT NULL,
   description VARCHAR(50) NOT NULL,
   valeur VARCHAR(50) NOT NULL,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE arret(
   id SERIAL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE ligne(
   id SERIAL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE parametrage(
   id SERIAL,
   heure_premier_bus TIME NOT NULL,
   frequence_min INT NOT NULL CHECK(frequence_min > 0),
   PRIMARY KEY(id) 
);

CREATE TABLE parametre(
   id SERIAL,
   code VARCHAR(50) NOT NULL,
   description VARCHAR(50) NOT NULL,
   valeur VARCHAR(50) NOT NULL,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE arret(
   id SERIAL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE ligne(
   id SERIAL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE parametrage(
   id SERIAL,
   heure_premier_bus TIME NOT NULL,
   frequence_min INT NOT NULL CHECK(frequence_min > 0),
   PRIMARY KEY(id) 
);


CREATE TABLE trajet_bus(
   id SERIAL,
   duree_stationnement TIME NOT NULL,
   duree_prochain_arret TIME NOT NULL,
   type_trajet INT NOT NULL,
   id_ligne_arret INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_ligne_arret) REFERENCES ligne_arret(id)
);

CREATE TABLE ligne_arret(
   id SERIAL,
   id_arret INT NOT NULL,
   id_ligne INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_arret) REFERENCES arret(id),
   FOREIGN KEY(id_ligne) REFERENCES ligne(id)
);

CREATE TABLE bus(
   id SERIAL,
   nom VARCHAR(50) NOT NULL,
   id_ligne INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_ligne) REFERENCES ligne(id)
);

CREATE TABLE ligne_arret(
   id SERIAL,
   id_arret INT NOT NULL,
   id_ligne INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_arret) REFERENCES arret(id),
   FOREIGN KEY(id_ligne) REFERENCES ligne(id)
);



Insert into parametrage(heure_premier_bus,frequence_min)
values('05:00',15)
on conflict(id) do update
set heure_premier_bus = EXCLUDED.heure_premier_bus,
   frequence_min = EXCLUDED.frequence_min;

--fonction qui sert à savoir l'heure du prochain bus
CREATE OR REPLACE FUNCTION prochain_bus(p_arrivee time)
RETURNS time
LANGUAGE plpgsql
AS $$
DECLARE
      v_premier time;
      v_freq int;
      v_result time;
BEGIN
      -- 1) Recuperation des parametres (1 seule ligne)
      select heure_premier_bus,frequence_min
      into v_premier ,v_freq 
      from parametrage
      where id=1;

if v_premier is null or v_freq is null then
raise exception 'Parametrage manquant (id) dans la table parametrage';
end if;

if p_arrivee <= v_premier then
return v_premier;
end if;

v_result:= v_premier
            +ceil(
               extract(epoch from (p_arrivee-v_premier))/60.0/v_freq
            )*make_interval(mins=>v_freq);
return v_result;
end;
$$;



--fonction qui sert à savoir à quelle heure on arrive à un arret en partant d'un arret
create or replace function