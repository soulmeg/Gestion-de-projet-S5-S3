create or replace view v_StyleMateriel as
select
    StyleMateriel.id_style as id,
    Materiel.id_materiel,
    Materiel.nom
from StyleMateriel
join Materiel 
on StyleMateriel.id_materiel = Materiel.id_materiel;


create or replace View V_QuantiteMateriel as 
select
    QuantiteMateriel.id,
    StyleMateriel.id_materiel,
    Materiel.nom as nom_materiel,
    categorie.id_categorie,
    categorie.nom as nom_categorie,
    Style.id_style,
    Style.nom as nom_style,
    Volume.id_volume,
    Volume.volume,
    QuantiteMateriel.quantite
from QuantiteMateriel
JOIN categorie
on categorie.id_categorie = QuantiteMateriel.id_categorie
join Volume 
on volume.id_volume = QuantiteMateriel.id_volume
join StyleMateriel 
on StyleMateriel.id = QuantiteMateriel.id_styleMateriel
JOIN Style 
on Style.id_style = StyleMateriel.id_style
join Materiel
on Materiel.id_materiel = StyleMateriel.id_materiel;



create or replace view V_PrixMeuble as
select
    Categorie.id_categorie,
    categorie.nom as nom_categorie,
    Style.id_style,
    Style.nom as nom_style,
    Volume.id_volume,
    Volume.volume,
    sum(PrixMateriel.prix*QuantiteMateriel.quantite) as prix
from QuantiteMateriel 
join categorie
on QuantiteMateriel.id_categorie = categorie.id_categorie
join StyleMateriel
on StyleMateriel.id = QuantiteMateriel.id_styleMateriel
join Volume 
on volume.id_volume = QuantiteMateriel.id_volume
join style 
on Style.id_style = StyleMateriel.id_style
join Materiel
on StyleMateriel.id_materiel = Materiel.id_materiel
join PrixMateriel
on PrixMateriel.id_materiel = StyleMateriel.id_materiel
group by Categorie.id_categorie,Style.id_style,Volume.id_volume,nom_categorie,nom_style,volume;




CREATE OR REPLACE VIEW V_Mouvement AS
SELECT
    M.id_materiel,
    M.nom,
    COALESCE(Entrees.sumStockEntrer, 0) AS sumEntrer,
    COALESCE(Sorties.sumStockSortie, 0) AS sumSortie,
    COALESCE(Entrees.sumStockEntrer, 0) - COALESCE(Sorties.sumStockSortie, 0) AS reste
FROM Materiel M
LEFT JOIN (
    SELECT
        id_materiel,
        SUM(quantite) AS sumStockEntrer
    FROM StockEntrer
    GROUP BY id_materiel
) AS Entrees ON M.id_materiel = Entrees.id_materiel
LEFT JOIN (
    SELECT
        id_materiel,
        SUM(quantite) AS sumStockSortie
    FROM StockSortie
    GROUP BY id_materiel
) AS Sorties ON M.id_materiel = Sorties.id_materiel;



-- TSY METY
create or replace view V_PrixEmploye as
select
    Meuble.id as id_meuble,
    Meuble.id_categorie,
    Categorie.nom as nom_categorie,
    Meuble.id_style,
    Style.nom as nom_style,
    EmployeFabrication.id_volume,
    Volume.volume as nom_volume,
    sum(EmployeFabrication.nombre) as nombreEmploye,
    DureeFabricationProduit.duree as dureeFabrication,
    sum((EmployeFabrication.nombre*SalaireEmploye.tauxHoraire*DureeFabricationProduit.duree)) as totalSalaire
from EmployeFabrication
join SalaireEmploye 
on EmployeFabrication.id_role = SalaireEmploye.id_role
join DureeFabricationProduit
on DureeFabricationProduit.id_meuble = EmployeFabrication.id_meuble
    and DureeFabricationProduit.id_volume = EmployeFabrication.id_volume
    and DureeFabricationProduit.id_role = EmployeFabrication.id_role
join Meuble 
on Meuble.id = EmployeFabrication.id_meuble
join Categorie
on Categorie.id_categorie = Meuble.id_categorie
join style 
on style.id_style = Meuble.id_style 
join Volume
on Volume.id_volume=EmployeFabrication.id_volume
Group by Meuble.id,nom_categorie,nom_style,nom_volume,Meuble.id_categorie,Meuble.id_style,EmployeFabrication.id_volume,dureefabrication;



create or replace view V_PrixDeRevient as
select
    V_PrixEmploye.id_meuble,
    V_PrixMeuble.id_categorie,
    V_PrixMeuble.nom_categorie,
    V_PrixMeuble.id_style,
    V_PrixMeuble.nom_style,
    V_PrixMeuble.id_volume,
    V_PrixMeuble.volume,
    V_PrixEmploye.nombreemploye,
    V_PrixEmploye.dureefabrication,
    (V_PrixMeuble.prix + V_PrixEmploye.totalsalaire) as prixDeRevient
from V_PrixMeuble
join V_PrixEmploye
on V_PrixMeuble.id_categorie = V_PrixEmploye.id_categorie
    and  V_PrixMeuble.id_style = V_PrixEmploye.id_style
    and  V_PrixMeuble.id_volume = V_PrixEmploye.id_volume;




create or replace view V_Benefice as
select  
    V_PrixDeRevient.id_meuble,
    V_PrixDeRevient.id_categorie,
    V_PrixDeRevient.nom_categorie,
    V_PrixDeRevient.id_style,
    V_PrixDeRevient.nom_style,
    V_PrixDeRevient.id_volume,
    V_PrixDeRevient.volume,
    V_PrixDeRevient.nombreemploye,
    (PrixDeVente.prixDeVente - V_PrixDeRevient.prixderevient) as benefice
from V_PrixDeRevient
join PrixDeVente
on V_PrixDeRevient.id_meuble = PrixDeVente.id_meuble
    and PrixDeVente.id_volume = V_PrixDeRevient.id_volume;



create or replace view V_Experience as  
select
    Experience.id,
    Experience.id_grade,
    Grade.nom,
    Experience.annee,
    TauxExperience.nombreTaux
from Experience
join TauxExperience
on TauxExperience.id_grade = Experience.id_grade
join Grade 
on Grade.id = Experience.id_grade;