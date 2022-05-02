package General;


import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class Historique implements Serializable {
    List<Point> avant;
    List<Point> apres;
    boolean joueurInitial;


    public Historique(boolean j) {
        avant = new ArrayList<>();
        apres = new ArrayList<>();
        joueurInitial = j ;
    }
    
    
    public List<Point> historiqueApres(){
        return apres;
    }
    

    public List<Point> historiqueAvant(){
        return avant;
    }

    
    public boolean joueurInitial(){
        return joueurInitial;
    }

    
    public void ajouterCoup(Point c) {
        avant.add(c);
        if (!apres.isEmpty())
            apres.clear();
    }

    
    public Point recupererCoupSuivant() {
        Point coup = null;
        if (!apres.isEmpty()) {
            coup = apres.remove(apres.size() - 1);
            avant.add(coup);
        }
        return coup;
    }

    
    public List<Point> revenirEnArriere() {
        if (!avant.isEmpty())
            apres.add(avant.remove(avant.size()-1));
        return avant;
    }
    
    
    public Point lire(InputStream in) {
    	Scanner s = new Scanner(in);
    	
    	Point dimGrille = new Point(s.nextInt(), s.nextInt());
    	
    	joueurInitial = s.nextBoolean();
    	
    	int avantSize = s.nextInt();
    	int apresSize = s.nextInt();
    	
    	avant.clear();
    	apres.clear();
    	
    	for (int i = 0; i < avantSize; i++)
    		avant.add(new Point(s.nextInt(), s.nextInt()));
    	
    	for (int i = 0; i < apresSize; i++)
    		apres.add(new Point(s.nextInt(), s.nextInt()));
    	
    	s.close();
    	return dimGrille;
    }
    
    
    public void ecrire(OutputStream out, Point dimGrille) {
    	PrintStream p = new PrintStream(out);

		p.println(dimGrille.x + " " + dimGrille.y);
    	
    	p.println(joueurInitial);
    	
    	p.println(avant.size());
    	p.println(apres.size());
    	
    	for (Point coup : avant)
    		p.println(coup.x + " " + coup.y);
    	
    	for (Point coup : apres)
    		p.println(coup.x + " " + coup.y);
    }
    
    
    public void afficher() {
    	System.out.println(joueurInitial);
        System.out.println("pile des coups faits");
    	for (Point coup : avant)
    		System.out.println(coup.toString());
        System.out.println("pile des coups annules");
    	for (Point coup : apres)
    		System.out.println(coup.toString());
    }

    public void reiniHisto(){
        avant.clear();
        apres.clear();
    }
}
