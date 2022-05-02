package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptateurSauver implements ActionListener {
    final ControleurMediateur control;

    AdaptateurSauver(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.sauver();
    }
}
