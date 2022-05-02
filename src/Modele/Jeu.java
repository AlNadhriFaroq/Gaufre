package Modele;

import Controleur.AnimationIA;
import Global.Configuration;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.Point;

public class Jeu {
	Grille grille;
	Historique histo;
	boolean joueur;
	
	public Jeu() {
		joueur = Boolean.parseBoolean(Configuration.instance().lire("JoueurQuiCommence"));
		int lgn = Integer.parseInt(Configuration.instance().lire("NbLignes"));
		int cln = Integer.parseInt(Configuration.instance().lire("NbColonnes"));
		grille = new Grille(lgn, cln);
		histo = new Historique();
	}

	public Grille grille() {
		return grille;
	}

	public boolean joueur() {
		return joueur;
	}

	public void nouvellePartie() {
		joueur = Boolean.parseBoolean(Configuration.instance().lire("JoueurQuiCommence"));
		int lgn = Integer.parseInt(Configuration.instance().lire("NbLignes"));
		int cln = Integer.parseInt(Configuration.instance().lire("NbColonnes"));
		grille.initialiser(lgn, cln);
		histo.initialiser();
	}

	public boolean grilleTerminee() {
		return grille.estTerminee();
	}

	public boolean peutAnnuler() {
		return histo.peutAnnuler();
	}

	public boolean peutRefaire() {
		return histo.peutRefaire();
	}

	public Point creerCoup(int ligne, int colonne) {
		if (!grille.estMangee(ligne, colonne))
			return new Point(ligne, colonne);
		return null;
	}

	public void faire(Point coup) {
		histo.faire(coup);
		grille.manger(coup.x, coup.y);
		joueur = !joueur;
	}

	public Point annuler() {
		Point coup = histo.annuler();
		grille.initialiser();
		for (Point coupPrec : histo.passe())
			grille.manger(coupPrec.x, coupPrec.y);
		joueur = !joueur;
		return coup;
	}

	public Point refaire() {
		Point coup = histo.refaire();
		grille.manger(coup.x, coup.y);
		joueur = !joueur;
		return coup;
	}

	public void lire(InputStream in) {
		Scanner s = new Scanner(in);

		int lignes = s.nextInt();
		int colonnes = s.nextInt();
		grille.initialiser(lignes, colonnes);

		joueur = s.nextBoolean();

		histo.lire(s);
		for (Point coup : histo.passe())
			grille.manger(coup.x, coup.y);

		s.close();
	}

	public void ecrire(OutputStream out) {
		PrintStream p = new PrintStream(out);

		p.println(grille.lignes());
		p.println(grille.colonnes());

		p.println(joueur);

		histo.ecrire(p);
		p.close();
	}
}
