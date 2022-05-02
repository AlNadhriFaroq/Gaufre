package Vue;

import Controleur.ControleurMediateur;
import Global.Configuration;
import Modele.Jeu;

import java.awt.*;
import javax.swing.*;

public class InterfaceGraphique implements Runnable {
    Jeu jeu;
    ControleurMediateur control;
    GraphicsDevice device;
    JFrame frame;
    GrilleComponent gComp;
    JButton nouvellePartie, charger, sauver, annuler, refaire, scores;
    JLabel dimensions, joueur, score1, score2;

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

        annuler = new JButton("Annuler");
        annuler.setAlignmentX(Component.CENTER_ALIGNMENT);
        annuler.setFocusable(false);
        boite.add(annuler);

        refaire = new JButton("Refaire");
        refaire.setAlignmentX(Component.CENTER_ALIGNMENT);
        refaire.setFocusable(false);
        boite.add(refaire);

        scores = new JButton("Réinitialiser les scores");
        scores.setAlignmentX(Component.CENTER_ALIGNMENT);
        scores.setFocusable(false);
        boite.add(scores);

        dimensions = new JLabel("Grille " + Configuration.instance().lire("NbLignes") + "x" + Configuration.instance().lire("NbColonnes"));
        dimensions.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(dimensions);

        score1 = new JLabel("Score joueur 1 : " + Configuration.instance().lire("Joueur1Score"));
        score1.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(score1);

        score2 = new JLabel("Score joueur 2 : " + Configuration.instance().lire("Joueur2Score"));
        score2.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(score2);

        joueur = new JLabel();
        if (jeu.joueur())
            joueur.setText("Au joueur 1 de jouer !");
        else
            joueur.setText("Au joueur 2 de jouer !");
        joueur.setAlignmentX(Component.CENTER_ALIGNMENT);
        boite.add(joueur);

        boite.add(Box.createGlue());

        frame.addKeyListener(new AdaptateurClavier(control));
        gComp.addMouseListener(new AdaptateurSouris(gComp, control));
        nouvellePartie.addActionListener(new AdaptateurNouvellePartie(control));
        charger.addActionListener(new AdaptateurCharger(control));
        sauver.addActionListener(new AdaptateurSauver(control));
        annuler.addActionListener(new AdaptateurAnnuler(control));
        refaire.addActionListener(new AdaptateurRefaire(control));
        scores.addActionListener(new AdaptateurScores(control));

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

    public void mettreAJourJoueur() {
        if (jeu.joueur())
            joueur.setText("Au joueur 1 de jouer !");
        else
            joueur.setText("Au joueur 2 de jouer !");
    }

    public void mettreAJourScores() {
        score1.setText("Score joueur 1 : " + Configuration.instance().lire("Joueur1Score"));
        score2.setText("Score joueur 2 : " + Configuration.instance().lire("Joueur2Score"));
    }

    public void mettreAJourGrille() {
        dimensions.setText("Grille " + Configuration.instance().lire("NbLignes") + "x" + Configuration.instance().lire("NbColonnes"));
        gComp.repaint();
        mettreAJourJoueur();
    }
}
