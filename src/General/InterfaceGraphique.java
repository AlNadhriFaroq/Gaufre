package General;


import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Buttons.*;
import labels.LabelTour;


public class InterfaceGraphique  extends JFrame {
	JFrame frame;
	ComponentGrille gg;
    JPanel p;
    LabelTour tour;
	
	
	public InterfaceGraphique() {
    	frame = new JFrame();
    	gg = new ComponentGrille(new Grille(10, 10, true));
        p = this.createPanel();
	}
	
	
	public Grille getGrille() {
		return gg.getGrille();
	}
	
	
	public ComponentGrille getGraphiqueGrille() {
		return gg;
	}
	
	
	public Historique getHistorique() {
		return gg.getGrille().getHistorique();
	}

    private JPanel createPanel() {
        JPanel MyPanel = new JPanel();
        MyPanel.setLayout(new BoxLayout(MyPanel, BoxLayout.Y_AXIS));
        MyPanel.setBorder(new EmptyBorder(0, 30, 0 ,30));

        /* Les Boutons */
        Box boxBoutons = Box.createVerticalBox();

        JButton boutonSauver =  new BoutonSauver(this);
        JButton boutonCharger = new BoutonCharger(this);
        JButton boutonAnnuler = new BoutonAnnuler(this);
        JButton boutonRefaire = new BoutonRefaire(this);

        boxBoutons.add(boutonSauver);
        boxBoutons.add(boutonCharger);
        boxBoutons.add(boutonAnnuler);
        boxBoutons.add(boutonRefaire);

        MyPanel.add(boxBoutons, BorderLayout.EAST);


        /* Les Labels */
        tour = new LabelTour(this);

        MyPanel.add(tour);

        return MyPanel;
    }
    void demarrer(){
        frame.setTitle("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        
        gg.addMouseListener(new EcouteurSouris(gg));
        frame.add(gg);
        frame.add(p, BorderLayout.EAST);

        
        frame.setVisible(true);
    }
}
