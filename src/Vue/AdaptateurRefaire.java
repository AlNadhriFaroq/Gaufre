package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurRefaire implements ActionListener {
    final ControleurMediateur control;

    AdaptateurRefaire(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.refaire();
    }
}
