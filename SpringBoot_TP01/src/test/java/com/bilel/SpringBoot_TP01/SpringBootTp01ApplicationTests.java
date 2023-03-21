package com.bilel.SpringBoot_TP01;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bilel.SpringBoot_TP01.entities.Produit;
import com.bilel.SpringBoot_TP01.repos.ProduitRepository;

@SpringBootTest
class SpringBootTp01ApplicationTests {

	@Autowired
	private ProduitRepository produitRepo;
	
	@Test
	public void testCreateProduit() {
		Produit produit = new Produit("PC HP", 4000.0, new Date());

		this.produitRepo.save(produit);
	}
	
	@Test
	public Produit testFindProduitByID(long id) {
		Produit produit = this.produitRepo.findById(id).get();
		
		System.out.println("Debut De La Fonction ' findProduitByID(id)' ");
		
		System.out.println(
				"Produit Id : " + produit.getIdProduit() + 
				" \nLe Nom De Produit : " + produit.getNomProduit() + 
				" \nLe Prix De Produit : " + produit.getPrixProduit() + " DT" +  
				" \nLa Date De Creation : " + produit.getDateCreation()
		);
		
		System.out.println("Fin La Fonction ' findProduitByID(id)' ");

		
		return produit;
	}
	
	@Test
	public void testUpdateProduit() {
		Produit produit = this.testFindProduitByID(1L);
		
		System.out.println("Debut La Fonction ' updateProduit()' ");

		
		produit.setPrixProduit(1500.0);
		
		this.produitRepo.save(produit);
		
		System.out.println("\n Produit Aprés Le Modifier \n");
		
		System.out.println(
				"Produit Id : " + produit.getIdProduit() + 
				" \nLe Nom De Produit : " + produit.getNomProduit() + 
				" \nLe Prix De Produit : " + produit.getPrixProduit() + " DT" +  
				" \nLa Date De Creation : " + produit.getDateCreation()
		);
		
		System.out.println("Fin La Fonction ' updateProduit()' ");
	}
	
	@Test
	public void testDeleteProduit() {
		Produit produit = this.produitRepo.findById(1L).get();
		this.produitRepo.delete(produit);
	}
	
	@Test
	public void testGetAllProduits() {
		List<Produit> produits = this.produitRepo.findAll();
		
		for(Produit produit : produits) {
			System.out.println(produit);
		}
	}
}
