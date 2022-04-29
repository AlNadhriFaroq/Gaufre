package IA;

import General.Grille;
import General.Jeu;

import java.awt.*;
import java.util.Random;

public class IA {
    Jeu jeu;
    Grille g;
    int lignes;
    int colonnes;
    int lignes_bis;
    int colonnes_bis;
    int cases_ok;
    public IA(Jeu j){
        jeu = j;
        g = jeu.getGraphiqueGrille().getGrille();
        lignes = g.lignes();
        colonnes = g.colonnes();
        ligne_Colonne_bis();
    }

    public Point joueIA(){
        if(premierCoup() || (lignes_bis * colonnes_bis == cases_ok)){
            if(lignes == colonnes){
                return new Point(1, 1);
            }
            else if(lignes < colonnes){
                return new Point(1, lignes);
            }
            else{
                return new Point(1, lignes);
            }
        }
        else if(colonnes_bis == lignes_bis){
            return new Point(1,1);
        }
        else{
            if(cases_ok == (lignes_bis * colonnes_bis)){
                return new Point(1,1);
            }
        }
        return null;
    }

    boolean premierCoup(){
        return !g.estMangee(lignes, colonnes);
    }

    void ligne_Colonne_bis(){
        while(!g.estMangee(0, colonnes_bis)){
            colonnes_bis++;
        }
        while(!g.estMangee(lignes_bis, 0)){
            lignes_bis++;
        }
    }

    void casesNonMangees(){
        for(int i = 0; i < lignes; i++){
            for(int j = 0; i < colonnes; j ++){
                //on compte toutes les cases non mangees
                if (!g.estMangee(i, j)){
                    cases_ok ++;
                }
            }
        }
    }

}
