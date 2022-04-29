public class Grille {
    int lignes;
    int colonnes;
    boolean[][] grille;
    boolean joueur;


    public Grille(int l, int c, boolean j) {
        initialiser(l, c, j);
    }
    
    
    int lignes(){
        return lignes;
    }
    
    
    int colonnes(){
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
    
    
    void redimensionner(int l, int c, boolean j){
        if(!grille[lignes - 1][colonnes - 1 ])
            initialiser(l,c, j);
        else
            System.err.println("Redimensionnement impossible en cours de partie !");
    }
    
    
    void initialiser(int l, int c, boolean p){
        lignes = l;
        colonnes = c;
        joueur = p;
        grille = new boolean[l][c];
        for(int i = 0; i < lignes; i++ )
            for(int j = 0; j < colonnes; j++ )
                grille[i][j] = false;
    }

    
    void manger(int l , int c) {
        int i = l, j = c;
        
        if (!estMangee(i, j)) {
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
	        joueur = !joueur;
	        if (estTerminee())
	        	System.out.println(joueurTxt() + " a gagné !");
        }
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
            for (int j = 0; j < colonnes; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("}");
    }    
}