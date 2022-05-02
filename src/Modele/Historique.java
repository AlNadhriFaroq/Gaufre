package Modele;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.awt.Point;

public class Historique {
    final List<Point> passe;
    final List<Point> futur;

    public Historique() {
        passe = new ArrayList<>();
        futur = new ArrayList<>();
    }

    public void initialiser() {
        passe.clear();
        futur.clear();
    }

    public List<Point> passe() {
        return passe;
    }

    public List<Point> futur() {
        return futur;
    }

    public boolean peutAnnuler() {
        return !passe.isEmpty();
    }

    public boolean peutRefaire() {
        return !futur.isEmpty();
    }

    public void faire(Point coup) {
        passe.add(coup);
        futur.clear();
    }

    public Point annuler() {
        Point coup = passe.remove(passe.size()-1);
        futur.add(coup);
        return coup;
    }

    public Point refaire() {
        Point coup = futur.remove(futur.size()-1);
        passe.add(coup);
        return coup;
    }

    public void lire(Scanner s) {
        passe.clear();
        futur.clear();

        int passeTaille = s.nextInt();
    	int futurTaille = s.nextInt();
    	
    	for (int i = 0; i < passeTaille; i++)
    		passe.add(new Point(s.nextInt(), s.nextInt()));
    	
    	for (int i = 0; i < futurTaille; i++)
    		futur.add(new Point(s.nextInt(), s.nextInt()));
    }

    public void ecrire(PrintStream p) {
    	p.println(passe.size());
    	p.println(futur.size());
    	
    	for (Point coup : passe)
    		p.println(coup.x + " " + coup.y);
    	
    	for (Point coup : futur)
    		p.println(coup.x + " " + coup.y);
    }

    @Override
    public String toString() {
    	String txt = "{[";
    	for (Point coup : passe)
    		txt += "(" + coup.x + ", " + coup.y + ")\n";
        txt += "]\n [";
    	for (Point coup : futur)
            txt += "(" + coup.x + ", " + coup.y + ")\n";
        return txt + "]}\n";
    }
}
