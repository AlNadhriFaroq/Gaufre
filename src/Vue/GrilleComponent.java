package Vue;

import Modele.Grille;
import Modele.Jeu;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GrilleComponent extends JComponent {
    Graphics2D dessin;
    Grille grille;
    int tailleCase;

    public GrilleComponent(Jeu jeu) {
        grille = jeu.grille();
    }

    public int tailleCase() {
    	return tailleCase;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        dessin = (Graphics2D) graphics;
        dessin.clearRect(0, 0, getWidth(), getHeight());

        /* calcul de la taille des cases */
        if (Math.min(getWidth(), getHeight()) == getWidth())
        	tailleCase = getWidth() / grille.colonnes();
        else
        	tailleCase = getHeight() / grille.lignes();

        /* affichage de la gaufre */
        for (int l = 0; l < grille.lignes(); l++) {
            for (int c = 0; c < grille.colonnes(); c++) {
                if (grille.estMangee(l, c))
                    dessin.setColor(new Color(0xFFFFFF));
                else
                    dessin.setColor(new Color(0xFB8701));
                dessin.fillRect(tailleCase * c, tailleCase * l, tailleCase, tailleCase);
            }
        }

        /* affichage du quadrillage */
        dessin.setColor(new Color(0x000000));
        for (int l = 0; l <= grille.lignes(); l++) {
            int y = l * tailleCase;
            dessin.drawLine(0, y, grille.colonnes() * tailleCase, y);
        }
        for (int c = 0; c <= grille.colonnes(); c++) {
            int x = c * tailleCase;
            dessin.drawLine(x, 0, x, grille.lignes() * tailleCase);
        }

        /* affichage du poison */
        dessin.setColor(new Color(0xFF27BB6B));
        dessin.fillOval(tailleCase / 4,  tailleCase / 4, tailleCase / 2, tailleCase / 2);
    }
}