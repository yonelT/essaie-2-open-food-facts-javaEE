use openfoodfacts;

select categories.nom as CATEGORIE, marques.nom as MARQUE, produits.nom as NOM_PRODUIT, produits.grade as GRADE_NUTRITIONEL, produits.energie as ENERGIE, produits.graisse as GRAISSE
from categories, marques, produits
where categories.id=produits.id_cat and marques.id=produits.id_mrq limit 100;