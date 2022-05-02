package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurJoueur2IADifficulte implements ActionListener {
    final ControleurMediateur control;

    AdaptateurJoueur2IADifficulte(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.joueur2IADifficulte();
    }
}
