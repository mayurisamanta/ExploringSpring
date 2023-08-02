package com.spring.pagination.config;

import com.spring.pagination.entity.Product;
import com.spring.pagination.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = new ArrayList<>();

        // Add 20 sample products to the list
        products.add(new Product("Product 1", 10.99));
        products.add(new Product("Product 2", 20.49));
        products.add(new Product("Product 3", 5.99));
        products.add(new Product("Product 4", 15.29));
        products.add(new Product("Product 5", 8.79));
        products.add(new Product("Product 6", 12.99));
        products.add(new Product("Product 7", 18.49));
        products.add(new Product("Product 8", 7.99));
        products.add(new Product("Product 9", 9.29));
        products.add(new Product("Product 10", 6.79));
        products.add(new Product("Product 11", 14.99));
        products.add(new Product("Product 12", 24.49));
        products.add(new Product("Product 13", 15.99));
        products.add(new Product("Product 14", 28.29));
        products.add(new Product("Product 15", 9.79));
        products.add(new Product("Product 16", 10.99));
        products.add(new Product("Product 17", 11.49));
        products.add(new Product("Product 18", 17.99));
        products.add(new Product("Product 19", 22.29));
        products.add(new Product("Product 20", 25.79));

        productRepository.saveAll(products);
    }
}
