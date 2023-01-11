package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TourControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TourRepository tourRepository;

	@Test
	void findAllTours() throws Exception {
		// ASSEMBLE
		Tour tour1 = new Tour();
		tour1.setTourCode("COLOGNE-1");
		tourRepository.save(tour1);

		Tour tour2 = new Tour();
		tour2.setTourCode("COLOGNE-2");
		tourRepository.save(tour2);


		// ACT & ASSERT
		mvc.perform(get("/tours")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$[0].tourCode").value(("COLOGNE-1")));
	}


}
