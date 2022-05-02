package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurAnnuler implements ActionListener {
    ControleurMediateur control;

    AdaptateurAnnuler(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.annuler();
    }
}
