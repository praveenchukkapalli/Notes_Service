package com.baton.Notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.baton.Notes.model.notes;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NotesApplicationTests {
	@Autowired
	public WebApplicationContext webApplicationContext;

	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void addNote() throws Exception{
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/note/add";
		notes new_note = new notes();
		new_note.setNote("Test");

		String inputJson = objectMapper.writeValueAsString(new_note); //Listing elements in Json to suit input.
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}


	@Test
	public void getAllNotes() throws Exception{
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/note/list";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}


	@Test
	public void deleteNote() throws Exception{
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/note/?id=1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());

	}

}
