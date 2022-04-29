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

    void ajouterCoup(Point c) {
        avant.add(c);
        if (!apres.isEmpty())
            apres.clear();
    }

    Point recupererCoupSuivant() {
        Point coup;
        if (!apres.isEmpty()) {
            coup = apres.remove(apres.size() - 1);
            avant.add(coup);
        } else
            coup = null;
        return coup;
    }

    public List<Point> revenirEnArriere() {
        Point coup;
        if (!avant.isEmpty()) {
            coup = avant.remove(avant.size() - 1);
            apres.add(coup);
        }
        return avant;
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
}
