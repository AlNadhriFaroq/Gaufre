package labels;

import General.InterfaceGraphique;
import General.MetAJour;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public abstract class MonLabel extends JLabel implements MetAJour {
	InterfaceGraphique j;
	
	MonLabel(InterfaceGraphique j){
		this.j = j;
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBorder(new EmptyBorder(10, 0, 10, 0));
		this.refresh();
		
	}

}
