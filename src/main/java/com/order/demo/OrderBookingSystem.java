package com.order.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.order.demo.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.demo.services.ProductService;

@SpringBootApplication
public class OrderBookingSystem {	
	
	
	@Autowired
	private ProductService productService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderBookingSystem.class, args);
	}
	
	
	@Bean
    CommandLineRunner runner() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/product.json");
            try {
                List<Product> products = mapper.readValue(inputStream, typeReference);
                
                System.out.println("LENGTHHH" + products.size());

                productService.saveAll(products);

                System.out.println("Product List savedsuccesfully!");
            } catch (IOException e) {
                System.out.println("Unable to save product: " + e.getMessage());
            }
        };

    }

}
