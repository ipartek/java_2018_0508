package com.ipartek.formacion.pojo;

public class RomanNumber {

	//VARIABLES
	private char word;
	private int code;

	// CONSTRUCTORES
	public RomanNumber() {
		word = ' ';
		code = 1;
	}

	public RomanNumber(char word, int code) {
		this.word = word;
		this.setCode(code);
	}

	// GETTERS - SETTERS
	public char getWord() {
		return word;
	}

	public void setWord(char word) {
		this.word = word;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		if (code > 0) {
			this.code = code;
		}
	}

}
