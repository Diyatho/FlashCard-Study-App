package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
	
	private Deck mapRowToDeck(SqlRowSet rs) {
		Deck deck = new Deck();
		deck.setDeckId(rs.getInt("deck_id"));
		deck.setDeckName(rs.getString("deck_name"));
//		deck.setDeckDescription(rs.getString("description"));
		deck.setDeckCreatorId(rs.getInt("creator_id"));
		
		return deck;
		
		
	}
}
