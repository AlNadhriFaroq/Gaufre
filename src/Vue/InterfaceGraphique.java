package Vue;

import Controleur.ControleurMediateur;
import Global.Configuration;
import Modele.Jeu;

import java.awt.*;
import javax.swing.*;

public class InterfaceGraphique implements Runnable {
    final Jeu jeu;
    final ControleurMediateur control;
    GraphicsDevice device;
    JFrame frame;
    GrilleComponent gComp;
    JButton nouvellePartie, charger, sauver, quitter;
    JButton annuler, refaire, initialiserScores;
    JButton joueurQuiCommence;
    JToggleButton joueur1IA, joueur2IA;
    JButton joueur1IADifficulte, joueur2IADifficulte;
    JLabel dimensions, joueurCourant, joueur1Score, joueur2Score;

    InterfaceGraphique(Jeu jeu, ControleurMediateur control) {
        this.jeu = jeu;
        this.control = control;
    }

    public static void demarrer(Jeu jeu, ControleurMediateur control) {
        InterfaceGraphique vue = new InterfaceGraphique(jeu, control);
        control.ajouterInterfaceGraphique(vue);
        SwingUtilities.invokeLater(vue);
    }

    public void run() {
        frame = new JFrame();
        gComp = new GrilleComponent(jeu);

        Box boite = Box.createVerticalBox();
        boite.add(Box.createGlue());

        nouvellePartie = new JButton("Nouvelle partie");
        nouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
        nouvellePartie.setFocusable(false);
        boite.add(nouvellePartie);

        charger = new JButton("Charger une partie");
        charger.setAlignmentX(Component.CENTER_ALIGNMENT);
        charger.setFocusable(false);
        boite.add(charger);

        sauver = new JButton("Sauver la partie");
        sauver.setAlignmentX(Component.CENTER_ALIGNMENT);
        sauver.setFocusable(false);
        boite.add(sauver);

        quitter = new JButton("Quitter");
        quitter.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitter.setFocusable(false);
        boite.add(quitter);

        annuler = new JButton("Annuler");
        annuler.setAlignmentX(Component.CENTER_ALIGNMENT);
        annuler.setFocusable(false);
        boite.add(annuler);

        refaire = new JButton("Refaire");
        refaire.setAlignmentX(Component.CENTER_ALIGNMENT);
        refaire.setFocusable(false);
        boite.add(refaire);

        initialiserScores = new JButton("Réinitialiser les scores");
        initialiserScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        initialiserScores.setFocusable(false);
        boite.add(initialiserScores);

        joueurQuiCommence = new JButton();
        if (Boolean.parseBoolean(Configuration.instance().lire("JoueurQuiCommence")))
            joueurQuiCommence.setText("Le joueur 1 commence");
        else
            joueurQuiCommence.setText("Le joueur 2 commence");
        joueurQuiCommence.setAlignmentX(Component.CENTER_ALIGNMENT);
        joueurQuiCommence.setFocusable(false);
        boite.add(joueurQuiCommence);

        joueur1IA = new JToggleButton("Activer IA joueur 1");
        joueur1IA.setSelected(Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")));
        joueur1IA.setAlignmentX(Component.CENTER_ALIGNMENT);
        joueur1IA.setFocusable(false);
        boite.add(joueur1IA);

        joueur1IADifficulte = new JButton("Difficulte IA 1 : " + difficulteEnTexte(Configuration.instance().lire("Joueur1IADifficulte")));
        joueur1IADifficulte.setAlignmentX(Component.CENTER_ALIGNMENT);
        joueur1IADifficulte.setFocusable(false);
        boite.add(joueur1IADifficulte);

        joueur2IA = new JToggleButton("Activer IA joueur 2");
        joueur2IA.setSelected(Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")));
        joueur2IA.setAlignmentX(Component.CENTER_ALIGNMENT);
        joueur2IA.setFocusable(false);
        boite.add(joueur2IA);

        joueur2IADifficulte = new JButton("Difficulte IA 2 : " + difficulteEnTexte(Configuration.instance().lire("Joueur2IADifficulte")));
        joueur2IADifficulte.setAlignmentX(Component.CENTER_ALIGNMENT);
        joueur2IADifficulte.setFocusable(false);
        boite.add(joueur2IADifficulte);

        dimensions = new JLabel("Grille " + Configuration.instance().lire("NbLignes") + "x" + Configuration.instance().lire("NbColonnes"));
        dimensions.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(dimensions);

        joueur1Score = new JLabel("Score joueur 1 : " + Configuration.instance().lire("Joueur1Score"));
        joueur1Score.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(joueur1Score);

        joueur2Score = new JLabel("Score joueur 2 : " + Configuration.instance().lire("Joueur2Score"));
        joueur2Score.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(joueur2Score);

        joueurCourant = new JLabel();
        if (jeu.joueur())
            joueurCourant.setText("Au joueur 1 de jouer !");
        else
            joueurCourant.setText("Au joueur 2 de jouer !");
        joueurCourant.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(joueurCourant);

        boite.add(Box.createGlue());

        frame.addKeyListener(new AdaptateurClavier(control));
        gComp.addMouseListener(new AdaptateurSouris(gComp, control));
        nouvellePartie.addActionListener(new AdaptateurNouvellePartie(control));
        charger.addActionListener(new AdaptateurCharger(control));
        sauver.addActionListener(new AdaptateurSauver(control));
        quitter.addActionListener(new AdaptateurQuitter(control));
        annuler.addActionListener(new AdaptateurAnnuler(control));
        refaire.addActionListener(new AdaptateurRefaire(control));
        initialiserScores.addActionListener(new AdaptateurScores(control));
        joueurQuiCommence.addActionListener(new AdaptateurJoueurQuiCommence(control));
        joueur1IA.addActionListener(new AdaptateurJoueur1IA(control));
        joueur1IADifficulte.addActionListener(new AdaptateurJoueur1IADifficulte(control));
        joueur2IA.addActionListener(new AdaptateurJoueur2IA(control));
        joueur2IADifficulte.addActionListener(new AdaptateurJoueur2IADifficulte(control));


        frame.add(gComp);
        frame.add(boite, BorderLayout.EAST);

        int largeur = Integer.parseInt(Configuration.instance().lire("FenetreLargeur"));
        int hauteur = Integer.parseInt(Configuration.instance().lire("FenetreHauteur"));
        frame.setTitle("Gaufre empoisonnée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(largeur, hauteur);
        frame.setResizable(true);
        mettrePleinEcran();
        frame.setVisible(true);

        control.nouvellePartie();
    }

    public void mettrePleinEcran() {
        if (device == null)
            device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            frame.dispose();
            if (Boolean.parseBoolean(Configuration.instance().lire("PleinEcran"))) {
                frame.setUndecorated(true);
                frame.setVisible(true);
                device.setFullScreenWindow(frame);
            } else {
                frame.setUndecorated(false);
                frame.setVisible(true);
                device.setFullScreenWindow(null);
            }
        }
    }

    public void mettreAJourJoueurCourant() {
        if (jeu.joueur())
            joueurCourant.setText("Au joueur 1 de jouer !");
        else
            joueurCourant.setText("Au joueur 2 de jouer !");
    }

    public void mettreAJourJoueurQuiCommence() {
        if (Boolean.parseBoolean(Configuration.instance().lire("JoueurQuiCommence")))
            joueurQuiCommence.setText("Le joueur 1 commence");
        else
            joueurQuiCommence.setText("Le joueur 2 commence");
    }

    public void mettreAJourScores() {
        joueur1Score.setText("Score joueur 1 : " + Configuration.instance().lire("Joueur1Score"));
        joueur2Score.setText("Score joueur 2 : " + Configuration.instance().lire("Joueur2Score"));
    }

    public void mettreAJourIA() {
        joueur1IADifficulte.setText("Difficulte IA 1 : " + difficulteEnTexte(Configuration.instance().lire("Joueur1IADifficulte")));
        joueur2IADifficulte.setText("Difficulte IA 2 : " + difficulteEnTexte(Configuration.instance().lire("Joueur2IADifficulte")));

        joueur1IA.setSelected(Boolean.parseBoolean(Configuration.instance().lire("Joueur1IA")));
        joueur2IA.setSelected(Boolean.parseBoolean(Configuration.instance().lire("Joueur2IA")));
    }

    public void mettreAJourGrille() {
        dimensions.setText("Grille " + Configuration.instance().lire("NbLignes") + "x" + Configuration.instance().lire("NbColonnes"));
        gComp.repaint();
        mettreAJourJoueurCourant();
    }

    public void mettreAJour() {
        mettreAJourGrille();
        mettreAJourJoueurQuiCommence();
        mettreAJourScores();
        mettreAJourIA();
    }

    String difficulteEnTexte(String dif) {
        return switch (dif) {
            case "0" -> "facile";
            case "1" -> "moyenne";
            case "2" -> "difficile";
            default -> "erreur";
        };
    }
}
