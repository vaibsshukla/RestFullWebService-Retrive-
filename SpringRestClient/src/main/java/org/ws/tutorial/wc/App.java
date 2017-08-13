package org.ws.tutorial.wc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.ws.tutorial.wc.config.SpringMvcConfig;

@SpringBootApplication
public class App extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

}
