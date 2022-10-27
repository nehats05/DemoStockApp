package com.example.demostockapp.controller;

import com.example.demostockapp.helper.StockHelper;
import com.example.demostockapp.model.StockModel;
import com.example.demostockapp.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class StockController
{
    @Autowired
    private StockService stockService;

    //enable the logger service
    Logger logger = LoggerFactory.getLogger(StockController.class);

    //method to upload bulk data set (consider as file upload )
   @PutMapping(value = "/upload")
    public ResponseEntity<String> uploadDataSet(@RequestPart("file")MultipartFile multipartFile) throws IOException {

       //check the format of the file and parse the data from file to the StockModel with the Helper Class
       if(StockHelper.hasFormat(multipartFile))
       {
           logger.info("File is in valid format");
           try{
               List<StockModel> fileData = StockHelper.convertDataToStock(multipartFile.getInputStream());
               stockService.uploadDataSet(fileData);
               String msg = "File uploaded successfully";
               return ResponseEntity.status(HttpStatus.CREATED).body(msg);
           }
           catch (Exception e) {
               logger.info("Check file format or data");
               return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Unable to upload file");
           }
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload file only in data format");
   }

   //method to query data set by stock name
    @GetMapping("/getstockDataSet")
    public List<StockModel> getDataSet(@RequestParam("stockticker") String stockticker)
    {
        return stockService.getDataSet(stockticker);
    }

    //method to add a new record
    @PostMapping("/insertDataRecord")
    public ResponseEntity<String> insertRecord(@RequestBody StockModel stockModel)
    {
        try{
            if(stockModel!=null && StockHelper.validateRecord(stockModel))
                stockService.insertRecord(stockModel);
            else
            {
                logger.info("Please check the record");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the record");
            }
        }
        catch (Exception e)
        {
             ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Record is validated and inserted");
    }
}