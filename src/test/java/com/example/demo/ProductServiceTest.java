package com.example.demo;

import com.example.demo.module.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    public ProductService productService;

    @Test
    public void testMethod(){
        Product p1=new Product();
        p1.setId(1L);
        p1.setTitle("title1");
        p1.setAmount(new BigDecimal(1000));
        Product p2=new Product();
        p2.setId(2L);
        p2.setTitle("title2");
        p2.setAmount(new BigDecimal(1000));

        given(repo.findById(p1.getId())).willReturn(Optional.of(p1));
        given(repo.findById(p2.getId())).willReturn(Optional.of(p2));

        productService.transferMoney(1L,2L,new BigDecimal(100));

        verify(repo).changeProductAmount(p1.getId(),new BigDecimal(900));
        verify(repo).changeProductAmount(p2.getId(),new BigDecimal(1100));
    }

    @Test
    public void testList(){
        List<Product> allFind=repo.findAll();
        allFind.add(new Product());
        assertEquals(1,allFind.size());
        verify(repo).findAll();
    }
}
