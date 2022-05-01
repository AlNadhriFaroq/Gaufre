package Listes;

import General.InterfaceGraphique;
import General.MetAJour;

import javax.swing.*;

public class SpinnerColonnes  extends MonSpinner {


    public SpinnerColonnes(InterfaceGraphique jeu){
        super(jeu);
        SpinnerModel colonnes = new SpinnerNumberModel(this.jeu.getColonnes(), 2, 15, 1);
        this.setModel(colonnes);
        this.addChangeListener(new SpinnerListenerC());
    }


}
