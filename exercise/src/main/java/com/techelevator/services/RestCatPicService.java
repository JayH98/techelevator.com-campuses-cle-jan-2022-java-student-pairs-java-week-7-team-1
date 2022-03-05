package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
		} catch (
				//return a picture of a frowning face if the netlify.app api is not working.
				RestClientResponseException e) {
			CatPic errorCatPic = new CatPic();
			errorCatPic.setFile("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/110/white-frowning-face_2639.png");
			return errorCatPic;
		}
	}


}	
