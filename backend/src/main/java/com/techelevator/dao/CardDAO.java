package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;

public interface CardDAO {
	
	List<Card> getAllCards(String user);
	
	Card getCardById(String user, int cardId);
	
	List<Card> getCardsBySubject(String user, String subject);
	
	List<Card> getCardsByKeyword(String user, String keyword);
	
	void createSubject(String subject);

	void createCard(String question, String answer, String subject, String user, String deckName);
	
	boolean addKeywordsToCard(String user, String answer, String keywords);
	
	boolean addCardToDeck(String deckName, int cardId);

}
