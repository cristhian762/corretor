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
 */
public class Before extends JButton implements IButtonCommand {

	private UndoManager undo;

	public Before(UndoManager undo) {
		this.undo = undo;
	}

	public void doBefore() {
		if (undo.canRedo()) {
			undo.redo();
		}
	}

	@Override
	public void executar() {
		doBefore();
	}

}
