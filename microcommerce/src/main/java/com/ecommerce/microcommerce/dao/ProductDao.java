package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {// Il faut indiquer comme premier paramètre
								     // l'entité concernée, puis le type d'id
    public List<Product> findAll();

    public Product findById(int id);

    public Product save(Product product);
}