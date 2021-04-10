package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private int deckId;
	private String deckName;
	private String deckDescription;
	private int deckCreatorId;
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
	public int getDeckCreatorId() {
		return deckCreatorId;
	}
	
	public void setDeckCreatorId(int deckCreatorId) {
		this.deckCreatorId = deckCreatorId;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	} 
	
	

}
