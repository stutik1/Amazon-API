package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonService {
    private final AmazonRepository amazonRepository;

    @Autowired
    public AmazonService(AmazonRepository amazonRepository) {
        this.amazonRepository = amazonRepository;
    }

    //get all Product
    public List<Product> getAllProduct() {
        return amazonRepository.findAllProduct();
    }

    // get product by id
    public Product getProductById(Long productId) {
        return amazonRepository.findById(productId);
    }

    // update cart
//    public Cart updateCartItems(Long userid, Cart updatedCart) {
//        Cart cart = amazonRepository.updateCart(updatedCart);
//        if (cart != null) {
//            // cart.setCartId(updatedCart.getCartId());
//            //   cart.setUserid(updatedCart.getUserid());
//            cart.setProductId(updatedCart.getProductId());
//            cart.setProductQuantity(updatedCart.getProductQuantity());
//        }
//        return cart;
//    }

    // Add item in cart
    public Cart saveCartDetails(Cart cart) {
        return amazonRepository.saveCart(cart);
    }

    public Order saveOrderDetail(Order order){
        return amazonRepository.saveOrder(order);
    }

    public Order getOrderById(Long orderId){
        return amazonRepository.findOrderId(orderId);
    }

    public Order getHistory(Long userid){
        return (Order) amazonRepository.findHistory(userid);
    }
}
