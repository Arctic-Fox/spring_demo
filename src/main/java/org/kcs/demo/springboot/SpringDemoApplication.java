package org.kcs.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDemoApplication {
	
    public static void main(String[] args) {
      SpringApplication.run(SpringDemoApplication.class, args);
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s! You rock my face off!  By the way...%s", name, simpleTemplate());
    }
    
    private String simpleTemplate() {
    	return "<b>This is a silly little template.</b>";
    }
}