package General;


import java.awt.Point;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;

import IA.IAAleatoire;


public class EcouteurSouris extends MouseAdapter {
    ComponentGrille grapheGrille;
    
    public EcouteurSouris(ComponentGrille gg) {
        grapheGrille = gg ;
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
    	try {
	        int x = e.getX() / grapheGrille.tailleCase();
	        int y = e.getY() / grapheGrille.tailleCase();
	        if (!grapheGrille.grille.estMangee(y, x)) {
	        	grapheGrille.grille.manger(y, x);
	        	grapheGrille.grille.getHistorique().ajouterCoup(new Point(y, x));
	        }
	        grapheGrille.repaint();
	        
	        TimeUnit.SECONDS.sleep(1);
	        IAAleatoire IA = new IAAleatoire(grapheGrille.getGrille());
	        Point p = IA.joueIAAleatoire();
	    	grapheGrille.grille.manger(p.x, p.y);
	    	grapheGrille.grille.getHistorique().ajouterCoup(p); 
	    	grapheGrille.repaint();
    	} catch (Exception exc) {
    		System.err.println(exc);
    	}
    }
}