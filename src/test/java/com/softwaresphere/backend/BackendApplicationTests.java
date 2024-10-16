package com.softwaresphere.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import com.softwaresphere.backend.model.Servicio;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	private final String token="Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKQ1ZhbGVuY2lhQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzI5MDQxNTc0LCJleHAiOjE3MjkwNzc1NzR9.LGVSy3c-5D8qBT3gs1cVvshZWxZg4hF0ST8-SNUdc7I";
	
	@Test
	@DisplayName("Se prueba el endpoint http://localhost/8080/api/servicios/2")
	void pruebaGET() throws Exception {
		this.mockMvc.perform( get("/api/servicios/2")
				).andDo(print()).andExpect(status().isOk()
						).andExpect(content().string(containsString("port_web.jpg")));	
	}
	
	@Test
	 @DisplayName("Se prueba crear un nuevo servicio http://localhost:8080/api/servicios/")
	 void pruebaPOST() throws Exception {
	  Servicio s = new Servicio();
	  s.setNombre("Apps de chatbot");
	  s.setDescripcion("Descripión de Apps de chatbot");
	  s.setImagen("CHTBOT.jpg");
	  s.setCotizacion(650.80);
	  this.mockMvc.perform(
	    post("/api/servicios/")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(asJsonString(s) )
	    .header("Authorization", token) )
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(
	       content().string(containsString("CHTBOT"))
	       );
	 }// pruebaPOST
	
	private static String asJsonString(final Object obj) {
	     try {
	       return new ObjectMapper().writeValueAsString(obj);
	     } catch (Exception e) {
	       throw new RuntimeException(e);
	     }//catch
	  } // asJsonString
}
