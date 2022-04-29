import javax.swing.*;
import java.awt.*;

public class GraphiqueGrille extends JComponent {
    Graphics2D dessin;
    int tailleCase;
    Grille grille;

    public GraphiqueGrille(Grille g) {
        grille = g;
    }

    @Override
    public void paintComponent(Graphics g) {
        dessin = (Graphics2D) g;

        int largeurFen = getSize().width;
        int hauteurFen = getSize().height;
        
        if (Math.min(largeurFen, hauteurFen) == largeurFen)
        	tailleCase = largeurFen / grille.colonnes();
        else
        	tailleCase = hauteurFen / grille.lignes();

        dessin.clearRect(0, 0, largeurFen, hauteurFen);

        for (int i = 0; i < grille.lignes(); i++) {
            for (int j = 0; j < grille.colonnes(); j++) {
                if (grille.estMangee(i, j))
                    dessin.setColor(new Color(0xFFFFFF));
                else
                    dessin.setColor(new Color(0xFB8701));
                dessin.fillRect(tailleCase * j, tailleCase * i, tailleCase, tailleCase);
            }
        }

        /* dessine lignes */
        dessin.setColor(new Color(0x000000));
        for (int i = 0; i <= grille.lignes(); i++) {
            int y = i * tailleCase;
            dessin.drawLine(0, y, grille.colonnes() * tailleCase, y);
        }

        for (int j = 0; j <= grille.colonnes(); j++) {
            int x = j * tailleCase;
            dessin.drawLine(x, 0, x, grille.lignes() * tailleCase);
        }
        dessin.setColor(new Color(0xFF27BB6B));
        dessin.fillOval(tailleCase / 4,  tailleCase / 4, tailleCase / 2, tailleCase / 2);
    }



}