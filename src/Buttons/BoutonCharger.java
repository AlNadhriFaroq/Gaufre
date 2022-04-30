package Buttons;


import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import General.InterfaceGraphique;


public class BoutonCharger extends MonBouton{
	
	public BoutonCharger(InterfaceGraphique j) {
		super(j, "Charger");
	}

	
	@Override
	void action() {
		this.jeu.getGraphiqueGrille().getGrille().load("load");
		jeu.getGraphiqueGrille().repaint();
	}
}
