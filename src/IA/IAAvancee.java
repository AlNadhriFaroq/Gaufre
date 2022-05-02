package IA;

import General.Grille;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class IAAvancee {

    Grille g;
    int lignes;
    int colonnes;
    Hashtable<Point, Grille> coupsGagnants;

    public IAAvancee(Grille grille){
        g = grille;
        lignes = g.lignes();
        colonnes = g.colonnes();
        coupsGagnants = new Hashtable<>();
    }


    boolean calculJoueurA(Grille gA){
        if(g.estMangee(0, 0)){
            return true;
        }
        else if(!g.estMangee(0,0) && (g.estMangee(0,1) ||g.estMangee(0,1))){
            return false;
        }
        else{
            boolean valeur = false;
            List<Point> nb_coups = new ArrayList<>();
            for(int i = 0; i < g.lignes(); i++){
                for(int j = 0; j < g.colonnes(); j ++){
                    if(!g.estMangee(i, j)){
                        nb_coups.add(new Point(i, j));
                    }
                }
            }

            for(Point p : nb_coups){
                Grille tmp = g;
                tmp.manger(p.x, p.y);
                if(calculJoueurB(tmp)){
                    valeur = true;
                    coupsGagnants.put(p, tmp);
                }
            }
            return valeur;
        }
    }

    boolean calculJoueurB(Grille g){
        if(g.estMangee(0, 0)){
            return true;
        }
        else if(!g.estMangee(0,0) && (g.estMangee(0,1) ||g.estMangee(0,1))){
            return false;
        }
        else{
            boolean valeur = true;
            List<Point> nb_coups = new ArrayList<>();
            for(int i = 0; i < g.lignes(); i++){
                for(int j = 0; j < g.colonnes(); j ++){
                    if(!g.estMangee(i, j)){
                        nb_coups.add(new Point(i, j));
                    }
                }
            }

            for(Point p : nb_coups){
                Grille tmp = g;
                tmp.manger(p.x, p.y);
                valeur = valeur && calculJoueurA(tmp);
            }
            return valeur;
        }
    }


}
