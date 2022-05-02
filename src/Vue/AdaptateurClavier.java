package Vue;

import Controleur.ControleurMediateur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdaptateurClavier extends KeyAdapter {
    final ControleurMediateur control;

    AdaptateurClavier(ControleurMediateur control) {
        this.control = control;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_U:
                control.toucheClavier("Annuler");
                break;
            case KeyEvent.VK_R:
                control.toucheClavier("Refaire");
                break;
            case KeyEvent.VK_UP:
                control.toucheClavier("AgrandirLignes");
                break;
            case KeyEvent.VK_DOWN:
                control.toucheClavier("RetrecirLignes");
                break;
            case KeyEvent.VK_RIGHT:
                control.toucheClavier("AgrandirColonnes");
                break;
            case KeyEvent.VK_LEFT:
                control.toucheClavier("RetrecirColonnes");
                break;
            case KeyEvent.VK_I:
                control.toucheClavier("IA");
                break;
            case KeyEvent.VK_ESCAPE:
                control.toucheClavier("PleinEcran");
                break;
            case KeyEvent.VK_N:
                control.toucheClavier("NouvellePartie");
                break;
            case KeyEvent.VK_C:
                control.toucheClavier("Charger");
                break;
            case KeyEvent.VK_S:
                control.toucheClavier("Sauver");
                break;
            case KeyEvent.VK_Q:
            case KeyEvent.VK_A:
                control.toucheClavier("Quitter");
                break;
        }
    }
}
