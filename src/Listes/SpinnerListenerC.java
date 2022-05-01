package Listes;

import General.ComponentGrille;
import General.Grille;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListenerC implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        SpinnerColonnes sourceC = (SpinnerColonnes) e.getSource();
        int value = (Integer) sourceC.getValue();
        sourceC.jeu.setColonnes(value);
        sourceC.jeu.setGg(sourceC.jeu.getLignes(), sourceC.jeu.getColonnes());
        sourceC.jeu.repaint();
    }
}
