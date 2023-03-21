package com.bilel.SpringBoot_TP01.services;

import java.util.List;

import com.bilel.SpringBoot_TP01.entities.Produit;

public interface ProduitService {
	Produit saveProduit(Produit p);
	
	Produit updateProduit(Produit p);
	
	void deleteProduit(Produit p);
	
	void deleteProduitById(Long id);
	
	Produit getProduit(Long id);
	
	List<Produit> getAllProduits();

}
