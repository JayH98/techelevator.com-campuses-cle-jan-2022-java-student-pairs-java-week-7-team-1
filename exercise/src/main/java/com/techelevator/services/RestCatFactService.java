package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
		} catch (RestClientResponseException e) {
			//Return a text error to the user if the netlify.app api is down
			CatFact errorCatFact = new CatFact();
			errorCatFact.setText("Sorry we were unable to retrieve a cat fact.");
			return errorCatFact;
		}

	}




}
