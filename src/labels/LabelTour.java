package labels;

import General.InterfaceGraphique;
import General.MetAJour;

public class LabelTour extends MonLabel implements MetAJour{
	public LabelTour(InterfaceGraphique j) {
		super(j);
	}

	@Override
	public void refresh() {
		boolean courant =  this.j.getGraphiqueGrille().getGrille().joueur();
		if(courant) {
			this.setText("Au tour de joueur 1 de jouer");
		} else {
			this.setText("Au tour de joueur 2 de jouer");
		}
		
	}
	

	
}
