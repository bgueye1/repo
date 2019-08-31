package com.ecommerce.microcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration  //donne à la classe actuelle la possibilité de définir des configurations qui iront remplacer les traditionnels fichiers XML. Ces configurations se font via des Beans.
@EnableAutoConfiguration //donne à la classe actuelle la possibilité de définir des configurations qui iront remplacer les traditionnels fichiers XML. Ces configurations se font via des Beans.
@ComponentScan  // Indique qu'il faut scanner les classes de ce package afin de trouver des Beans de configuration.
public class MicroCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCommerceApplication.class, args);
	}

}
