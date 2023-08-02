package com.spring.pagination.config;

import com.spring.pagination.entity.Product;
import com.spring.pagination.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = new ArrayList<>();

        Random random = new Random();

        // Add 20 sample products to the list
        for (int i = 1; i <= 20; i++) {
            // Generate random year between 2020 and 2023
            int year = random.nextInt(4) + 2020;
            // Generate random month between 1 and 12
            int month = random.nextInt(12) + 1;
            // Generate random day between 1 and 28 (for simplicity, considering all months to have 28 days)
            int day = random.nextInt(28) + 1;
            // Generate random hour between 0 and 23
            int hour = random.nextInt(24);
            // Generate random minute between 0 and 59
            int minute = random.nextInt(60);
            // Generate random second between 0 and 59
            int second = random.nextInt(60);

            LocalDateTime createdAt = LocalDateTime.of(year, month, day, hour, minute, second);
            Product product = new Product("Product " + i, (i * 10.0), createdAt);
            products.add(product);
        }

        productRepository.saveAll(products);
    }
}
