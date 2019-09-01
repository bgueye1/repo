package com.ecommerce.microcommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

//RestController de Spring qui permet de désigner une classe comme contrôleur,
//lui conférant la capacité de traiter les requêtes de type GET, POST, etc
//Il indique aussi que chaque méthode va renvoyer directement 
//la réponse JSON à l'utilisateur,
//donc pas de vue dans le circuit.
@RestController

public class ProductController {

    @Autowired
    private ProductDao productDao;// Autowired afin que Spring se charge d'en fabriquer une instance

    // Récupérer la liste des produits
    // Récupérer la liste des produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
    public MappingJacksonValue listeProduits() {
	Iterable<Product> produits = productDao.findAll();

	SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

	FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

	MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

	produitsFiltres.setFilters(listDeNosFiltres);

	return produitsFiltres;
    }

    // Récupérer un produit par son Id
    // convertir les objets Java renvoyés en réponse (Product dans notre cas) en
    // JSON
    /*
     * @GetMapping(value = "/Produits/{id}") public Product
     * afficherUnProduit(@PathVariable int id) { return productDao.findById(id); }
     * 
     * // ajouter un produit // RequestBody Cette annotation demande à Spring que le
     * JSON contenu dans la // partie body de la requête HTTP soit converti en objet
     * Java
     * 
     * @PostMapping(value = "/Produits")
     * 
     * public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
     * 
     * Product productAdded = productDao.save(product);
     * 
     * if (productAdded == null) return ResponseEntity.noContent().build();
     * 
     * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
     * .buildAndExpand(productAdded.getId()).toUri();
     * 
     * return ResponseEntity.created(location).build(); }
     */

}