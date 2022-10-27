package com.example.demostockapp.helper;

import com.example.demostockapp.model.StockModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StockHelper {
    public static String type = "application/octet-stream";

    static Logger logger = LoggerFactory.getLogger(StockHelper.class);

    //to check the format of the file
    public static boolean hasFormat(MultipartFile file) {
        if(!type.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    //to read input from file(comma separated values) and convert to Stock data model
    public static List<StockModel> convertDataToStock(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withNullString("0"));) {
            List<StockModel> list = new ArrayList<>();
            Iterable<CSVRecord> records = parser.getRecords();
            for (CSVRecord csv : records) {
                StockModel model = new StockModel(
                        Integer.parseInt(csv.get("quarter")),
                        csv.get("stock"),
                        csv.get("date"),
                        Double.parseDouble(csv.get("open").replace("$", "")),
                        Double.parseDouble(csv.get("high").replace("$", "")),
                        Double.parseDouble(csv.get("low").replace("$", "")),
                        Double.parseDouble(csv.get("close").replace("$", "")),
                        parseDoubleOrNull(csv.get("volume")),
                        parseDoubleOrNull(csv.get("percent_change_price")),
                        parseDoubleOrNull(csv.get("percent_change_volume_over_last_wk")),
                        parseDoubleOrNull(csv.get("previous_weeks_volume")),
                        Double.parseDouble(csv.get("next_weeks_open").replace("$", "")),
                        Double.parseDouble(csv.get("next_weeks_close").replace("$", "")),
                        parseDoubleOrNull(csv.get("percent_change_next_weeks_price")),
                        parseIntOrNull(csv.get("days_to_next_dividend")),
                        parseDoubleOrNull(csv.get("percent_return_next_dividend"))
                );
                list.add(model);
            }
            logger.info("records are parsed");
            return list;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read the file");
        }
    }

    //methods to handle null values in file
    public static double parseDoubleOrNull(String str) {
        if(str==null || str.equals("")){
            return 0;
        }
        return Double.parseDouble(str);
    }
    public static int parseIntOrNull(String str) {
        if(str==null || str.equals("")){
            return 0;
        }
        return Integer.parseInt(str);
    }

    //method to validate composite keys in record
    public static boolean validateRecord(StockModel stockModel) {
        logger.info("validating records");
        if(stockModel.getQuarter() <= 0 || stockModel.getQuarter() > 4 )
            return false;
        else if(stockModel.getStock() == null || stockModel.getStock().equals("") ||
                stockModel.getStock().matches("[A-Z]+") || stockModel.getStock().length()<5)
            return false;
        else if(stockModel.getDate() == null || stockModel.getDate().equals("") ||
                    stockModel.getDate().matches("(\\d{1,2}(\\/)\\d{1,2}(\\/)\\d{2,4})"))
            return false;
        return true;
    }
}
