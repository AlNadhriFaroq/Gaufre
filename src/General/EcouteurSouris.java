package General;


import java.awt.Point;
import java.awt.event.*;


public class EcouteurSouris extends MouseAdapter {
    GraphiqueGrille grapheGrille;

    
    public EcouteurSouris(GraphiqueGrille gg) {
        grapheGrille = gg ;
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / grapheGrille.tailleCase();
        int y = e.getY() / grapheGrille.tailleCase();
        if (!grapheGrille.grille.estMangee(y, x)) {
        	grapheGrille.grille.manger(y, x);
        	grapheGrille.grille.getHistorique().ajouterCoup(new Point(y, x));
        }
        grapheGrille.repaint();
    }

}