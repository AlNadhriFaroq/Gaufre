public class Grid {
    int lignes;
    int colonnes;
    boolean[][] grid;


    public Grid(int l, int c) {
        init(l, c);
    }

    void init(int l, int c){
        lignes = l;
        colonnes = c;
        grid = new boolean[l][c];
        for(int i = 0; i < lignes; i++ ){
            for(int j = 0; j < colonnes; j++ ){
                grid[i][j] = false;
            }
        }
    }

    void redimensionner(int l, int c){
        if(!grid[lignes - 1][colonnes - 1 ])
            init(l,c);
        else
            System.err.println("Redimensionnement impossible en cours de partie!!");
    }
    void manger(int l , int c) {
        int i = l, j = c;

        while( i < lignes  && !estMangee(i,j)){
            grid[i][j] = true;
            j++;
            while ( j < colonnes && !estMangee(i,j) ){
                grid[i][j] = true;
                j++;
            }
            j = c ;
            i++;
        }
        //afficher();
    }
    boolean estMangee(int l , int c){
        return grid[l][c];
    }

    void afficher(){
        System.out.println("{");
        for(int i = 0; i < lignes; i++ ) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("}");
    }
    int lignes(){
        return lignes;
    }
    int colonnes(){
        return colonnes;
    }
    boolean estTerminee(){
        return grid[0][0];
    }

}