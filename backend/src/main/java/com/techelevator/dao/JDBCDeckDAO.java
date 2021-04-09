package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCDeckDAO implements DeckDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCDeckDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean initializeDeck(String deckName) {
		
		boolean deckInitialized = false;
		
		String sqlInitDeck = "INSERT INTO deck (deck_name) VALUES (?);";
		
		deckInitialized = jdbcTemplate.update(sqlInitDeck, deckName) == 1; 
		
		return deckInitialized;	
	}
	
}
