package Buttons;


import General.InterfaceGraphique;


public class BoutonNouvellePartie extends MonBouton {
	
	public BoutonNouvellePartie(InterfaceGraphique j) {
		super(j, "Nouvelle Partie");
	}

	@Override
	void action() {
		this.jeu.getGraphiqueGrille().getGrille().nouvellepartie();
		this.jeu.getGraphiqueGrille().getGrille().restartg();
		repaint();

	}

}
