package General;


import java.awt.Point;
import java.awt.event.*;

import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

import IA.IAAleatoire;

import javax.swing.*;


public class EcouteurSouris extends MouseAdapter {
    ComponentGrille grapheGrille;
    InterfaceGraphique jeu;
    Timer timer;
    boolean IAturn;
    
    public EcouteurSouris(ComponentGrille gg, InterfaceGraphique j) {
        grapheGrille = gg ;
        jeu = j;
        IAturn = false;
        timer = new Timer(1000, (e) -> {
                grapheGrille.jouerAI();
                timer.stop();
                IAturn = !IAturn ;
        });
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        if(!IAturn) {
            int x = e.getX() / grapheGrille.tailleCase();
            int y = e.getY() / grapheGrille.tailleCase();
            grapheGrille.jouer(y, x);
            timer.start();
            IAturn = !IAturn ;
        }


    }
}