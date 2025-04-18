package org.kcs.demo.springrest;

import java.util.concurrent.atomic.AtomicLong;

import org.kcs.gaming.dnd.fifth.rest.query.DndRestClient;
import org.kcs.gaming.dnd.util.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue = "World") String name) {
		return String.format("Hello %s! You rock my face off!  By the way...%s", name, simpleTemplate());
	}
	
	@GetMapping("/spells/all")
	public String spells() {
		return DndRestClient.getEntity(Category.SPELLS);
	}
	
	@GetMapping("/classes/all")
	public String classes() {
		return DndRestClient.getEntity(Category.CLASSES);
	}
	
	@GetMapping("/monsters/all")
	public String monsters() {
		return DndRestClient.getEntity(Category.MONSTERS);
	}
	
	@GetMapping("/monster")
	public String monster(@RequestParam(defaultValue = "") String name) {
		return DndRestClient.getEntity(Category.MONSTERS, name);
	}

	private String simpleTemplate() {
		return "<b>This is a silly little template.</b>";
	}
}