package App.Vue;

import App.AppRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre d'accueil de l'application. Elle permet l'interaction avec celle-ci.
 * @author Francois,Céline
 */
public class Accueil extends JFrame {

    /**
     * Liste des arguments récupérés au lancement, nécéssaire pour le lancement du serveur spring.
     */
    private String[] args;
    /**
     * Contexte de l'application serveur spring. Celui-ci est nécessaire afin de pouvoir éteindre le serveur.
     */
    private ConfigurableApplicationContext ctx = null;
    /**
     * Texte informant l'utilisateur sur l'état du serveur (activé/éteint).
     */
    private JLabel infos;

    /**
     * Cette méthode crée la fenêtre d'accueil de l'application. Celle-ci dispose :
     * <ul>
     *     <li>D'un bouton permettant de démarrer le serveur.</li>
     *     <li>D'un bouton permettant d'éteindre le serveur.</li>
     *     <li>D'un bouton permettant de quitter l'application.</li>
     * </ul>
     * @param args Arguments fournis par AppRunner et stockés dans l'attribut {@link #args}.
     * @see AppRunner
     */
    public Accueil (String[] args) {

        this.args = args;

        infos = new JLabel("Le serveur est actuellement éteint.");
        JButton buttonON = new JButton("Démarrer");
        buttonON.addActionListener(new BoutonListenerDemarrer());
        JButton buttonOFF = new JButton("Eteindre");
        buttonOFF.addActionListener(new BoutonListenerEteindre());
        JButton buttonL = new JButton("Quitter");
        buttonL.addActionListener(new BoutonListenerQuitter());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3= new JPanel();

        p1.add(infos);
        p2.add(buttonON);
        p2.add(buttonOFF);
        p3.add(buttonL);

        JPanel p_formu = new JPanel();
        p_formu.setLayout(new BoxLayout(p_formu, BoxLayout.PAGE_AXIS));
        p_formu.add(Box.createRigidArea(new Dimension(0,10)));
        p_formu.add(p1);
        p_formu.add(Box.createRigidArea(new Dimension(0,10)));
        p_formu.add(p2);
        p_formu.add(Box.createRigidArea(new Dimension(0,10)));
        p_formu.add(p3);

        this.add(p_formu);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * La classe qui permet de définir l'action à faire quand on clique sur le bouton Démarrer.
     * Pour cela, elle implémente ActionListener qui gère les évènements liés au clique sur un composant.
     * @author François, Céline
     */
    private class BoutonListenerDemarrer implements ActionListener {
        /**
         * Cette méthode découle de l'interface ActionListener et gère l'évenement associé au clique sur le bouton Démarrer.
         * Elle permet de mettre en marche le serveur spring et de conserver son contexte pour une eventuelle extinction de celui-ci.
         * @param arg0 évenement lié au clique sur le bouton implémentant l'ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
            ctx = SpringApplication.run(AppRunner.class, args);
            infos.setText("Le serveur est actuellement en service.");
            pack();
        }
    }

    /**
     * La classe qui permet de définir l'action à faire quand on clique sur le bouton Eteindre.
     * Pour cela, elle implémente ActionListener qui gère les évènements liés au clique sur un composant.
     * @author François, Céline
     */
    private class BoutonListenerEteindre implements ActionListener {
        /**
         * Cette méthode découle de l'interface ActionListener et gère l'évenement associé au clique sur le bouton Eteindre.
         * Elle permet d'éteindre le serveur spring sans fermer pour autant l'application.
         * @param arg0 évenement lié au clique sur le bouton implémentant l'ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
             if (ctx != null) {
                 infos.setText("Le serveur est actuellement éteint.");
                 ctx.close();
                 ctx = null;
                 pack();
             }

        }

    }

    /**
     * La classe qui permet de définir l'action à faire quand on clique sur le bouton Démarrer.
     * Pour cela, elle implémente ActionListener qui gère les évènements liés au clique sur un composant.
     * @author François,Céline
     */
    private class BoutonListenerQuitter implements ActionListener {
        /**
         * Cette méthode découle de l'interface ActionListener et gère l'évenement associé au clique sur le bouton Quitter.
         * Elle permet de fermer l'application java et d'éteindre par la même occasion le serveur spring.
         * @param arg0 évenement lié au clique sur le bouton implémentant l'ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (ctx != null) {
                ctx.close();
                ctx = null;
            }
            System.exit(0);
        }

    }
}
