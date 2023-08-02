package com.spring.pagination.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.pagination.entity.Product;
import com.spring.pagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "5") int size) throws JsonProcessingException {
        return productService.getProducts(page, size);
    }

    @GetMapping("/products/{name}")
    public List<Product> getProductsByName(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "5") int size,
                                           @PathVariable("name") String name ){
        return productService.getProductsByName(page, size, name);
    }

    @GetMapping("/products/{min}/{max}")
    public List<Product> getProductsByPrice(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "5") int size,
                                            @PathVariable("min") double min,
                                            @PathVariable("max") double max){
        return productService.getProductsByPrice(page, size, min, max);
    }

    @GetMapping("/productsByTime")
    public List<Product> getProductsByCreatedAtTimeBetween(
            @RequestParam String startTime,
            @RequestParam String endTime,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return productService.getProductsByCreatedAtTimeBetween(startTime, endTime, page, size);
    }
}
