import Controleur.ControleurMediateur;
import Modele.Jeu;
import Vue.InterfaceGraphique;

public class GaufreEmpoisonnee {
    public static void main(String[] args){
    	Jeu jeu = new Jeu();
        ControleurMediateur control = new ControleurMediateur(jeu);
        InterfaceGraphique.demarrer(jeu, control);
    }
}
