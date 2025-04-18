package org.kcs.demo.springrest;

import java.util.concurrent.atomic.AtomicLong;

import org.kcs.gaming.dnd.fifth.rest.query.DndRestClient;
import org.kcs.gaming.dnd.util.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DndController {

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
}