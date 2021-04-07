package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;

public interface CardDAO {
	
	List<Card> getAllCards(int userId);
	
	Card getCardById(int userId, int cardId);
	
	List<Card> getCardsBySubject(int userId, String subject);
	
	List<Card> getCardsByKeyword(String keyword);

}
