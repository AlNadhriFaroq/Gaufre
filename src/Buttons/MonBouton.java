package Buttons;


import General.InterfaceGraphique;
import javax.swing.*;


public abstract class MonBouton extends JButton {
	InterfaceGraphique jeu;
	
	MonBouton(InterfaceGraphique j, String texte){
		super(texte);
		this.jeu = j;
		
		this.addActionListener(ActionEvent -> {
			action();
			jeu.getGraphiqueGrille().repaint();
		});
	}
	
	abstract void action();
}
