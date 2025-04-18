package org.kcs.gaming.dnd.fifth.rest.query;

import org.kcs.gaming.dnd.util.GameElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;

public class DndRestClient {
	private static final Logger log = LoggerFactory.getLogger(DndRestClient.class);

	private static RestClient restClient = RestClient.create();
	private static final String DND_REST_URL = "https://www.dnd5eapi.co/api/2014";
	private static final String MONSTERS = "/monsters";
	private static final String SPELLS = "/spells";
	private static final String CLASSES = "/classes";
	
	public static String getEntity(GameElement type){
		switch(type) {
		case MONSTERS:
			return getAll(MONSTERS);
		case SPELLS:
			return getAll(SPELLS);
		case CLASSES:
			return getAll(CLASSES);
		default:
			return "No data found.";
		}
		
	}
	
	private static String getAll(String category) {
		return restClient.get()
				  .uri(DND_REST_URL + category)
				  .retrieve()
				  .body(String.class);
	}
}
