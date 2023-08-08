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

    public Cart updateCartItems(Cart updateCart){
       Cart cart = amazonRepository.updateCart(updateCart);
        if (cart != null){
            cart.setCartId(updateCart.getCartId());
            cart.setUserid(updateCart.getUserid());
            cart.setProductId(updateCart.getProductId());
            cart.setProductQuantity(updateCart.getProductQuantity());
        }
        return cart;
    }

    public Cart saveCartDetails(Cart cart){
        return amazonRepository.saveCart(cart);
    }
}
