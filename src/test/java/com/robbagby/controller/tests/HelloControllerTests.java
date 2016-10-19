package com.robbagby.controller.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.robbagby.controller.HelloController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/servlet-config.xml" })
public class HelloControllerTests {

	//@Mock
	// private SampleService sampleService;

	@InjectMocks
	private HelloController helloController;

	private MockMvc mockMvc;

	private String fred;
	
	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();

	}

	@Autowired
	ApplicationContext applicationContext;

	// private MockHttpServletRequest request;
	// private MockHttpServletResponse response;
	// private HandlerAdapter handlerAdapter;

	// @Autowired
	// private HelloController helloController;

	// @Before
	// public void setUp() {
	// request = new MockHttpServletRequest();
	// response = new MockHttpServletResponse();
	//
	// handlerAdapter = new RequestMappingHandlerAdapter();
	// }

	@Test
	public void sayHello() throws Exception {

		// when(sampleService.saveFrom(any(SignupForm.class)))
		// .thenThrow(new InvalidUserException("For Testing"));
		
		this.mockMvc
				.perform(get("/greeting"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("greeting"));

		// request.setRequestURI("/greeting");
		// request.setMethod("GET");
		// final ModelAndView mav = handlerAdapter.handle(request, response,
		// helloController);
		//
		// assertEquals("hello", mav.getModel().get("Hello, World"));
		// //assertEquals("hallo", mav.getViewName());

	}

}
