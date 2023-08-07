package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AmazonController {

    private final AmazonService amazonService;

    @Autowired
    public AmazonController(AmazonService amazonService) {
        this.amazonService = amazonService;
    }

//    @PostMapping("/order")
//    public ResponseEntity<String> createOrder(@RequestBody Order order){
//
//        return ;
//    }

//    @GetMapping("/product/all")
//    public List<Product> getAllEmployee(){
//        return amazonService.getAllProduct();
//    }

    @GetMapping("/product/all")
    public ResponseEntity<Product> getAllProduct() {
        List<Product> product = amazonService.getAllProduct();
        return (ResponseEntity) ResponseEntity.ok(product);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable() Long productId) {
        Product product = amazonService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //    @PutMapping("/cart")
//    public ResponseEntity<Cart> cartitems(@PathVariable() Long userid){
//        Cart cart = amazonService.cartitems(userid);
//            if (cart != null){
//                return ResponseEntity.ok(cart);
//            }else {
//                return ResponseEntity.notFound().build();
//            }
//        }


    @PutMapping("/cart")
    public ResponseEntity<Cart> updateCartItems( @RequestBody Cart updateCartItems) {
        Cart cart = amazonService.updateCartItems(updateCartItems);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


