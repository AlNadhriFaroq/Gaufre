package Buttons;

import java.awt.Point;

import General.Jeu;


public class BoutonRedo extends MonBouton{
	
	public BoutonRedo(Jeu j) {
		super(j, "Redo");
	}

	
	@Override
	void action() {
		Point coup = jeu.getGrille().getHistorique().recupererCoupSuivant();
		if (coup != null) {
			jeu.getGraphiqueGrille().getGrille().manger(coup.x, coup.y);
			jeu.getGraphiqueGrille().repaint();
		}
	}
}
