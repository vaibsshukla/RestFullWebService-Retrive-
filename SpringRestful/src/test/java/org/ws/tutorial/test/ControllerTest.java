package org.ws.tutorial.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.ws.tutorial.controller.DefaultController;
import org.ws.tutorial.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/Spring/ApplicationContext.xml","classpath:/Spring/mvc-config.xml"})
@WebAppConfiguration
public class ControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private DefaultController defaultController;
	
	@Mock
	private Employee employeeMock;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(defaultController).build();
	}
	
	@Test
	public void TestDefault() throws Exception
	{	
		mockMvc.perform(get("/Home")).andExpect(status().isNotFound());
		
	}
	
	@Test
	public void TestGetEmployeeJson()
	{
		
	}
	
	
}
