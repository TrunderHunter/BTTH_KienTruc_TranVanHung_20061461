package com.bttuan5.repository;

import com.bttuan5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
     List<Product> findAll();
     Optional<Product> findById(Long id);
     Object save(Product product);
     void remove(Long id);
     List<Product> findByCategory(Long categoryId);
     List<Product> findByBrand(Long brandId);
     List<Product> findByKeyword(String keyword);
     List<Product> findByPrice(double min, double max);
     List<Product> findByPriceAndCategory(double min, double max, Long categoryId);
     List<Product> findByPriceAndBrand(double min, double max, Long brandId);
     List<Product> findByPriceAndKeyword(double min, double max, String keyword);
     List<Product> findByPriceAndCategoryAndBrand(double min, double max, Long categoryId, Long brandId);
}
