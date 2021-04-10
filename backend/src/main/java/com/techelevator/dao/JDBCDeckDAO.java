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

	@Override
	public boolean initializeDeck(String deckName) {
		
		boolean deckInitialized = false;
		
		String sqlInitDeck = "INSERT INTO deck (deck_name, creator_id) VALUES (?, 3);";
		
		deckInitialized = jdbcTemplate.update(sqlInitDeck, deckName) == 1; 
		
		return deckInitialized;	
	}
	
	@Override
	public List<Deck> getAllDecksByUser(String user) {
		List<Deck> allDecks = new ArrayList<>();
		
		String sqlDecksByUser = "SELECT deck_id, deck_name, creator_id FROM deck" + 
				" WHERE creator_id = (SELECT user_id FROM users WHERE username = ?);";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDecksByUser, user);
		while (results.next() ) {
			Deck deck = mapRowToDeck(results);
			allDecks.add(deck);
		}

				
		return allDecks;
	}
	
	@Override
	public List<Deck> getAllDecksWithCards(String user) {
		//loop through user decks and add list of cards to each deck
		List<Deck> userDecks = getAllDecksByUser(user);
		
			for(Deck deck: userDecks) {
				List<Card> cardsInDeck = getCardsByDeck(deck.getDeckName()); //returns list of cards in each deck
//				System.out.println(cardsInDeck);
				deck.setCards(cardsInDeck); //set list of cards to that deck
			}
		return userDecks;
	}
	
	
	private List<Card> getCardsByDeck(String deckName) {
		List<Card> deckCards = new ArrayList<>();

		String sqlGetCardsByDeck = "SELECT card_id, question, answer, subject.subject_name, cards.creator_id" + 
				" FROM cards JOIN subject USING (subject_id) JOIN deck_cards USING (card_id)" + 
				" JOIN deck USING (deck_id)" + 
				" WHERE deck.deck_id = ?;";

				//" WHERE deck.deck_id = (SELECT deck_id FROM deck WHERE deck_name = ?);";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsByDeck, 13);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		while (results.next()) {
			Card card = mapRowToCard(results);
			deckCards.add(card);
		}
		return deckCards;
	}
	
	private Deck mapRowToDeck(SqlRowSet rs) {
		Deck deck = new Deck();
		deck.setDeckId(rs.getInt("deck_id"));
		deck.setDeckName(rs.getString("deck_name"));
//		deck.setDeckDescription(rs.getString("description"));
		deck.setDeckCreatorId(rs.getInt("creator_id"));
		
		return deck;		
	}
	
	private Card mapRowToCard(SqlRowSet rs) {
		Card card = new Card();
		card.setId(rs.getInt("card_id"));
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setSubject(rs.getString("subject_name"));
		
		return card;	
	}
}
