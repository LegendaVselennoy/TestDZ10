package com.example.demo;

import com.example.demo.module.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ProductIntegrationTest {
    @MockBean
    private ProductRepository repository;
    @Autowired
    private ProductService productService;

    @Test
    public void testMethod(){
        Product p=new Product();
        p.setId(1L);
        p.setTitle("title");
        given(repository.findById(p.getId())).willReturn(Optional.of(p));
    }
}
