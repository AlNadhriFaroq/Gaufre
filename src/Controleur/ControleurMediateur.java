package Controleur;

import Global.Configuration;
import Modele.Jeu;
import Vue.InterfaceGraphique;

import java.io.*;
import java.awt.Point;

public class ControleurMediateur {
    final Jeu jeu;
    InterfaceGraphique vue;
    AnimationIA joueur1IA, joueur2IA;
    final String dossierSauvegardes;

    public ControleurMediateur(Jeu jeu) {
        this.jeu = jeu;
        dossierSauvegardes = System.getProperty("user.home") + File.separator + ".GaufreEmpoisonnee" + File.separator + "sauvegardes";
        File dossier = new File(dossierSauvegardes);
        dossier.mkdirs();
    }

    public void ajouterInterfaceGraphique(InterfaceGraphique vue) {
        this.vue = vue;
    }

    public void toucheClavier(String touche) {
        switch (touche) {
            case "Annuler":
                annuler();
                break;
            case "Refaire":
                refaire();
                break;
            case "InitialiserScores":
                initialiserScores();
                break;
            case "Joueur1IA":
                joueur1IA();
                break;
            case "Joueur1IADifficulte":
                joueur1IADifficulte();
                break;
            case "Joueur2IA":
                joueur2IA();
                break;
            case "Joueur2IADifficulte":
                joueur2IADifficulte();
                break;
            case "AgrandirLignes":
                agrandirLignes();
                break;
            case "RetrecirLignes":
                retrecirLignes();
                break;
            case "AgrandirColonnes":
                agrandirColonnes();
                break;
            case "RetrecirColonnes":
                retrecirColonnes();
                break;
            case "PleinEcran":
                pleinEcran();
                break;
            case "NouvellePartie":
                nouvellePartie();
                break;
            case "Charger":
                charger();
                break;
            case "Sauver":
                sauver();
                break;
            case "Quitter":
                quitter();
                break;
            default:
                System.out.println("Touche inconnue : " + touche);
        }
    }

    public void clicSouris(int ligne, int colonne) {
        Point coup = jeu.creerCoup(ligne, colonne);
        if (coup != null)
            faire(coup);
    }

    public void faire(Point coup) {
        jeu.faire(coup);
        vue.mettreAJourGrille();
        if (jeu.grilleTerminee()) {
            int score;
            if (jeu.joueur()) {
                score = Integer.parseInt(Configuration.instance().lire("Joueur1Score")) + 1;
                Configuration.instance().ecrire("Joueur1Score", ""+score);
            } else {
                score = Integer.parseInt(Configuration.instance().lire("Joueur2Score")) + 1;
                Configuration.instance().ecrire("Joueur2Score", ""+score);
            }
            vue.mettreAJourScores();
            nouvellePartie();
        } else {
            if (jeu.joueur())
                if (Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")))
                    joueur1IA.miseAJour();
            else
                if (Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")))
                    joueur2IA.miseAJour();
        }
    }

    public void annuler() {
        if (jeu.peutAnnuler()) {
            jeu.annuler();
            vue.mettreAJourGrille();
        }
    }

    public void refaire() {
        if (jeu.peutRefaire()) {
            jeu.refaire();
            vue.mettreAJourGrille();
        }
    }

    public void initialiserScores() {
        Configuration.instance().ecrire("Joueur1Score", "0");
        Configuration.instance().ecrire("Joueur2Score", "0");
        vue.mettreAJourScores();
    }

    public void joueurQuiCommence() {
        Configuration.instance().ecrire("JoueurQuiCommence", ""+!Boolean.parseBoolean(Configuration.instance().lire("JoueurQuiCommence")));
        nouvellePartie();
    }

    public void joueur1IA() {
        if (Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")))
            Configuration.instance().ecrire("Joueur1IA", "false");
        else
            Configuration.instance().ecrire("Joueur1IA", "true");
        nouvellePartie();
    }

    public void joueur1IADifficulte() {
        int val = (Integer.parseInt(Configuration.instance().lire("Joueur1IADifficulte")) + 1) % 3;
        Configuration.instance().ecrire("Joueur1IADifficulte", ""+val);
        vue.mettreAJourIA();
        nouvellePartie();
    }

    public void joueur2IA() {
        if (Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")))
            Configuration.instance().ecrire("Joueur2IA", "false");
        else
            Configuration.instance().ecrire("Joueur2IA", "true");
        nouvellePartie();
    }

    public void joueur2IADifficulte() {
        int val = (Integer.parseInt(Configuration.instance().lire("Joueur2IADifficulte")) + 1) % 3;
        Configuration.instance().ecrire("Joueur2IADifficulte", ""+val);
        nouvellePartie();
    }

    public void agrandirLignes() {
        int lignes = Integer.parseInt(Configuration.instance().lire("NbLignes")) ;
        if(lignes < 100)
            lignes++;
        Configuration.instance().ecrire("NbLignes", ""+lignes);
        jeu.nouvellePartie();
        vue.mettreAJourGrille();
    }

    public void retrecirLignes() {
        int lignes = Integer.parseInt(Configuration.instance().lire("NbLignes"));
        if(lignes > 2)
            lignes--;
        Configuration.instance().ecrire("NbLignes", ""+lignes);
        jeu.nouvellePartie();
        vue.mettreAJourGrille();
    }

    public void agrandirColonnes() {
        int colonnes = Integer.parseInt(Configuration.instance().lire("NbColonnes"));
        if(colonnes < 100)
            colonnes++;
        Configuration.instance().ecrire("NbColonnes", ""+colonnes);
        jeu.nouvellePartie();
        vue.mettreAJourGrille();
    }

    public void retrecirColonnes() {
        int colonnes = Integer.parseInt(Configuration.instance().lire("NbColonnes"));
        if(colonnes > 2)
            colonnes--;
        Configuration.instance().ecrire("NbColonnes", ""+colonnes);
        jeu.nouvellePartie();
        vue.mettreAJourGrille();
    }

    public void pleinEcran() {
        if (Boolean.parseBoolean(Configuration.instance().lire("PleinEcran")))
            Configuration.instance().ecrire("PleinEcran", "false");
        else
            Configuration.instance().ecrire("PleinEcran", "true");
        vue.mettrePleinEcran();
    }

    public void nouvellePartie() {
        jeu.nouvellePartie();
        vue.mettreAJour();

        if (Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")))
            joueur1IA = new AnimationIA(10, IA.nouvelle(jeu, true), this);
        if (Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")))
            joueur2IA = new AnimationIA(10, IA.nouvelle(jeu, false), this);

        if (jeu.joueur())
            if (Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")))
                joueur1IA.miseAJour();
        else
            if (Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")))
                joueur2IA.miseAJour();
    }

    public void charger() {
        try {
            String nom = dossierSauvegardes + File.separator + "sauvegarde.txt";
            InputStream in = new FileInputStream(nom);
            jeu.lire(in);
            vue.mettreAJourGrille();
        } catch (FileNotFoundException e) {
            System.err.println("Impossible de charger la sauvegarde !");
            System.err.println(e);
        }
    }

    public void sauver() {
        try {
            String nom = dossierSauvegardes + File.separator + "sauvegarde.txt";
            File file = new File(nom);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            jeu.ecrire(out);
        } catch (FileNotFoundException e) {
            System.err.println("Impossible de sauvegarder la partie !");
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void quitter() {
        System.exit(0);
    }
}
