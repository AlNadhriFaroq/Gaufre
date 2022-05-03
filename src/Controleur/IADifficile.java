package Controleur;

import Modele.Grille;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class Couple{
    Boolean b;
    Integer i;

    Couple(Boolean b1, Integer i1){
        b = b1;
        i = i1;
    }
}

public class IADifficile extends IA {
    final Hashtable<Grille, Hashtable<Point, Couple>> configVus;

    public IADifficile(){
        configVus = new Hashtable<>();
    }

    @Override
    public List<Point> jouer() {
        List<Point> resultat = new ArrayList<>();
        Point coup = null;
        if (calculJoueur1(grille)) {
            while((coup = configVus.get(grille).keys().nextElement()) != null){
                System.out.println("Coup : " + coup);
                resultat.add(coup);
            }

        }
        else{
            System.out.println("false");
        }
        System.out.println(configVus.get(grille).toString());
        return resultat;
    }

    boolean calculJoueur1 (Grille grille) {
        if (grille.estMangee(0, 0)) {
            return true;
        } else if (!grille.estMangee(0,0) && (grille.estMangee(0,1) && grille.estMangee(1,0))) {
            return false;
        } else {
            boolean valeur = false;
            List<Point> nb_coups = new ArrayList<>();
            for (int i = 0; i < grille.lignes(); i++)
                for (int j = 0; j < grille.colonnes(); j ++)
                    if (!grille.estMangee(i, j))
                        nb_coups.add(new Point(i, j));

            Grille tmp = grille.clone();
            if(configVus.containsKey(tmp)) {
                for (Point p : nb_coups) {
                    valeur = configVus.get(tmp).get(p).b;
                }
            }
            else{
                System.out.println("joueur 1 nouvelle config");
                Hashtable<Point,Couple> h = new Hashtable<>();

                for (Point p : nb_coups) {

                    tmp.manger(p.x, p.y);

                    if (calculJoueur2(tmp)) {
                        valeur = true;

                    }
                    h.put(p, new Couple(valeur, 100));
                 }
                configVus.put(tmp, h);
                System.out.println(configVus.get(tmp).toString());
            }
            return valeur;
        }
    }

    boolean calculJoueur2 (Grille grille) {
        if (grille.estMangee(0, 0)) {
            return true;
        } else if (!grille.estMangee(0,0) && (grille.estMangee(0,1) && grille.estMangee(1,0))) {
            return false;
        } else {
            boolean valeur = true;
            List<Point> nb_coups = new ArrayList<>();
            for (int i = 0; i < grille.lignes(); i++)
                for (int j = 0; j < grille.colonnes(); j ++)
                    if (!grille.estMangee(i, j))
                        nb_coups.add(new Point(i, j));

            Grille tmp = grille.clone();
            if(configVus.containsKey(tmp)) {
                for (Point p : nb_coups) {
                    valeur = !configVus.get(tmp).get(p).b;
                }
            }
            else{
                System.out.println("joueur 2 nouvelle config");
                Hashtable<Point, Couple> h = new Hashtable<>();
                for (Point p : nb_coups) {

                    tmp.manger(p.x, p.y);

                    if (calculJoueur1(tmp)) {
                        valeur = false;
                    }
                    h.put(p, new Couple(valeur, 100));
                }
                configVus.put(tmp, h);
            }
            return valeur;
        }
    }


}