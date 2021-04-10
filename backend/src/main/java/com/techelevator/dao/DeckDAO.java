package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Deck;

public interface DeckDAO {
	
	boolean initializeDeck(String deckName);
	
	List<Deck> getAllDecksByUser(String user);

	List<Deck> getAllDecksWithCards(String user);

}
