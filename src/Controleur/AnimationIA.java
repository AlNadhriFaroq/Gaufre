package Controleur;

import java.util.List;
import java.awt.Point;

public class AnimationIA {
    final int lenteur;
    int decompte;
    final IA joueur;
    final ControleurMediateur control;
    List<Point> enAttente;

    public AnimationIA(int lenteur, IA joueur, ControleurMediateur control) {
        this.lenteur = decompte = lenteur;
        this.joueur = joueur;
        this.control = control;
    }

    public void tictac() {
        decompte--;
        if (decompte <= 0) {
            decompte = lenteur;
            miseAJour();
        }
    }

    public void miseAJour() {
        if ((enAttente == null) || enAttente.isEmpty())
            enAttente = joueur.elaborerCoups();
        if ((enAttente == null) || enAttente.isEmpty())
            System.err.println("Bug : l'IA n'a joué aucun coup !");
        else
            control.faire(enAttente.remove(enAttente.size()-1));
    }
}
