package Listes;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListenerL implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        SpinnerLignes sourceL = (SpinnerLignes) e.getSource();
        int value = (Integer) sourceL.getValue();
        sourceL.jeu.setLignes(value);
        sourceL.jeu.setGg(sourceL.jeu.getLignes(), sourceL.jeu.getColonnes());
        sourceL.jeu.repaint();

    }
}
