package com.stuti.amazon;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setCartId(rs.getInt("cartid"));
        cart.setProductQuantity(rs.getInt("product_quantity"));
        cart.setUserid(rs.getLong("userid"));
        cart.setProductId(rs.getInt("productid"));
        return cart;
    }
}
