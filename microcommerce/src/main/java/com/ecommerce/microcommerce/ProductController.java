package com.ecommerce.microcommerce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RestController de Spring qui permet de désigner une classe comme contrôleur,
         //lui conférant la capacité de traiter les requêtes de type GET, POST, etc
          //Il indique aussi que chaque méthode va renvoyer directement 
//la réponse JSON à l'utilisateur,
//donc pas de vue dans le circuit.
@RestController 
public class ProductController {

	    @GetMapping(value="/Produits")
	    public String listeProduits() {
	        return "Un exemple de produit";
	    }
	    @GetMapping(value = "/Produits/{id}")
	    public String afficherUnProduit(@PathVariable int id) {
	    return "Vous avez demandé un produit avec l'id  " + id;
	  }
}
