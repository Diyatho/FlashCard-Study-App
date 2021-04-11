package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Card;

@Component
public class JDBCCardDAO implements CardDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCardDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Card> getAllCards(String user) {
		List<Card> allCards = new ArrayList<>();
		
		String sqlGetAllCards = "SELECT card_id, question, answer, subject.subject_name FROM cards\n" + 
				"JOIN subject USING (subject_id)\n" + 
				"JOIN users on users.user_id = cards.creator_id\n" + 
				"WHERE username = ?;";
	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCards, user); 
		while (results.next()) {
			Card card = mapRowToCard(results);
			allCards.add(card);
		}
		
		return allCards;
	}
//	@Override
//	public List<Card> getCardsByDeck(String deckName, String user) {
//		List<Card> deckCards = new ArrayList<>();
//		
//		String sqlGetCardsByDeck = "SELECT question, answer, subject.subject_name, cards.creator_id" + 
//				" FROM cards JOIN subject USING (subject_id) JOIN deck_cards USING (card_id)" + 
//				" JOIN deck USING (deck_id)" + 
//				" WHERE deck.deck_id = (SELECT deck.deck_id FROM deck WHERE deck_name = ?);";
//		
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsByDeck, deckName, user);
//		while (results.next()) {
//			Card card = mapRowToCard(results);
//			deckCards.add(card);
//		}
//		return deckCards;
//	}
//	
//	@Override
//	public List<Card> getCardsByDeckId(int deckId) {
//		List<Card> deckCards = new ArrayList<>();
//		
//		String sqlGetCardsByDeckId = "SELECT card_id, question, answer, subject.subject_name, cards.creator_id" + 
//				" FROM cards" + 
//				" JOIN subject USING (subject_id)" + 
//				" JOIN deck_cards USING (card_id)" + 
//				" JOIN deck USING (deck_id)" + 
//				" WHERE deck_id = ?;";
//		
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsByDeckId, deckId);
//		while (results.next()) {
//			Card card = mapRowToCard(results);
//			deckCards.add(card);
//		}
//		return deckCards;
//	}

	
	@Override
	public Card getCardById(String user, int cardId) {
		
		String sqlGetCardById = "SELECT question, answer, subject.subject_name FROM cards"
				+ " JOIN subject USING (subject_id) JOIN users ON creator_id = user_id"
				+ " WHERE users.username = ? AND card_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardById, user, cardId);
		results.next();
		Card card = mapRowToCard(results);
		
		return card;
	}

	@Override
	public List<Card> getCardsBySubject(String user, String subject) {
		
		List<Card> cards = new ArrayList<>();
		
		String sqlGetCardsBySubject = "SELECT card_id, question, answer, subject.subject_name FROM cards"
				+ " JOIN subject USING (subject_id) JOIN users ON creator_id = user_id"
				+ " WHERE users.username = ? AND subject.subject_name = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsBySubject, user, subject);
		while (results.next()) {
			Card card = mapRowToCard(results);
			cards.add(card);
		}		 				
		return cards;
	}

	@Override
	public List<Card> getCardsByKeyword(String user, String keyword) {
		List<Card> cards = new ArrayList<>();
		
		String sqlGetCardsByKeyword = "SELECT card_id, question, answer, subject.subject_name, \n" + 
				" FROM cards\n" + 
				" JOIN subject USING (subject_id)\n" + 
				" JOIN card_keyword USING (card_id)\n" + 
				" JOIN keyword USING (keyword_id)\n" + 
				" JOIN users ON creator_id = user_id\n" + 
				" WHERE users.username = ? AND keyword.keyword ILIKE ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsByKeyword, user, keyword);
		while (results.next()) {
			Card card = mapRowToCard(results);
			cards.add(card);
		}
		
		return cards;
	}
	//createSubject checks if subject exists, if it does exist, it stops
	//if subject does not exist, it creates the subjects
	@Override
	public void createSubject(String subject) {
		String sqlCheckSubject = "SELECT subject_name FROM subject" +
				" WHERE subject_name = ?;";
		SqlRowSet subjectRow = jdbcTemplate.queryForRowSet(sqlCheckSubject, subject);
	
		if (subjectRow.next() == false) {
			String sqlAddSubject = "INSERT INTO subject (subject_name) VALUES (?);";
			jdbcTemplate.update(sqlAddSubject, subject);	
		}
	}
	
	@Override
	public void createCard(String question, String answer, String subject, String deckName, String user) {
		createSubject(subject);
		int newCardId = intializeCard(question, answer, subject, user);
		addCardToDeck(deckName, newCardId);
		
	}

	private int intializeCard(String question, String answer, String subject, String user) {
		int newCardId;
		String sqlAddCard = "INSERT INTO cards" + 
				" (question, answer, subject_id, creator_id)" + 
				" VALUES (?, ?," +
				" (SELECT subject_id FROM subject WHERE subject_name = ?)," +
				" (SELECT user_id FROM users WHERE username = ? )) RETURNING card_id;";

		newCardId = jdbcTemplate.queryForObject(sqlAddCard, Integer.class, question, answer, subject, user);
		
		return newCardId;
	}
	
	private void addCardToDeck(String deckName, int cardId) {
		
		String sqlAddCardToDeck = "INSERT INTO deck_cards (deck_id, card_id)" + 
				" VALUES ((SELECT deck_id FROM deck WHERE deck_name = ?), ?);";
		
		jdbcTemplate.update(sqlAddCardToDeck, deckName, cardId);		

	}
	
	@Override
	public boolean addKeywordsToCard(String user, String answer, String keywords) {
		return false;
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
