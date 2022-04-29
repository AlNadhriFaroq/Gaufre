package General;


import javax.swing.*;


public class Jeu  extends JFrame {
	JFrame frame;
	GraphiqueGrille gg;
	
	
	public Jeu(JFrame f, GraphiqueGrille g) {
		frame = f;
		gg = g;
	}
	
	
	public GraphiqueGrille getGraphiqueGrille() {
		   return gg;
	}

	
    void demarrer(){
        frame.setTitle("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        
        gg.addMouseListener(new EcouteurSouris(gg));
        frame.add(gg);
        
        frame.setVisible(true);
    }
}
