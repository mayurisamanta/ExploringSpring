package com.spring.pagination.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.pagination.entity.Product;
import com.spring.pagination.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;

    public List<Product> getProducts(int page, int size) throws JsonProcessingException {

//        Result will be same with PageRequest and Pageable because PageRequest is implementation of Pageable
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Pageable pageable = Pageable.ofSize(size).withPage(page - 1); // It will return Obj of PageRequest
//        Page<Product> productPage = productRepository.findAll(pageRequest);
        Page<Product> productPage = productRepository.findAll(pageable);

//        Beautifying the console
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(productPage);
        System.out.println(json);

        return productPage.getContent();
    }

    public List<Product> getProductsByName(int page, int size, String name) {
        Pageable pageable = Pageable.ofSize(size).withPage(page - 1);

        return productRepository.findByName(name, pageable);
    }

    public List<Product> getProductsByPrice(int page, int size, double min, double max) {
        Pageable pageable = Pageable.ofSize(size).withPage(page - 1);
        return productRepository.findProductsByPriceBetween(min, max, pageable);
    }

    public List<Product> getProductsByCreatedAtTimeBetween(String startTime, String endTime, int page, int size) {
        page = (page - 1) * size;
        return productRepository.getProductByCreatedAtTimeBetweenWithLimit(startTime, endTime, page, size);
    }
}
