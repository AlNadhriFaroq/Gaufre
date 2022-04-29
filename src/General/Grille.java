package General;

import java.awt.Point;
import java.util.List;

public class Grille {
    int lignes;
    int colonnes;
    boolean[][] grille;
    boolean joueur;
    Historique histo;


    public Grille(int l, int c, boolean j) {
        initialiser(l, c, j);
        histo = new Historique(j);
    }
    
    
    public int lignes(){
        return lignes;
    }
    
    
    public int colonnes(){
        return colonnes;
    }
    
    
    public boolean joueur() {
    	return joueur;
    }
    
    
    public String joueurTxt() {
    	if (joueur)
    		return "Joueur 1";
    	else
    		return "Joueur 2";
    }
    
    
    public Historique getHistorique() {
    	return histo;
    }
    
    
    public void initialiser(int l, int c, boolean p){
        lignes = l;
        colonnes = c;
        joueur = p;
        grille = new boolean[l][c];
        initialiserFaux();
    }
    
    
    void initialiserFaux() {
        /* initialise toutes les cases a faux, non mangees */
        for(int i = 0; i < lignes; i++ )
            for(int j = 0; j < colonnes; j++ )
                grille[i][j] = false;    	
    }

    
    public void manger(int l , int c) {
        int i = l, j = c;
        
        /* mange le rectangle inferieur */
	    while(i < lignes  && !estMangee(i,j)){
	        grille[i][j] = true;
	        j++;
	        while (j < colonnes && !estMangee(i,j)){
	            grille[i][j] = true;
	            j++;
	        }
	        j = c ;
	        i++;
	    }
	    
	    /* changement du joueur */
	    joueur = !joueur;
	    
	    /* fin de partie */
	    if (estTerminee())
	    	System.out.println(joueurTxt() + " a gagné !");
    }
    
    
    public void annulerManger(List<Point> coups) {
    	initialiserFaux();
    	joueur = histo.joueurInitial();
    	iterManger(coups);
    }
    
    
    public void iterManger(List<Point> coups) {
    	for (Point coup : coups)
    		manger(coup.x, coup.y);
    }
    
    
    boolean estMangee(int l , int c){
        return grille[l][c];
    }

    
    boolean estTerminee(){
        return grille[0][0];
    }
    
    
    void afficher(){
        System.out.println("{ joueur : " + joueur);
        for(int i = 0; i < lignes; i++ ) {
            for (int j = 0; j < colonnes; j++)
                System.out.print(grille[i][j] + " ");
            System.out.println();
        }
        System.out.println("}");
    }    
}