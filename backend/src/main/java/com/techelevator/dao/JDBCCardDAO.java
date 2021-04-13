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
	
	@Override
	public Card getCardById(int cardId) {
		
		String sqlGetCardById = "SELECT card_id, question, answer, subject.subject_name, (SELECT username FROM users WHERE user_id = cards.creator_id) AS card_creator, deck.deck_name" +
				" FROM cards" + 
				" JOIN subject USING (subject_id)" +
				" JOIN deck_cards USING (card_id)" +
				" JOIN deck USING (deck_id)" +
				" WHERE card_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardById, cardId);
		results.next();
		Card card = mapRowToDeckCard(results);
		
		return card;
	}
	//unused
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
	//unused
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
		if (subject == null) {
			subject = "no subject";
			createSubject(subject);
			int newCardId = intializeCard(question, answer, subject, user);
			addCardToDeck(deckName,  user, newCardId);
		}
		createSubject(subject);
		int newCardId = intializeCard(question, answer, subject, user);
		addCardToDeck(deckName,  user, newCardId);
		
	}

	private int intializeCard(String question, String answer, String subject, String user) {
		int newCardId;
		//subject null check
		String sqlAddCard = "INSERT INTO cards" + 
				" (question, answer, subject_id, creator_id)" + 
				" VALUES (?, ?," +
				" (SELECT subject_id FROM subject WHERE subject_name = ?)," +
				" (SELECT user_id FROM users WHERE username = ? )) RETURNING card_id;";

		newCardId = jdbcTemplate.queryForObject(sqlAddCard, Integer.class, question, answer, subject, user);
		
		return newCardId;
	}
	private void addCardToDeck(String deckName, String user, int cardId) {

		
		String sqlAddCardToDeck = "INSERT INTO deck_cards (deck_id, card_id)" + 
				" VALUES ((SELECT deck_id FROM deck WHERE deck_name = ? AND deck.creator_id = " +
				" (SELECT user_id FROM users WHERE username = ?)), ?);";
		
		jdbcTemplate.update(sqlAddCardToDeck, deckName, user, cardId);		

	}

	
	@Override
	public boolean addKeywordsToCard(String user, String answer, String keywords) {
		return false;
	}
	
	@Override
 	public void editCard(String question, String answer, String subject, int cardId) {

 		String sqlEditCard = "UPDATE cards SET question = ?, answer = ?, subject_id = (SELECT subject_id FROM subject WHERE subject_name = ?)" + 
 				" WHERE card_id = ?;";
 		
 		jdbcTemplate.update(sqlEditCard, question, answer, subject, cardId);
 	}
	
	@Override 
	public void deleteCard(int cardId) {
		String sqlDeleteCard = "DELETE FROM deck_cards WHERE card_id = 33;" + 
				" DELETE FROM cards WHERE card_id = ?;";
		
		jdbcTemplate.update(sqlDeleteCard, cardId);
		
	}
	
	private Card mapRowToCard(SqlRowSet rs) {
		Card card = new Card();
		card.setId(rs.getInt("card_id"));
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setSubject(rs.getString("subject_name"));
		
		return card;	
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
