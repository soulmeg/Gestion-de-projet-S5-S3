insert into volume values
    ('VOL00'|| nextval('seq_Volume'),'PETIT'),
    ('VOL00'|| nextval('seq_Volume'),'GRAND');

insert into categorie values
    ('CA00'|| nextval('seq_Categorie'),'CANAPE');


insert into Style values    
    ('STY00'|| nextval('seq_Style'),'BOHEME');

insert into Materiel values 
    ('MA00' || nextval('seq_Materiel'),'FIL');

insert into PrixMateriel values
    ('PRM' || nextval('seq_PrixMateriel'),'MA001',30,'2024-01-15');


insert into StyleMateriel values
    ('ST00' || nextval('seq_StyleMateriel'),'STY001','MA001','BOHEME-FIL');
    
insert into QuantiteMateriel values
    ('QU00' || nextval('seq_QuantiteMateriel'),'CA001','ST001','VOL001',100);

insert into Meuble values
    ('MEU00' || nextval('seq_Meuble'),'CA001','STY001','CANAPE-BOHEME');

-- DONNE VAOVAO

insert into Role values
    ('ROLE' || nextval('seq_Role'),'Expert'),
    ('ROLE' || nextval('seq_Role'),'Ouvrier');


inSert into SalaireEmploye values 
    ('SAE' || nextval('seq_SalaireEmploye'),'ROLE1',1000),
    ('SAE' || nextval('seq_SalaireEmploye'),'ROLE2',2000);


-- -- iretoo---
insert into DureeFabricationProduit values
    ('FM' || nextval('seq_DureeFabricationProduit'),'MEU001','VOL001','ROLE1',3);


insert into Personne values
    ('PERS' || nextval('seq_Personne'),'RAKOTO','Ando','2003-02-02','feminin');
insert into Personne values
    ('PERS' || nextval('seq_Personne'),'RABE','Mino','2000-02-12','Masculin');


insert into Employe values
    ('EMP' || nextval('seq_Employe'),'PERS1','ROLE1'),
    ('EMP' || nextval('seq_Employe'),'PERS2','ROLE2');


insert into EmployeFabrication values
    ('EMPF' || nextval('seq_EmployeFabrication'),'MEU001','VOL001','ROLE1',2);

insert into PrixDeVente values
    ('PDV' ||  nextval('seq_PrixDeVente'), 'MEU001','VOL001',15000);


