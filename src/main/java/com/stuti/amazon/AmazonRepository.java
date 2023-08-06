package com.stuti.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class AmazonRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AmazonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAllProduct() {
        String sql = "SELECT * FROM product ";
        return jdbcTemplate.query(sql, new ProductRowMapper() {
        });
    }

    public Product findById(Long productId){
        String sql = "SELECT * FROM product WHERE productid = ?";
        return  jdbcTemplate.queryForObject(sql, new Object[]{productId},new ProductRowMapper());
    }

}