package org.kcs.gaming.dnd.fifth.rest.query;

import org.kcs.gaming.dnd.util.Category;
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

	public static String getEntity(Category category) {
		switch (category) {
		case MONSTERS:
			return getAll(MONSTERS);
		case SPELLS:
			return getAll(SPELLS);
		case CLASSES:
			return getAll(CLASSES);
		default:
			String errMsg = "The provided category is undefined.";
			log.error(errMsg);
			return errMsg;
		}
	}
	
	public static String getEntity(Category category, String entity) {
		switch (category) {
		case MONSTERS:
			return getEntity(MONSTERS, entity);
		case SPELLS:
			return getEntity(SPELLS, entity);
		case CLASSES:
			return getEntity(CLASSES, entity);
		default:
			String errMsg = "The provided category is undefined.";
			log.error(errMsg);
			return errMsg;
		}
	}

	private static String getAll(String category) {
		return restClient.get().uri(DND_REST_URL + category).retrieve().body(String.class);
	}

	private static String getEntity(String category, String entity) {
		log.debug("Looking for a monster using URL string {}", DND_REST_URL + category + "/" + entity);
		String response = restClient.get().uri(DND_REST_URL + category + "/" + entity).retrieve().body(String.class);
		log.debug("What we got: {}", response);
		return response;
	}
}
