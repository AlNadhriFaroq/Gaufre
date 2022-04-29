package Buttons;


import General.Jeu;

import java.awt.*;
import java.util.List;


public class BoutonUndo extends MonBouton {
	
	public BoutonUndo(Jeu j) {
		super(j, "Undo");
	}

	
	@Override
	void action() {
		List<Point> coups = jeu.getGrille().getHistorique().revenirEnArriere();
		jeu.getGraphiqueGrille().getGrille().annulerManger(coups);
		jeu.getGraphiqueGrille().repaint();
	}
}
