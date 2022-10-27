package com.example.demostockapp.service;

import com.example.demostockapp.model.StockDataKeys;
import com.example.demostockapp.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockModel, StockDataKeys> {
    //custom query to get the matching records as per stock name and the latest quarter record only
    @Query(value = "SELECT * FROM stockdata WHERE stock=:stockticker AND quarter IN (SELECT MAX(quarter) AS max_quarter FROM stockdata WHERE stock=:stockticker)",nativeQuery = true)
    List<StockModel> findByStockDataKey_String(@Param(value = "stockticker") String stockticker);
}
