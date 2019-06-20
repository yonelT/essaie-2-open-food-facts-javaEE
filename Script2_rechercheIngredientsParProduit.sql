use openfoodfacts;

SELECT produits.id, ingredients.nom FROM produits_ing, ingredients, produits where produits.id=produits_ing.id_prd and ingredients.id=produits_ing.id_ing;