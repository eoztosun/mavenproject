package com.example.mavenproject;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@WebMvcTest(NagerApiController.class)
class MavenprojectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NagerApiController service;

	@Test
	void contextLoads() {
	}

	@Test
	void VersionCheckTest() throws Exception {
		when(service.Version()).thenReturn("Hello, Mock");
		this.mockMvc.perform(get("/Version")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Mock")));
	}

}
