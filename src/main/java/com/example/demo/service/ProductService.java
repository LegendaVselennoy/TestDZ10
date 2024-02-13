package com.example.demo.service;

import com.example.demo.module.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    private ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product p){
        return productRepo.save(p);
    }

    public List<Product> allFind(){
        return productRepo.findAll();
    }

//    public void transferMoney(Long isSender, Long idReceiver, BigDecimal amount){
//        Optional<Product> sender= productRepo.findById(isSender);
//        Optional<Product> receiver=productRepo.findById(idReceiver);
//
//        BigDecimal senderNewAmount=sender.get().getAmount().add(amount);
//        BigDecimal receiverNewAmount=receiver.get().getAmount().add(amount);
//
//        productRepo.changeProductAmount(isSender,senderNewAmount);
//        productRepo.changeProductAmount(idReceiver,receiverNewAmount);
//    }


    public Product getProductIdUpdate(Long id,Product p){
        Optional<Product> current=productRepo.findById(id);
        if (current.isPresent()){
            Product changeProduct=current.get();
            changeProduct.setId(id);
            changeProduct.setTitle(p.getTitle());
            return productRepo.save(changeProduct);
        }
        return productRepo.save(p);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
