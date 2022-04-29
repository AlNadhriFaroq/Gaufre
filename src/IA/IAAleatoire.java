package IA;

import General.Grille;
import General.Jeu;

import java.awt.*;
import java.util.Random;

public class IAAleatoire {
    Jeu jeu;
    Grille g;
    int lignes;
    int colonnes;

    public IAAleatoire(Jeu j){
        jeu = j;
        g = jeu.getGraphiqueGrille().getGrille();
        lignes = g.lignes();
        colonnes = g.colonnes();
    }

    Point joueIAAleatoire(){
        Random r = new Random();
        int i = r.nextInt(lignes) + 1;
        int j = r.nextInt(colonnes) + 1;

        while(g.estMangee(i, j)){
            i = r.nextInt(lignes) + 1;
            j = r.nextInt(colonnes) + 1;
        }
        return new Point(i, j);
    }
}

