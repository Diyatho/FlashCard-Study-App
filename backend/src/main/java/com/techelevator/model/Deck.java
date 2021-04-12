package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private int deckId;
	private String deckName;
	private String deckDescription;
	private String deckCreator;
	private List<Card> cards = new ArrayList<>();
	
	
	public int getDeckId() {
		return deckId;
	}
	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	public String getDeckDescription() {
		return deckDescription;
	}
	public void setDeckDescription(String deckDescription) {
		this.deckDescription = deckDescription;
	}
	public String getDeckCreator() {
		return deckCreator;
	}
	
	public void setDeckCreator(String deckCreator) {
		this.deckCreator = deckCreator;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	} 
	
	

}
