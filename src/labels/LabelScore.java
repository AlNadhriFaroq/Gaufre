package labels;

import General.InterfaceGraphique;
import General.MetAJour;
import General.Score;

public class LabelScore extends MonLabel implements MetAJour {

    public LabelScore(InterfaceGraphique j){
        super(j);
    }

    @Override
    public void refresh() {
        Score score = this.j.getGraphiqueGrille().getGrille().getScore();
        this.setText("J1: " +score.getScoreA() + " / J2: " +score.getScoreB());

    }
}
