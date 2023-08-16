package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//        @PutMapping("/cart/{userid}")
//    public ResponseEntity<Cart> cartitems(@PathVariable Long userid,@RequestBody Cart updatedCart){
//        Cart cart = amazonService.updateCartItems(userid,updatedCart);
//            if (cart != null){
//                return ResponseEntity.ok(cart);
//            }else {
//                return ResponseEntity.notFound().build();
//            }
//        }

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart) {
        return amazonService.saveCartDetails(cart);
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return amazonService.saveOrderDetail(order);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable() Long orderId) {
        Order order = amazonService.getOrderById(orderId);

        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/orderhistory/{userid}")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable Long userid) {
        List<Order> order = (List<Order>) amazonService.getHistory(userid);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



