/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author cristhian
 */
public class Dictionary {
	private String word;

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void printWord() {
		System.out.println("Word: " + getWord());
	}
}
