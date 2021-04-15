package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

public interface DeckDAO {
	
	boolean initializeDeck(String deckName, String description, String user);
	
	List<Deck> getAllDecksByUser(String user);
	
	List<Card> getCardsByDeckId(int deckId);

	List<Deck> getAllDecksWithCards(String user);
	
	Deck getDeckByDeckId(int deckId);
	
	Card getDeckCardByCardId(int cardId);
	
}
