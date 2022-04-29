package Buttons;


import General.Jeu;
import javax.swing.*;


public abstract class MonBouton extends JButton {
	Jeu jeu;
	
	MonBouton(Jeu j, String texte){
		super(texte);
		this.jeu = j;
		
		this.addActionListener(ActionEvent -> {
			action();
			jeu.getGraphiqueGrille().repaint();
		});
	}
	
	abstract void action();
}
