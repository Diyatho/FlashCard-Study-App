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

import com.techelevator.dao.DeckDAO;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class DeckController {
	
	private DeckDAO dao;
	
	public DeckController(DeckDAO deckDAO) {
		this.dao = deckDAO;
	}
	@RequestMapping(path = "/user/decks/create", method = RequestMethod.POST)	
	public boolean initializeDeck(@RequestBody Deck deck, Principal principal) {
		return dao.initializeDeck(deck.getDeckName(), deck.getDeckDescription(), principal.getName()); //will need to add getDeckDescription here
	}
	
//	@RequestMapping(path = "/user/decks", method = RequestMethod.GET)
//	public List<Deck> getAllDeckByUser(Principal principal) {
//		return dao.getAllDecksByUser(principal.getName());
//	}
	///////
//	@RequestMapping(path = "/user/decks/{deckName}", method = RequestMethod.GET)
//	public List<Card> getCardsByDeck(@PathVariable String deckName, Principal principal) {
//		return dao.getCardsByDeck(deckName, principal.getName());
//	}
//	
//	@RequestMapping(path = "/user/decks/{deckId}", method = RequestMethod.GET)
//	public List<Card> getCardsByDeckId(@PathVariable int deckId) {
//		return dao.getCardsByDeckId(deckId);
//	}
	
	@RequestMapping(path = "/user/decks", method = RequestMethod.GET)
	public List<Deck> getAllDecksWithCards(Principal principal) {
		return dao.getAllDecksWithCards(principal.getName());
	}
	
	@RequestMapping(path = "/user/decks/{deckId}", method = RequestMethod.GET)
	public Deck getDeckByDeckId(@PathVariable int deckId) {
		return dao.getDeckByDeckId(deckId);
	}
	
	@RequestMapping(path = "/user/decks/{deckId}/{cardId}", method = RequestMethod.GET)
	public Card getDeckCardByCardId(@PathVariable int cardId) {
		return dao.getDeckCardByCardId(cardId)
;	}

}
