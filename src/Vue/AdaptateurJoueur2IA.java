package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurJoueur2IA implements ActionListener {
    final ControleurMediateur control;

    AdaptateurJoueur2IA(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.joueur2IA();
    }
}
