package com.example.demostockapp.service;

import com.example.demostockapp.model.StockDataKeys;
import com.example.demostockapp.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService
{
    @Autowired
    private StockRepository stockRepo;

    //upload all the data read from file using inbuilt JPA Repository method
    public void uploadDataSet(List<StockModel> stockModel)
    {
        stockRepo.saveAll(stockModel);
    }

    //insert new record using inbuilt JPA Repository method
   public void insertRecord(StockModel stockModel) {
        stockRepo.save(stockModel);
    }

    //retreive all the data based on given stock name
    public List<StockModel> getDataSet(String stockticker) {
         List<StockModel> list = stockRepo.findByStockDataKey_String(stockticker);
         return list;
    }
}