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
abstract class Strategy {
	public abstract boolean verifyWord(String word);
	public abstract LinkedList<String> possibleWords(String word);
	public abstract LinkedList<String> check(String word);
	public abstract void loadDictionarie();
}
