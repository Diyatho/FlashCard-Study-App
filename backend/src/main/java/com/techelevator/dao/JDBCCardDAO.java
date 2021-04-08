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
	
	@Override
	public boolean createSubject(String subject) {
		boolean subjectCreated = false;
		
		String sqlAddSubject = "INSERT INTO subject (subject_name) VALUES (?);";
		
		subjectCreated = jdbcTemplate.update(sqlAddSubject, subject) == 1;
		
		return subjectCreated;
	}
	
	@Override
	public boolean createCard(String question, String answer, String subject, String user) {
		boolean cardCreated = false;
		
		
		String sqlAddCard = "BEGIN TRANSACTION; INSERT INTO cards" + 
				" (question, answer, subject_id, creator_id)" + 
				" VALUES (?, ?, " +
				" (SELECT subject_id FROM subject WHERE subject_name = ?)," +
				" (SELECT user_id FROM users WHERE username = '?'));";

		
		cardCreated = jdbcTemplate.update(sqlAddCard, question, answer, subject, user) == 1;
		
		return cardCreated;
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
