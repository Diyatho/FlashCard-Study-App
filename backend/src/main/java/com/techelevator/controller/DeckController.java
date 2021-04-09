package com.techelevator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.DeckDAO;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class DeckController {
	
	private DeckDAO dao;
	
	public DeckController(DeckDAO deckDAO) {
		this.dao = deckDAO;
	}
	@RequestMapping(path = "/user/decks/create", method = RequestMethod.POST)	
	public boolean initializeDeck(String deckName) {
		return dao.initializeDeck(deckName);
	}

}
