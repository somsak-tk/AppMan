package com.test;

public class Card {
	
	private int value;
	private boolean bingo = false;
	
	public Card(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isBingo() {
		return bingo;
	}
	public void setBingo(boolean bingo) {
		this.bingo = bingo;
	}
	
	
}
