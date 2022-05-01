package General;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Buttons.*;
import Listes.SpinnerColonnes;
import Listes.SpinnerLignes;
import labels.LabelScore;
import labels.LabelTour;


public class InterfaceGraphique  extends JFrame {
	JFrame frame;
	ComponentGrille gg;
    JPanel p;
    LabelTour tour;
    LabelScore score;
    int Lignes =10;
    int Colonnes = 10;

    public InterfaceGraphique() {
    	frame = new JFrame();
    	gg = new ComponentGrille(new Grille(Lignes, Colonnes, true, this));
        p = this.createPanel();
	}
	public int getLignes(){return Lignes;}
    public void setLignes(int i){this.Lignes = i;}

    public int getColonnes(){return Colonnes;}
    public void setColonnes(int i){this.Colonnes = i;}
	public Grille getGrille() {	return gg.getGrille();}
	
	
	public ComponentGrille getGraphiqueGrille() {
		return gg;
	}
    public void setGg(int l, int c){
        System.out.println("On a l="+l+" et c="+ c);
        gg.getGrille().initialiser(l, c, true);
        gg.repaint();
     }

    public boolean JoueurCourant(){return this.getGrille().joueur();}
	
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
        JButton boutonNouvellePartie = new  BoutonNouvellePartie(this);

        boxBoutons.add(boutonSauver);
        boxBoutons.add(boutonCharger);
        boxBoutons.add(boutonAnnuler);
        boxBoutons.add(boutonRefaire);
        boxBoutons.add(boutonNouvellePartie);
        MyPanel.add(boxBoutons, BorderLayout.EAST);


        /* Les Labels */
        tour = new LabelTour(this);
        score = new LabelScore(this);

        MyPanel.add(tour);
        MyPanel.add(score);

        /* Les Spinners */

        SpinnerLignes spinnerL = new SpinnerLignes(this);
        SpinnerColonnes spinnerC = new SpinnerColonnes(this);
        spinnerL.setMaximumSize(spinnerL.getPreferredSize());
        spinnerC.setMaximumSize(spinnerC.getPreferredSize());


        JTextArea TexteCol = new JTextArea("REGLAGE DES COLONNES :");
        TexteCol.setOpaque(false);
        TexteCol.setMaximumSize(TexteCol.getPreferredSize());
        TexteCol.setFont(new Font(Font.SERIF, Font.BOLD,  10));
        JTextArea TexteCLig = new JTextArea("REGLAGE DES LIGNES :");
        TexteCLig.setOpaque(false);
        TexteCLig.setMaximumSize(TexteCLig.getPreferredSize());
        TexteCLig.setFont(new Font(Font.SERIF, Font.BOLD,  10));

        MyPanel.add(TexteCol);
        MyPanel.add(spinnerC);
        MyPanel.add(TexteCLig);
        MyPanel.add(spinnerL);

        return MyPanel;
    }
    void demarrer(){
        frame.setTitle("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        gg.addMouseListener(new EcouteurSouris(gg, this));
        frame.add(gg);
        frame.add(p, BorderLayout.EAST);
        frame.setVisible(true);
    }
}
