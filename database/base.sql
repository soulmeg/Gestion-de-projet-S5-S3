\c postgres
drop database meubles;
create database meubles;
\c meubles

create sequence seq_Style;
create sequence seq_Materiel;
create sequence seq_PrixMateriel;
create sequence seq_StyleMateriel;
create sequence seq_Categorie;
create sequence seq_Volume;
create sequence seq_QuantiteMateriel;
create sequence seq_StockEntrer;
create sequence seq_StockSortie;
create sequence seq_FabricationMeuble;
create sequence seq_DureeFabricationProduit;
create sequence seq_Personne;
create sequence seq_Role;
create sequence seq_Employe;
create sequence seq_SalaireEmploye;
create sequence seq_EmployeFabrication;
create sequence seq_PrixDeVente;
create sequence seq_Meuble;
create sequence seq_Experience;
create sequence seq_TauxExperience;
create sequence seq_Grade;

create table categorie(
    id_categorie varchar(10) primary key,
    nom varchar(50)
);

create table Style(
    id_style varchar(10) primary key,
    nom varchar(50)
);

create table Materiel(
    id_materiel varchar(10) primary key,
    nom varchar(50)
);

create table PrixMateriel(
    id varchar(10) primary key,
    id_materiel varchar(10) references Materiel(id_materiel),
    prix double precision,
    datePrix date
);

create table StockEntrer(
    id varchar(10) primary key,
    id_materiel varchar(10) references Materiel(id_materiel),
    quantite double precision,
    dateEntrer date
);

create table StockSortie(
    id varchar(10) primary key,
    id_materiel varchar(10) references Materiel(id_materiel),
    quantite double precision,
    dateSortie date
);

create table StyleMateriel(
    id varchar(10) primary key,
    id_style varchar(50) references style(id_style),
    id_materiel varchar(50) references Materiel(id_materiel),
    nom varchar(50)
);

create table Volume(
    id_volume varchar(10) primary key,
    volume varchar(50)
);

create table QuantiteMateriel(
    id varchar(10) primary key,
    id_categorie varchar(10) references categorie(id_categorie),
    id_styleMateriel varchar(10) references StyleMateriel(id),
    id_volume varchar(10) references volume(id_volume),
    quantite double precision
);

create table Personne(
    id_personne varchar(10) primary key,
    nom varchar(50),
    prenom varchar(50),
    dateNaissance Date,
    sexe varchar(10)
);

Create table Grade(
    id varchar(10) primary key,
    nom varchar(50)
);

create table Role(
    id_role varchar(10) primary key,
    id_grade varchar(10) references Grade(id),
    role varchar(50)
);

create table Experience(
    id varchar(10) primary key,
    id_grade varchar(10) references Grade(id),
    annee int
);

create table TauxExperience(
    id varchar(10) primary key,
    id_grade varchar(10) references Grade(id),
    nombreTaux int
);

create table Employe(
    id_employe varchar(10) primary key,
    id_personne varchar(10) references Personne(id_personne),
    id_role varchar(10) references role(id_role),
    date_embauche date
);

create table SalaireEmploye(
    id varchar(10) primary key,
    id_role varchar(10) references Role(id_role),
    tauxHoraire double precision
);

create table Meuble(
    id varchar(50) primary key,
    id_categorie varchar(10),
    id_style varchar(10),
    nom_meuble varchar(50)
);

create table FabricationMeuble(
    id varchar(10) primary key,
    id_meuble varchar(10) references Meuble(id),
    id_volume varchar(10) references volume(id_volume),
    quantite double precision,
    dateFabrication date
);

create table DureeFabricationProduit(
    id varchar(10) primary key,
    id_meuble varchar(10) references Meuble(id),
    id_volume varchar(10) references Volume(id_volume),
    id_role varchar(10) references Role(id_role),
    duree double precision
);

create table EmployeFabrication(
    id varchar(10) primary key,
    id_meuble varchar(10) references Meuble(id),
    id_volume varchar(10) references Volume(id_volume),
    id_role varchar(10) references Role(id_role),
    nombre int
);

create table PrixDeVente(
    id varchar(10) primary key,
    id_meuble varchar(10) references Meuble(id),
    id_volume varchar(10) references Volume(id_volume),
    prixDeVente double precision,
    date_prix date
);
