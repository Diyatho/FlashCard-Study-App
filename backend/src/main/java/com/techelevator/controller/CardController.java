package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.CardDAO;
import com.techelevator.model.Card;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CardController {
	
	private CardDAO dao;
	
	public CardController(CardDAO cardDAO) {
		this.dao = cardDAO;
	}
	
	@RequestMapping(path = "/user/cards", method = RequestMethod.GET)
	public List<Card> getAllCards(Principal principal) {
		return dao.getAllCards(principal.getName());
	}
	
	@RequestMapping(path = "user/decks/{deckName}", method = RequestMethod.GET)
	public List<Card> getCardsByDeck(@PathVariable String deckName, Principal principal) {
		return dao.getCardsByDeck(deckName, principal.getName());
	}
	
	@RequestMapping(path = "/user/cards/{cardId}", method = RequestMethod.GET)
	public Card getCardById(Principal principal, @PathVariable int cardId) {
		return dao.getCardById(principal.getName(), cardId);
	}
	
	@RequestMapping(path = "/user/cards/{subject}", method = RequestMethod.GET)
	public List<Card> getCardsBySubject(Principal principal, @PathVariable String subject) {
		return dao.getCardsBySubject(principal.getName(), subject);
	}
	
	@RequestMapping(path = "/user/cards/{keyword}", method = RequestMethod.GET)
	public List<Card> getCardsByKeyword(Principal principal, @PathVariable String keyword) {
		return dao.getCardsByKeyword(principal.getName(), keyword);
	}
	
	@RequestMapping(path = "/user/cards/create", method = RequestMethod.POST)
	public void createCard(@RequestBody Card card, Principal principal) {
		dao.createCard(card.getQuestion(), card.getAnswer(), card.getSubject(), card.getDeckName(), principal.getName());

	}
	

}


