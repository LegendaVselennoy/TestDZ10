package com.example.demo.repository;

import com.example.demo.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//     @Modifying
//     @Query("UPDATE product SET amount = :amount WHERE id = :id")
//     void changeProductAmount(Long id, BigDecimal amount);
}
