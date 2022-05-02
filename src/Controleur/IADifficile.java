package Controleur;

import Modele.Grille;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class IADifficile extends IA {
    final Hashtable<Grille, Point> configVus;

    public IADifficile(){
        configVus = new Hashtable<>();
    }

    @Override
    public List<Point> jouer() {
        List<Point> resultat = new ArrayList<>();
        Point coup = null;

        //calculs

        resultat.add(coup);
        return resultat;
    }

    boolean calculJoueur1 (Grille grille) {
        if (grille.estMangee(0, 0)) {
            return true;
        } else if (!grille.estMangee(0,0) && (grille.estMangee(0,1) || grille.estMangee(0,1))) {
            return false;
        } else {
            boolean valeur = false;
            List<Point> nb_coups = new ArrayList<>();
            for (int i = 0; i < grille.lignes(); i++)
                for (int j = 0; j < grille.colonnes(); j ++)
                    if (!grille.estMangee(i, j))
                        nb_coups.add(new Point(i, j));

            for (Point p : nb_coups) {
                Grille tmp = grille.clone();
                tmp.manger(p.x, p.y);
                if (calculJoueur2(tmp)) {
                    valeur = true;
                    configVus.put(tmp, p);
                }
            }
            return valeur;
        }
    }

    boolean calculJoueur2 (Grille grille) {
        if (grille.estMangee(0, 0)) {
            return true;
        } else if (!grille.estMangee(0,0) && (grille.estMangee(0,1) ||grille.estMangee(0,1))) {
            return false;
        } else {
            boolean valeur = true;
            List<Point> nb_coups = new ArrayList<>();
            for (int i = 0; i < grille.lignes(); i++)
                for (int j = 0; j < grille.colonnes(); j ++)
                    if (!grille.estMangee(i, j))
                        nb_coups.add(new Point(i, j));

            for (Point p : nb_coups) {
                Grille tmp = grille.clone();
                tmp.manger(p.x, p.y);
                valeur = valeur && calculJoueur1(tmp);
            }
            return valeur;
        }
    }
}