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

	private Card mapRowToCard(SqlRowSet rs) {
		Card card = new Card();
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setSubject(rs.getString("subject_name"));
		
		return card;
	
	}

}
