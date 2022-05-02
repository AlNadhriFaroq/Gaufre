package Controleur;

import Modele.Grille;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

public class IAMoyenne extends IA {
    Random r;
    int nbCasesNonMangees;

    public IAMoyenne() {
        r = new Random();
    }

    @Override
    public List<Point> jouer() {
        List<Point> resultat = new ArrayList<>();
        Point coup = null;

        nbCasesNonMangees = nbCasesNonMangees();

        int i = 0, j = 0;
        while (j < grille.colonnes() && !grille.estMangee(0, j))
            j++;
        while (i < grille.lignes() && !grille.estMangee(i, 0))
            i++;

        // s il y a le meme nombre de lignes que de colonnes, ca vaut au mieux a un carre
        if (i == j) {
            coup = grilleCarre(i, j);
        } else { //rectangle
            //configuration gagnante, on gagne, on mange l un des bords
            if (grille.estMangee(1, 1)) {
                if (i > j)
                    coup = new Point(j, 0);
                else
                    coup = new Point(0, i);
            } else { //configuration pas forcement gagnante
                Random r = new Random();
                int l, c;
                do {
                    l = r.nextInt(grille.lignes());
                    c = r.nextInt(grille.colonnes());
                } while((grille.estMangee(l, c) || (l == 0 && c == 0)) || estPerdant(l, c));
                System.out.println("" + estPerdant(l, c));
                coup = new Point(l, c);
            }
        }

        resultat.add(coup);
        return resultat;
    }

    int nbCasesNonMangees() {
        int nbCasesNonMangees = 0;
        for (int l = 0; l < grille.lignes(); l++)
            for (int c = 0; c < grille.colonnes(); c++)
                if (!grille.estMangee(l, c))
                    nbCasesNonMangees++;
        return nbCasesNonMangees;
    }

    Point grilleCarre(int i, int j){
        //si la case 1,1 pas mangee, on sera dans une configuration gagnante si on la mange, donc on la mange
        if (!grille.estMangee(1, 1)){
            return new Point(1, 1);
        } else { //si elle est mangee on est dans une configuration perdante normalement, on mange une des cases
            int choix = r.nextInt(2);
            switch (choix) {
                case 0:
                    System.out.println(0 + " " + j);
                    return new Point(0, j-1);
                case 1:
                    System.out.println(i + " " + 0);
                    return new Point(i-1, 0);
            }
        }
        System.out.println("null");
        return null;
    }

    boolean estPerdant(int l, int c) {
        Grille tmp = grille.clone();

        if (l == 1 && c == 1) {
            System.out.println("l == 1 && c == 1");
            return true;
        }

        if (l == 0 || c == 0) {
            System.out.println("l == 0 || c == 0");
            return true;
        }

        tmp.manger(l, c);
        int i = 0, j = 0;
        while (j < grille.colonnes() && !tmp.estMangee(0, j))
            j++;
        while (i < grille.lignes() && !tmp.estMangee(i, 0))
            i++;

        System.out.println("apres boucle");
        if (i == j) {
            System.out.println(" i et j valent pareil et 1 1 est mangee");
            return true;
        }

        if (i == 0 || j == 0) {
            System.out.println(" i et j valent 0");
            return true;
        }

        return false;
    }
}
