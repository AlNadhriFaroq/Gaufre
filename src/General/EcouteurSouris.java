package General;


import java.awt.event.*;


public class EcouteurSouris extends MouseAdapter {
    GraphiqueGrille grapheGrille;

    public EcouteurSouris(GraphiqueGrille gg) {
        grapheGrille = gg ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / grapheGrille.tailleCase;
        int y = e.getY() / grapheGrille.tailleCase;
        grapheGrille.grille.manger(y, x);
        grapheGrille.repaint();
    }

}