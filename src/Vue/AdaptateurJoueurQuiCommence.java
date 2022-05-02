package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurJoueurQuiCommence implements ActionListener {
    final ControleurMediateur control;

    AdaptateurJoueurQuiCommence(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.joueurQuiCommence();
    }
}
