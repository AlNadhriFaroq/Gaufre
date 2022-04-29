package Buttons;


import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import General.Jeu;


public class BoutonCharger extends MonBouton{
	
	public BoutonCharger(Jeu j) {
		super(j, "Charger");
	}

	
	@Override
	void action() {
		try {
			String nom = "ressources" + File.separator + "sauvegardes" + File.separator + "sauvegarde.txt";
			File f = new File(nom);
			InputStream in = new FileInputStream(f);
			
			Point dimGrille = jeu.getHistorique().lire(in);
			jeu.getGrille().initialiser(dimGrille.x, dimGrille.y, jeu.getHistorique().joueurInitial());
			jeu.getGrille().iterManger(jeu.getHistorique().historiqueAvant());
			jeu.getGraphiqueGrille().repaint();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
