package IA;


import General.Grille;

import java.awt.*;
import java.util.Random;


public class IAAleatoire {
    Grille g;
    Random r ;

    
    public IAAleatoire(Grille grille){
        g = grille;
        r =  new Random();
    }

    
    public Point joueIAAleatoire(){
    	int l, c;
        do {
        	l = r.nextInt(g.lignes());
        	c = r.nextInt(g.colonnes());
        } while(g.estMangee(l, c));
        
        return new Point(l, c);
    }
}

