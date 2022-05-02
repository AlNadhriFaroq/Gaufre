package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurJoueur1IA implements ActionListener {
    final ControleurMediateur control;

    AdaptateurJoueur1IA(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.joueur1IA();
    }
}
