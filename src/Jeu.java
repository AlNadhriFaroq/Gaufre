import javax.swing.*;

public class Jeu  extends JFrame {
    void demarrer(){
        JFrame frame = new JFrame("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        GraphiqueGrille g = new GraphiqueGrille(new Grille(11,10, true));
        g.addMouseListener(new EcouteurSouris(g));
        frame.add(g);
        
        frame.setVisible(true);
    }
}
