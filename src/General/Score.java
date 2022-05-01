package General;

public class Score {
    int ScoreA, ScoreB;
    InterfaceGraphique jeu;

    public Score( InterfaceGraphique jeu){
        ScoreA= 0;
        ScoreB = 0;
        this.jeu = jeu;
    }

    public void ScoreMAJ(){
        if (this.jeu.getGrille().estTerminee()){
            if (this.jeu.getGrille().joueur()){ /* Prends en compte le fait que le joueur est changé avant l'appel à est terminée*/
                this.ScoreA ++;
            }else{
                this.ScoreB ++;
            }
        }

    }

    public int getScoreA(){
        return this.ScoreA;
    }

    public int getScoreB(){
        return this.ScoreB;
    }
}