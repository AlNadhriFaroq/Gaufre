package Buttons;


import java.awt.Point;
import java.io.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import General.InterfaceGraphique;


public class BoutonSauver extends MonBouton{
	
	public BoutonSauver(InterfaceGraphique j) {
		super(j, "Sauver");
	}

	
	@Override
	void action() {
		this.jeu.getGraphiqueGrille().getGrille().save("load");
		repaint();
	}
}
