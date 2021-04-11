package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

@Component
public class JDBCDeckDAO implements DeckDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCDeckDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//used
	@Override
	public boolean initializeDeck(String deckName, String user) {
		boolean deckInitialized = false;
//		
//		String sqlCheckForDeckByUser = "SELECT deck_name \n" + 
//				" FROM deck\n" + 
//				" WHERE (deck_name = ?) AND creator_id = (SELECT user_id FROM users WHERE username = ?);";
//		SqlRowSet deckRow = jdbcTemplate.queryForRowSet(sqlCheckForDeckByUser, deckName, user);
//		
//		if(deckRow.next() == false) {
			String sqlInitDeck = "INSERT INTO deck (deck_name, creator_id) VALUES (?, (SELECT user_id FROM users WHERE username = ?));";
			deckInitialized = jdbcTemplate.update(sqlInitDeck, deckName, user) == 1; 
//			return deckInitialized;	
//		} 
		return deckInitialized;
	}
	//used
	@Override
	public List<Deck> getAllDecksByUser(String user) {
		List<Deck> allDecks = new ArrayList<>();
		
		String sqlDecksByUser = "SELECT deck_id, deck_name, description, (SELECT username FROM users WHERE user_id = deck.creator_id) AS deck_creator FROM deck" + 
				" WHERE creator_id = (SELECT user_id FROM users WHERE username = ?);";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDecksByUser, user);
		while (results.next() ) {
			Deck deck = mapRowToDeck(results);
			allDecks.add(deck);
		}			
		return allDecks;
	}
	
	@Override
	public List<Card> getCardsByDeckId(int deckId) {
		List<Card> deckCards = new ArrayList<>();
		
		String sqlGetCardsByDeckId = "SELECT card_id, question, answer, subject.subject_name, (SELECT username FROM users WHERE user_id = cards.creator_id) AS card_creator, deck.deck_name\n" + 
				" FROM cards\n" + 
				" JOIN subject USING (subject_id)\n" + 
				" JOIN deck_cards USING (card_id)\n" + 
				" JOIN deck USING (deck_id)\n" + 
				" WHERE deck_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsByDeckId, deckId);
		while (results.next()) {
			Card card = mapRowToDeckCard(results);
			deckCards.add(card);
		}
		return deckCards;
	}	
	
	@Override
	public List<Deck> getAllDecksWithCards(String user) {
		//loop through user decks and add list of cards to each deck
		List<Deck> userDecks = getAllDecksByUser(user);
		
			for(Deck deck: userDecks) {
				List<Card> cardsInDeck = getCardsByDeckId(deck.getDeckId()); //returns list of cards in each deck
				
				deck.setCards(cardsInDeck); //set list of cards to that deck
			}
		return userDecks;
	}
	
	@Override
	public Deck getDeckByDeckId(int deckId) {
		Deck deck = new Deck();
		
		String sqlGetDeckInfoById = "SELECT deck_id, deck_name, description, (SELECT username FROM users WHERE user_id = deck.creator_id) AS deck_creator FROM deck WHERE deck_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDeckInfoById, deckId);
		if (results.next()) {
		 deck = mapRowToDeck(results);
		}
		List<Card> cardsInDeck = getCardsByDeckId(deck.getDeckId());
		deck.setCards(cardsInDeck);
		
		return deck;
	}
	
	@Override
	public Card getDeckCardByCardId(int cardId) {
		Card deckCard = new Card();
		
		String sqlGetDeckCardById = "SELECT card_id, question, answer, subject.subject_name, (SELECT username FROM users WHERE user_id = cards.creator_id) AS card_creator, deck.deck_name\n" + 
				 "FROM cards \n" + 
				" JOIN subject USING (subject_id)\n" + 
				" JOIN deck_cards USING (card_id)\n" + 
				" JOIN deck USING (deck_id)\n" + 
				" WHERE card_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDeckCardById, cardId);
		if (results.next()) {
			 deckCard = mapRowToDeckCard(results);
			}
		
		return deckCard;
	}
 	
	private Deck mapRowToDeck(SqlRowSet rs) {
		Deck deck = new Deck();
		deck.setDeckId(rs.getInt("deck_id"));
		deck.setDeckName(rs.getString("deck_name"));
		deck.setDeckDescription(rs.getString("description"));
		deck.setDeckCreator(rs.getString("deck_creator"));

		return deck;		
	}
	
	private Card mapRowToDeckCard(SqlRowSet rs) {
		Card card = new Card();
		card.setId(rs.getInt("card_id"));
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setSubject(rs.getString("subject_name"));
		card.setCardCreator(rs.getString("card_creator"));
		card.setDeckName(rs.getString("deck_name"));
		card.setCorrect(false);
		
		return card;	
	}
}
