package Buttons;


import General.Jeu;

import java.awt.*;
import java.util.List;


public class BoutonAnnuler extends MonBouton {
	
	public BoutonAnnuler(Jeu j) {
		super(j, "Annuler");
	}

	
	@Override
	void action() {
		List<Point> coups = jeu.getGrille().getHistorique().revenirEnArriere();
		jeu.getGraphiqueGrille().getGrille().annulerManger(coups);
		jeu.getGraphiqueGrille().repaint();
	}
}
