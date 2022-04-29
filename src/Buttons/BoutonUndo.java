package Buttons;


import General.GraphiqueGrille;
import General.Grille;
import General.Jeu;

import java.awt.*;
import java.util.List;

public class BoutonUndo extends MonBouton {
	
	public BoutonUndo(Jeu j) {
		super(j, "Undo");
	}

	@Override
	void action() {
		List<Point> coups = j.getHistorique().revenirEnArriere();

		j.getGraphiqueGrille().setGrille(new Grille(j.getGraphiqueGrille().getGrille().lignes(), j.getGraphiqueGrille().getGrille().colonnes(), j.getHistorique().joueurInitial()));
		for (Point coup : coups) {
			j.getGraphiqueGrille().getGrille().manger(coup.x, coup.y);
		}
		j.getGraphiqueGrille().repaint();


		
	}
}
