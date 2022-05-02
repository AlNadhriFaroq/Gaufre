package Controleur;

import Global.Configuration;
import Modele.Jeu;
import Modele.Grille;

import java.util.List;
import java.awt.Point;

abstract class IA {
    private Jeu jeu;
    Grille grille;

    static IA nouvelle(Jeu jeu, boolean joueur) {
        IA instance = null;
        String nom;
        if (joueur)
            nom = Configuration.instance().lire("Joueur1IADifficulte");
        else
            nom = Configuration.instance().lire("Joueur2IADifficulte");
        switch (nom) {
            case "0":
                instance = new IAFacile();
                break;
            case "1":
                instance = new IAMoyenne();
                break;
            case "2":
                instance = new IADifficile();
                break;
            default:
                System.err.println("Impossible de trouver l'IA : " + nom);
                break;
        }
        instance.jeu = jeu;
        return instance;
    }

    final List<Point> elaborerCoups() {
        grille = jeu.grille().clone();
        return jouer();
    }

    final void activerIA() {
        if (jeu.grille() != null) {
            grille = jeu.grille().clone();
        }
    }

    List<Point> jouer() {
        return null;
    }
}
