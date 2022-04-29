package Buttons;

import java.awt.Point;

import General.InterfaceGraphique;


public class BoutonRefaire extends MonBouton{
	
	public BoutonRefaire(InterfaceGraphique j) {
		super(j, "Refaire");
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
