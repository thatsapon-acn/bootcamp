package com.example.mission3;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreRowMapper implements RowMapper<Store> {
    @Override
    public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
        Store store = new Store();

        store.setId(rs.getInt("id"));
        store.setStoreName(rs.getString("store_name"));
        store.setStoreLocation(rs.getString("store_location"));
        store.setStoreRating(rs.getFloat("store_rating"));

        return store;
    }
}