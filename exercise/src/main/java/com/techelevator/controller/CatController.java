package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }


    //`GET /api/cards/random`
    // Provides a new, randomly created Cat Card containing information from the cat fact and picture services.
    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard randomCard(){
        CatCard randomCatCard = new CatCard();
        randomCatCard.setCatFact(catFactService.getFact().getText());
        randomCatCard.setImgUrl(catPicService.getPic().getFile());
        randomCatCard.setCaption("This cat is probably possessed");
        return randomCatCard;
    }

    //`GET /api/cards`
    // Provides a list of all Cat Cards in the user's collection.
    //
    // @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    //    public List<Hotel> list() {
    //        return hotelDao.list();
    //    }
    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list(){
        return catCardDao.list();
    }

    //`GET /api/cards/{id}`:
    // Provides a Cat Card with the given ID.
    //@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    //    public Auction getAuctionById(@PathVariable int id) {
    //        return dao.get(id);
    //    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard list(@PathVariable long id){
        return catCardDao.get(id);
    }

    //POST /api/cards`: Saves a card to the user's collection.


}
