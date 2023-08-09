package com.stuti.amazon;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getLong("orderid"));
        order.setOrderDate(rs.getTimestamp("order_date"));
        order.setOrderAmount(rs.getLong("order_amount"));
        order.setStatus(OrderStatusType.valueOf(rs.getString("status")));
        order.setProductQuantity(rs.getInt("product_quantity"));
        order.setUserid(rs.getLong("userid"));
        order.setProductId(rs.getLong("productid"));
        return order;

    }
}
