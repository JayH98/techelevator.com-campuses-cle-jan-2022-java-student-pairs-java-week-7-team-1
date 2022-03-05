package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		RestTemplate restTemplate = new RestTemplate();
		//return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
		return restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
	}

}	
