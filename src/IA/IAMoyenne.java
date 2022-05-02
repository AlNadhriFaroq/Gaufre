package IA;


import General.Grille;
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
        //rectangle
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
            //configuration pas forcement gagnante
            else{
                Random r = new Random();
                int l, c;
                do {
                    l = r.nextInt(g.lignes());
                    c = r.nextInt(g.colonnes());
                } while((g.estMangee(l, c) || (l == 0 && c == 0)) || estPerdant(l, c));
                System.out.println("" + estPerdant(l, c));
                return new Point(l, c);
            }
        }
    }

    Point grilleCarre(int i, int j){
        System.out.println("grille carree");
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

    boolean estPerdant(int l, int c) {
        Grille tmp = g;

        if(l == 1 && c == 1){
            System.out.println("l == 1 && c == 1");
            return true;
        }

        if(l == 0 || c == 0){
            System.out.println("l == 0 || c == 0");
            return true;
        }

        tmp.manger(l, c);
        int i = 0, j = 0;
        while (j < colonnes && !tmp.estMangee(0, j)) {
            j++;
        }
        while (i < lignes && !tmp.estMangee(i, 0)) {
            i++;
        }
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
