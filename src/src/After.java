/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.JButton;
import javax.swing.undo.UndoManager;

/**
 *
 * @author felipe
 * @modifi cristhian
 */
public class After extends JButton implements IButtonCommand {

	private UndoManager undo;

	public After(UndoManager undo) {
		this.undo = undo;
	}

	public void executar() {
		this.doAfter();
	}

	public void doAfter() {
		if (this.undo.canUndo()) {
			this.undo.undo();
		}
	}
}
