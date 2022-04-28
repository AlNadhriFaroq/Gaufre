import javax.swing.*;

public class Jeu  extends JFrame {
    void demarrer(){
        JFrame frame = new JFrame("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        GraphiqueGrid g = new GraphiqueGrid(new Grid(10,10));
        g.addMouseListener(new EcouteurSouris(g));
        frame.add(g);
        frame.setVisible(true);
    }
}
