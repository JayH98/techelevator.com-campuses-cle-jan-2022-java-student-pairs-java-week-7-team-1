package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard randomCard(){
        CatCard randomCatCard = new CatCard();
        randomCatCard.setCatFact(catFactService.getFact().getText());
        randomCatCard.setImgUrl(catPicService.getPic().getFile());
        //randomCatCard.setCaption("This cat is probably possessed");
        return randomCatCard;
    }


    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list(){
        return catCardDao.list();
    }


    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard card(@PathVariable long id)
            throws CatCardNotFoundException {
        return catCardDao.get(id);
    }

    //if caption is left blank, have a way to tell user it is required instead of not saving
    //and getting a new random catcard
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody CatCard cardToSave){
        return catCardDao.save(cardToSave);
    }


    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public boolean update(@Valid @RequestBody CatCard card, @PathVariable("id") long id)
        throws CatCardNotFoundException {
        return catCardDao.update(id, card);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id)
    throws CatCardNotFoundException {
         catCardDao.delete(id);
    }

}













