package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyWebApplication {

	@RestController
	public class HelloController2 {
		@GetMapping("/hello")
		public String hello() {
			return "hello";
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}
}
