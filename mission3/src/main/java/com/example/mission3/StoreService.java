package com.example.mission3;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {

    DataSource dataSource = new DatabaseConfig().mysqlDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    private String findAllQuery = "select * from store.tbl_store";
    private String addNewStoreQuery = "insert into store.tbl_store \n"
            +"values (id,?,?,?)";
    private String updateStoreQuery = "update store.tbl_store \n"
            +"set store_name = ?, store_location = ?, store_rating =? \n"
            +"where id = ?";
    private String findByIdQuery = "select * from store.tbl_store \n"
            +"where id = ?";
    private String deleteByIdQuery = "delete from store.tbl_store \n"
            +"where id = ?";
    private String initQuery = "insert into store.tbl_store \n"
            +"values (id,\"First\",\"1,2\",3.4)"
            +",values (id,\"Second\",\"3,2\",4.2)";

    public void init(){
        jdbcTemplate.update(initQuery);
    }
    public List<Store> findAll(){
        return jdbcTemplate.query(findAllQuery,
                new StoreRowMapper());
    }

    public Store findById(Integer id){
        return (Store) jdbcTemplate.queryForObject(findByIdQuery, new StoreRowMapper(), id);
    }

    public void addNewStore(Store newStore){
        jdbcTemplate.update(addNewStoreQuery,newStore.getStoreName()
                ,newStore.getStoreLocation(),newStore.getStoreRating());
    }

    public void updateById(Integer id, Store updatedStore){
        jdbcTemplate.update(updateStoreQuery,updatedStore.getStoreName()
                ,updatedStore.getStoreLocation(),updatedStore.getStoreRating(),id);
    }

    public void deleteById(Integer id){
        jdbcTemplate.update(deleteByIdQuery,id);
    }
}