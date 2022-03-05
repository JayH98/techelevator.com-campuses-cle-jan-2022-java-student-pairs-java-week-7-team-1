package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		RestTemplate restTemplate = new RestTemplate();
		//return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
		return restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
	}

}
