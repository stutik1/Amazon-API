package com.stuti.amazon;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getLong("productid"));
        product.setProductName(rs.getString("productname"));
        product.setProductSpec(rs.getString("productspec"));
        product.setPrice(rs.getLong("price"));
        product.setReview(rs.getString("review"));
        return product;
    }
}
