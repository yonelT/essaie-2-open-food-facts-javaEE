use openfoodfacts;

SELECT categories.nom AS "CATEGORIE", marques.nom AS "MARQUE", produits.nom AS "PRODUIT", produits.grade AS "GRADE NUTRITIONNEL", produits.energie AS "ENERGIE", produits.graisse AS "GRAISSE" FROM produits, categories, marques
WHERE produits.id_cat=categories.id AND produits.id_mrq=marques.id LIMIT 100;