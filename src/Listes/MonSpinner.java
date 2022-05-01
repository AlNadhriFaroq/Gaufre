package Listes;

import General.InterfaceGraphique;
import General.MetAJour;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class MonSpinner extends JSpinner {

    InterfaceGraphique jeu;

    MonSpinner(InterfaceGraphique j) {
        this.jeu = j;
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setBorder(new EmptyBorder(10, 0, 10, 0));
        //this.setModel();
    }
}
