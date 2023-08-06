package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonService {

    private final AmazonRepository amazonRepository;

    @Autowired
    public AmazonService(AmazonRepository amazonRepository){
        this.amazonRepository=amazonRepository;
    }

    public List<Product> getAllProduct(){
        return amazonRepository.findAllProduct();
    }
    public Product getProductById(Long productId){
        return amazonRepository.findById(productId);
    }
}
