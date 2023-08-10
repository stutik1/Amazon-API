package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AmazonRepository {
    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;

    @Autowired
    public AmazonRepository(JdbcTemplate jdbcTemplate, OrderRowMapper orderRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.orderRowMapper = orderRowMapper;
    }

    public List<Product> findAllProduct() {
        String sql = "SELECT * FROM product ";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public Product findById(Long productId) {
        String sql = "SELECT * FROM product WHERE productid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new ProductRowMapper());
    }

    public Cart updateCart(Cart cart) {
        //TODO : Insert query likhna hai
        String sql = "UPDATE cart SET product_quantity = ? , productid = ? WHERE userid = ? ";
        int r = jdbcTemplate.update(
                sql,
                cart.getProductId(),
                cart.getProductQuantity()
        );
        return cart;
    }

    public Cart saveCart(Cart cart) {
        String sql = "INSERT INTO cart (userid,product_quantity,productid) VALUES (?,?,?)";
        jdbcTemplate.update(sql,
                cart.getUserid(),
                cart.getProductQuantity(),
                cart.getProductId()
        );
        return cart;
    }

    public Order saveOrder(Order order) {
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        String sql = "INSERT INTO order_details (status,order_amount,product_quantity,order_date,userid,productid) VALUES (?,?,?,?,?,?) RETURNING orderId";
        Long generatedOrderId = jdbcTemplate.queryForObject(
                sql,
                new Object[]{
                        order.getStatus().toString(),
                        order.getOrderAmount(),
                        order.getProductQuantity(),
                        order.getOrderDate(),
                        order.getUserid(),
                        order.getProductId()
                },
                Long.class
        );
        order.setOrderId(generatedOrderId);
        return order;
    }

    public Order findOrderId(Long orderId) {
        String sql = "select * from order_details where orderid = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderRowMapper());
    }


    public List<Order> findHistory(Long userid) {
        //   String sql = "SELECT * FROM order_details WHERE userid = ? ORDER BY order_date DESC";
        String sql = "SELECT order_details.orderid, order_details.status, order_details.order_amount, order_details.product_quantity, order_details.order_date, order_details.userid ,order_details.productid" +
                "                 FROM order_details" +
                "                 JOIN userdetails ON order_details.userid = userdetails.userid" +
                "                 WHERE userdetails.userid = ? ORDER BY order_date DESC";
        return jdbcTemplate.query(sql, orderRowMapper, userid);

    }
}