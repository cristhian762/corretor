/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristhian
 */
public class PortugueseDic extends Strategy {

	private LinkedList<Dictionary> dicPt = new LinkedList<>();

	public PortugueseDic() {
		this.loadDictionarie();
	}

	@Override
	public boolean verifyWord() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public LinkedList<String> possibleWords() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public LinkedList<String> check(String word) {
		System.out.println("Verificar palavra: " + word);

		return new LinkedList<>();
	}

	@Override
	public void loadDictionarie() {
		Dictionary word = null;
		String line = "";
		int indexOfWord = 0;

		int qtd_col = 0;
		int qtd_inst = 0;

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/pt.dic"), "UTF-16"));
			
			while ((line = bufferedReader.readLine()) != null) {
				this.dicPt.add(null);
			}
			
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/pt.dic"), "UTF-16"));

			while ((line = bufferedReader.readLine()) != null) {
				word = new Dictionary();

				word.setWord(line);

				indexOfWord = this.hash(line) % this.dicPt.size();
				
				if(indexOfWord < 0){
					indexOfWord = indexOfWord * -1;
				}

				try {
					this.dicPt.get(indexOfWord);
					qtd_col++;

				} catch (Exception e) {
					qtd_inst++;
					this.dicPt.add(indexOfWord, word);
				}
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(PortugueseDic.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PortugueseDic.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		System.out.println("Qtd coli: " + qtd_col);
		System.out.println("Qtd inst: " + qtd_inst);
	}
	
	public int hash(String str) {
		int hash = 0;
		
		for (int i = 0; i < str.length(); i++) {
			hash = str.charAt(i) + ((hash << 5) - hash);
		}
		
		return hash;
	}
}
