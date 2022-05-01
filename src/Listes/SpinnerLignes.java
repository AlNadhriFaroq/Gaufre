package Listes;

import General.InterfaceGraphique;
import General.MetAJour;

import javax.swing.*;

public class SpinnerLignes extends MonSpinner{

    public SpinnerLignes(InterfaceGraphique j){
        super(j);
        SpinnerModel lignes = new SpinnerNumberModel(this.jeu.getLignes(), 2, 15, 1);
        this.setModel(lignes);
        this.addChangeListener(new SpinnerListenerL());
    }

}
