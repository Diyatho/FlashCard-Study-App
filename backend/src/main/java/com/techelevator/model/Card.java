package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	private int id;
	private String question;
	private String answer;
	private String subject;
	private boolean isCorrect;
	private List<String> keywords = new ArrayList<>();
	
//	public Card (String question, String answer, String subject) {
//	      this.question = question;
//	      this.answer = answer;
//	      this.subject = subject;
//	   
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	

}
