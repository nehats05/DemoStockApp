package com.example.demostockapp;

import com.example.demostockapp.model.StockModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StockApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//testing the getData based on stock name and validate the composite keys
	@Test
	void getDataSetLatest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getstockDataSet")
						.param("stockticker","AA"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].stock",Matchers.matchesPattern("[A-Z]+")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[*].quarter").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].date",
						Matchers.matchesPattern("(\\d{1,2}(\\/)\\d{1,2}(\\/)\\d{2,4})")));
	}

	//test for inserting record mainly with composite keys
	@Test
	void insertRecord() throws Exception{
		StockModel stockModel = new StockModel();  //create dummy data for insertion of composite keys
		stockModel.setStock("ABC");
		stockModel.setQuarter(0);
		stockModel.setDate("1/22/2011");
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(stockModel);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/insertDataRecord")
						.content(data)
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
