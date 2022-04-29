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
		try {
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
			//String nom = "ressources" + File.separator + "sauvegardes" + File.separator + jeu.getGrille().lignes() + "x" + jeu.getGrille().colonnes() + "_" + dtf.format(LocalDateTime.now()) + ".txt";
			String nom = "ressources" + File.separator + "sauvegardes" + File.separator + "sauvegarde.txt";
			File f = new File(nom);
			f.createNewFile();
			OutputStream out = new FileOutputStream(f);
			jeu.getHistorique().ecrire(out, new Point(jeu.getGrille().lignes(), jeu.getGrille().colonnes()));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
