package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdaptateurSouris extends MouseAdapter {
    final GrilleComponent gComp;
    final ControleurMediateur control;

    public AdaptateurSouris(GrilleComponent gComp, ControleurMediateur control) {
        this.gComp = gComp;
        this.control = control;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int ligne = e.getY() / gComp.tailleCase();
        int colonne = e.getX() / gComp.tailleCase();
        control.clicSouris(ligne, colonne);
    }
}