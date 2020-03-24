package com.emmabanuelos.ParentPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ParentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParentPortalApplication.class, args);
	}

	@Controller
	public class HelloController {

		@GetMapping
		@ResponseBody
		public String hello() {
			return "Hello, World!" + " " +
					"Follow me on Instagram @emmavsworld <3";
		}

	}
}
