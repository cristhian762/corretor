/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author felipe
 */
public class Save extends JButton implements IButtonCommand {

	public javax.swing.JTextArea text;

	public Save(javax.swing.JTextArea text) {
		this.text = text;
	}

	public void executar() {
		this.save();
	}

	public void save() {
		String current;
		try {
			current = new java.io.File(".").getCanonicalPath();
			PrintWriter writer = new PrintWriter(current + "/src/arquivo.txt", "UTF-8");
			writer.println(text.getText());
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
