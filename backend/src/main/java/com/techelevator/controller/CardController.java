package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.CardDAO;
import com.techelevator.model.Card;

@RestController
@RequestMapping("/cards")
public class CardController {
	
	private CardDAO dao;
	
	public CardController(CardDAO cardDAO) {
		this.dao = cardDAO;
	}
	
	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public List<Card> getAllCards(@PathVariable int userId) {
		return dao.getAllCards(userId);
	}
	

}
