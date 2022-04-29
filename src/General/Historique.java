package General;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Historique {
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
}
