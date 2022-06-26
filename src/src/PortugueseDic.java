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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristhian
 */
public final class PortugueseDic extends Strategy {
	
	private ArrayList listPrime = null;
	
	private final int TAM = 2069827;

	private final LinkedList<ArrayList> dic = new LinkedList<>();

	public PortugueseDic() {
		this.loadDictionarie();
	}

	@Override
	public boolean verifyWord(String word) {
		return !this.dic.get(hash(word)).isEmpty();
	}

	@Override
	public LinkedList<String> possibleWords(String word) {
		LinkedList<String> possible = new LinkedList<>();

		if(word.length() > 3)
			for(ArrayList list : this.dic)
				if(!list.isEmpty())
					for(Object wordDic : list)
						if(wordDic.toString().length() > 3 && word.substring(0, 3).equals(wordDic.toString().substring(0, 3)))
							possible.add(wordDic.toString());
		
		return possible;
	}

	@Override
	public LinkedList<String> check(String word) {
		if (verifyWord(word)) 
			return new LinkedList<>();

		return possibleWords(word);
	}

	@Override
	public void loadDictionarie() {
		Prime prime = new Prime();
		
		this.listPrime = prime.getPrime();
		
		String line = "";
		String source = "src/pt.dic";

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-16"));

			for (int i = 0; i < this.TAM; i++) 
				this.dic.add(new ArrayList());

			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-16"));

			while ((line = bufferedReader.readLine()) != null)
				this.dic.get(hash(line)).add(line);
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(PortugueseDic.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PortugueseDic.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int hash(String str) {
		int h = 0, c;

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			h += c * (int) listPrime.get(c * i % 101);
		}
		
		
		if(h < 0)
			h = h * -1;
		
		return h;
	}
}
