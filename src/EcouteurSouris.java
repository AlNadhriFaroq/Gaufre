import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurSouris extends MouseAdapter {
    GraphiqueGrid graphGrid;

    public EcouteurSouris(GraphiqueGrid gg) {
        graphGrid = gg ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX()  /  graphGrid.largeurCase ;
        int y = e.getY()  / graphGrid.hauteurCase;
        graphGrid.grid.manger(y ,x );
        graphGrid.repaint();
    }

}