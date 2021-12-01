package com.craigcode.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

//@Component
public class Turn {
	private boolean winner = false;
	
	
	// Contains all the information needed for the U/I to show turn results
	private ArrayList<Hand> hands = new ArrayList<Hand>();
	private Deck deck = new Deck();
	private int nextPlayer = 0;
	private boolean reverse = false;
	private int currentPlayer;
	private Cards cardPlayed;
	private int turns = 0;
	private Cards topDiscard;

	public ArrayList<Hand> getHands() {
		return hands;
	}

	public Deck getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		return "Turn [hands=" + hands + ", deck=" + deck + ", nextPlayer=" + nextPlayer + ", reverse=" + reverse
				+ ", currentPlayer=" + currentPlayer + ", winner=" + winner + ", cardPlayed=" + cardPlayed + ", turns="
				+ turns + ", topDiscard=" + topDiscard + "]";
	}

	public int getNextPlayer() {
		return nextPlayer;
	}

	public boolean isReverse() {
		return reverse;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isWinner() {
		return winner;
	}

	public Cards getCardPlayed() {
		return cardPlayed;
	}

	public int getTurns() {
		return turns;
	}

	public Cards getTopDiscard() {
		return topDiscard;
	}

	// constructor
	public Turn(ArrayList<Hand> hands, Deck deck, int nextPlayer, boolean reverse, int currentPlayer, boolean winner,
			Cards cardPlayed, int turns, Cards topDiscard) {
		super();
		this.hands = hands;
		this.deck = deck;
		this.nextPlayer = nextPlayer;
		this.reverse = reverse;
		this.currentPlayer = currentPlayer;
		this.winner = winner;
		this.cardPlayed = cardPlayed;
		this.turns = turns;
		this.topDiscard = topDiscard;
	}
}
