package com.spring.pagination.repository;

import com.spring.pagination.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductsByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE created_At BETWEEN ?1 AND ?2 LIMIT ?3, ?4", nativeQuery = true)
    List<Product> getProductByCreatedAtTimeBetweenWithLimit(String startTime, String endTime, int page, int size);
}
