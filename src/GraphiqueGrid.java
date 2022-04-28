import javax.swing.*;
import java.awt.*;

public class GraphiqueGrid extends JComponent {
    Graphics2D drawable;
    int largeurCase;
    int hauteurCase;
    Grid grid;

    public GraphiqueGrid(Grid g) {
        grid = g;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawable = (Graphics2D) g;

        int width = getSize().width;

        int height = getSize().height;

        largeurCase = width / grid.colonnes();
        hauteurCase = height / grid.lignes();

        drawable.clearRect(0, 0, width, height);

        for (int i = 0; i < grid.lignes(); i++) {
            for (int j = 0; j < grid.colonnes(); j++) {
                if (grid.estMangee(i, j))
                    drawable.setColor(new Color(0xFFFFFF));
                else
                    drawable.setColor(new Color(0xFB8701));
                drawable.fillRect(largeurCase * j, hauteurCase * i, largeurCase, hauteurCase);
            }
        }

        /* dessine lignes */
        drawable.setColor(new Color(0x000000));
        for (int i = 0; i <= grid.lignes(); i++) {
            int y = i * hauteurCase;
            drawable.drawLine(0, y, width - (width % largeurCase), y);
        }

        for (int j = 0; j <= grid.colonnes(); j++) {
            int x = j * largeurCase;
            drawable.drawLine(x, 0, x, height - (height % hauteurCase));
        }
        drawable.setColor(new Color(0xFF27BB6B));
        drawable.fillOval(largeurCase / 4,  hauteurCase / 4, largeurCase / 2, hauteurCase / 2);
    }



}