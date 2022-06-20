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
public final class PortugueseDic extends Strategy {

	private final LinkedList<String> dicPt = new LinkedList<>();

	public PortugueseDic() {
		this.loadDictionarie();
	}

	@Override
	public boolean verifyWord(String word) {
		return dicPt.indexOf(word) != -1;
	}

	@Override
	public LinkedList<String> possibleWords(String word) {
		LinkedList<String> possible = new LinkedList<>();
		
		int wordSize = word.length() / 2;
		
		for(String wordInDic : this.dicPt) {
			if(wordInDic != null && wordInDic.indexOf(word.substring(0, wordSize)) != -1) {
				possible.add(wordInDic);
			}
		}
		
		return possible;
	}

	@Override
	public LinkedList<String> check(String word) {
		if(verifyWord(word)){
			return new LinkedList<>();
		}
		
		return possibleWords(word);
	}

	@Override
	public void loadDictionarie() {
		String line = "";
		int indexOfWord = 0;

		int qtd_col = 0;
		int qtd_inst = 0;

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/pt.dic"), "UTF-16"));
			
//			while ((line = bufferedReader.readLine()) != null) {
//				this.dicPt.add(null);
//			}
			
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/pt.dic"), "UTF-16"));

			while ((line = bufferedReader.readLine()) != null) {
				this.dicPt.add(line);

//				indexOfWord = this.hash(line) % this.dicPt.size();
//				
//				if(indexOfWord < 0){
//					indexOfWord = indexOfWord * -1;
//				}
//
//				try {
//					this.dicPt.get(indexOfWord);
//					qtd_col++;
//
//				} catch (Exception e) {
//					qtd_inst++;
//					this.dicPt.add(indexOfWord, word);
//				}
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
