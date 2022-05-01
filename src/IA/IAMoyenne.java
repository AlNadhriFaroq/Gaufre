package IA;


import General.Grille;
import General.InterfaceGraphique;

import java.awt.*;
import java.util.Random;


public class IAMoyenne {

    Grille g;
    int lignes;
    int colonnes;
    int cases_ok;
    

    public IAMoyenne(Grille grille){
        g = grille;
        lignes = g.lignes();
        colonnes = g.colonnes();
    }

    public Point joueIAMoyenne(){

        int i = 0, j = 0;
        while(j < colonnes && !g.estMangee(0, j)){
            j++;
        }
        while(i < lignes && !g.estMangee(i, 0) ){
            i++;
        }
        // s il y a le meme nombre de lignes que de colonnes, ca vaut au mieux a un carre
        if(i == j){
            return grilleCarre(i, j);
        }
        else{
            //configuration gagnante, on gagne, on mange l un des bords
            if(g.estMangee(1, 1)){
                if(i > j){
                    return new Point(j, 0);
                }
                else{
                    return new Point(0, i);
                }
            }
            else{
                Random r = new Random();
                int l, c;
                do {
                    l = r.nextInt(g.lignes());
                    c = r.nextInt(g.colonnes());
                } while(g.estMangee(l, c) || (l != 0 && c != 0));
                return new Point(l, c);
            }
        }
    }

    Point grilleCarre(int i, int j){
        //si la case 1,1 pas mangee, on sera dans une configuration gagnante si on la mange, donc on la mange
        if(!g.estMangee(1, 1)){
            return new Point(1, 1);
        }
        //si elle est mangee on est dans une configuration perdante normalement, on mange une des cases
        else{
            Random r = new Random();
            int choix = r.nextInt(2);
            switch (choix){
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

    void nbCasesNonMangees(){
        for(int i = 0; i < lignes; i++){
            for(int j = 0; j < colonnes; j++) {
                if (!g.estMangee(i, j)) {
                    cases_ok ++;
                }
            }
        }
    }

    boolean estCarre(int i, int j){
        return false;
    }
}
