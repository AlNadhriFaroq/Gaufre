package Buttons;


import General.Jeu;
import javax.swing.*;


public abstract class MonBouton extends JButton {
	
	Jeu j;
	
	MonBouton(Jeu j, String texte){
		
		super(texte);
		this.j = j;
		
		this.addActionListener(ActionEvent -> {
			action();
			j.getGraphiqueGrille().repaint();
		});
	}
	
	abstract void action();

}
