package Modele;

import Global.Configuration;

public class Grille implements Cloneable {
    int lignes, colonnes;
    boolean[][] grille;

    public Grille(int lignes, int colonnes) {
        initialiser(lignes, colonnes);
    }
    
    public int lignes() {
        return lignes;
    }
    
    public int colonnes() {
        return colonnes;
    }

    /* Initialise toutes les cases a faux. */
    public void initialiser() {
        for(int l = 0; l < lignes; l++ )
            for(int c = 0; c < colonnes; c++ )
                grille[l][c] = false;
    }

    /* Redimensionne la grille, puis initialise toutes les cases a faux. */
    public void initialiser(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        grille = new boolean[lignes][colonnes];
        initialiser();
    }

    /* Passe toutes les cases du rectangle inferieur a vrai. */
    public void manger(int ligne , int colonne) {
        int l = ligne, c = colonne;
        
	    while((l < lignes)  && !estMangee(l, c)) {
	        grille[l][c] = true;
	        c++;
	        while ((c < colonnes) && !estMangee(l, c)) {
	            grille[l][c] = true;
	            c++;
	        }
	        c = colonne;
	        l++;
	    }
    }

    public boolean estMangee(int ligne , int colonne) {
        return grille[ligne][colonne];
    }

    public boolean estCommencee() {
        return !estMangee(lignes, colonnes);
    }

    public boolean estTerminee() {
        return grille[0][0];
    }

    @Override
    public Grille clone() {
        Grille resultat = new Grille(lignes, colonnes);
        resultat.grille = grille.clone();
        return resultat;
    }

    @Override
    public String toString() {
        String txt = "{ ";
        for(int l = 0; l < lignes; l++ ) {
            for (int c = 0; c < colonnes; c++) {
                if (l == 0 && c == 0)
                    txt += "O ";
                else if (grille[l][c])
                    txt += "_" + " ";
                else
                    txt += "H" + " ";
            }
            if (l != lignes-1)
                txt += "\n";
        }
        return txt + "}\n";
    }
}
