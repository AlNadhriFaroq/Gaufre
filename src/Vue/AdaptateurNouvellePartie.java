package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurNouvellePartie implements ActionListener {
    final ControleurMediateur control;

    AdaptateurNouvellePartie(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.nouvellePartie();
    }
}
