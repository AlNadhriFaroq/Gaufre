package Controleur;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IAFacile extends IA {
    Random r;

    public IAFacile(){
        r = new Random();
    }

    @Override
    public List<Point> jouer(){
        List<Point> resultat = new ArrayList<>();

    	int ligne, colonne;
        do {
        	ligne = r.nextInt(grille.lignes());
        	colonne = r.nextInt(grille.colonnes());
        } while(grille.estMangee(ligne, colonne));

        resultat.add(new Point(ligne, colonne));
        return resultat;
    }
}

