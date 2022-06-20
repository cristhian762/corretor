/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.LinkedList;

/**
 *
 * @author cristhian
 */
public class SpellChecker {
	Strategy dic;
	
	public SpellChecker(Strategy dic){
		this.dic = dic;
	}
	
	public LinkedList<String> check(String word){
		return this.dic.check(word);
	}
}
