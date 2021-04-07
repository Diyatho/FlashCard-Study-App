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
	public List<Card> getAllCards(int userId) {
		List<Card> allCards = new ArrayList<>();
		
		String sqlGetAllCards = "SELECT question, answer, subject.subject_name FROM cards"
				+ " JOIN subject USING (subject_id) WHERE creator_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCards, userId); 
		while (results.next()) {
			Card card = mapRowToCard(results);
			allCards.add(card);
		}
		
		return allCards;
	}
	
	@Override
	public Card getCardById(int userId, int cardId) {
		
		String sqlGetCardById = "SELECT question, answer, subject.subject_name FROM cards"
				+ " JOIN subject USING (subject_id) WHERE creator_id = ? AND card_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardById, userId, cardId);
		results.next();
		Card card = mapRowToCard(results);
		
		return card;
	}



	@Override
	public List<Card> getCardsBySubject(int userId, String subject) {
		
		List<Card> cards = new ArrayList<>();
		
		String sqlGetCardBySubject = "SELECT question, answer, subject.subject_name FROM cards"
				+ " JOIN subject USING (subject_id) WHERE creator_id = ? AND subject.subject_name = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardsBySubject, userId, subject);
		while (results.next()) {
			Card card = mapRowToCard(results);
			cards.add(card);
		}
				 
				
		return cards;
	}

	@Override
	public List<Card> getCardsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Card mapRowToCard(SqlRowSet rs) {
		Card card = new Card();
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setSubject(rs.getString("subject_name"));
		
		return card;
	
	}

}
