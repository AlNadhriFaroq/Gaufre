package General;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Grille {
    int lignes;
    int colonnes;
    boolean[][] grille;
    boolean joueur;
    Historique histo;
    InterfaceGraphique parentg;
    Score score;


    public Grille(int l, int c, boolean j, InterfaceGraphique ifj) {
        parentg = ifj;
        initialiser(l, c, j);
        histo = new Historique(j);
        score = new Score(parentg);
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

    public Score getScore(){return score;}
    
    
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
        parentg.tour.refresh();
        parentg.p.updateUI();

	    /* fin de partie */
	    if (estTerminee()) {
            score.ScoreMAJ();
            parentg.score.refresh();
            System.out.println(joueurTxt() + " a gagné !");
            nouvellepartie();

	    }
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
    
    
    public boolean estMangee(int l , int c){
        return grille[l][c];
    }

    
    public boolean estTerminee(){
        return grille[0][0];
    }
    
    
    public void afficher(){
        System.out.println("{ joueur : " + joueur);
        for(int i = 0; i < lignes; i++ ) {
            for (int j = 0; j < colonnes; j++)
                System.out.print(grille[i][j] + " ");
            System.out.println();
        }
        System.out.println("}");
    }    
    public void save( String fileName ){
        try {
            FileOutputStream fsave = new FileOutputStream(fileName);
            ObjectOutputStream out =  new ObjectOutputStream(fsave);
            int un =  0, deux = 0 ;
            while(un < lignes) {
                while (deux < colonnes ){
                    out.writeBoolean(grille[un][deux]);
                    deux ++ ;
                }
                deux = 0  ;
                un++;
            }
            out.writeInt(lignes);
            out.writeInt(colonnes);
            out.writeBoolean(joueur);
            out.writeObject(histo) ;
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load (String fileName ) {
        try{
            FileInputStream fload = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fload);
            int un =  0, deux = 0 ;
            while(un < lignes) {
                while (deux < colonnes ){
                    this.grille[un][deux] = in.readBoolean();
                    deux ++ ;
                }
                deux = 0 ;
                un++;
            }
            this.lignes = in.readInt();
            this.colonnes =   in.readInt();
            this.joueur =  in.readBoolean();
            this.histo = (Historique) in.readObject();
            in.close();
        }catch (IOException| ClassCastException b ){
            System.out.println("Error:");
            b.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void nouvellepartie (){
        int m = 0 , n = 0 ;

        while(m < this.lignes ){
            while (n<this.colonnes){
                grille[n][m]= false ;
             n++;
            }
            n=0;
            m++ ;
        }
    }
    
    
}