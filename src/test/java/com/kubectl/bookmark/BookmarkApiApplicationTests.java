package com.kubectl.bookmark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.org.hamcrest.CoreMatchers;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkApiApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void shoulGetBookmarks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
