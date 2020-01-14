package view;

import models.Entity;
import models.Player;
import models.boardPackage.Board;
import models.units.Farmer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class LayoutWindow extends JFrame {



    private Container myContainer;
    private JMenu menuMenu,menuWorking,menuSearch;
    private JMenuBar menuBar;
    private JMenuItem homePage, game,exit;
    private WelcomPanel welcomePanel;
    private GamePanel gamePanel;
    private Player player;


    public LayoutWindow(){



        super("UCMPIRE");



        addWindowListener(new WindowAdapter()

        {

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });



        // Region MenuBare



        menuBar = new JMenuBar();

        setJMenuBar(menuBar);



        BarListener barListener = new BarListener();



        menuMenu = new JMenu("Menu");

        menuBar.add(menuMenu);

        homePage = new JMenuItem("Accueil");

        homePage.addActionListener(barListener);

        menuMenu.add(homePage);

        game = new JMenuItem("Game");

        game.addActionListener(barListener);

        menuMenu.add(game);


        menuMenu.addSeparator();

        exit = new JMenuItem("Fermer");

        exit.addActionListener(barListener);

        menuMenu.add(exit);

        //endregion
        // Region Dimension et panneaux



        this.setBounds(100,100,900,600);





        myContainer = this.getContentPane();





        welcomePanel = new WelcomPanel(LayoutWindow.this);


        this.setVisible(true);

    } //endregion

        //Region listener

    private class BarListener implements ActionListener{



        public void actionPerformed(ActionEvent e) {

                if (e.getSource() == homePage)

                    welcomePanel = new WelcomPanel(LayoutWindow.this);

                if (e.getSource() == game)

                    player = new Player(); //TODO : Link with the game class in controller
                    Entity firstpaysan = new Farmer(100,"Premier paysan",100);
                    player.addEntity(firstpaysan);
                    //TODO : need to harmonise the start game between the welcomPanel and this
                    Board board = new Board("new board");

                    gamePanel = new GamePanel(LayoutWindow.this,player,board);

                if (e.getSource() == exit)

                    System.exit(0);

        }

    } //endregion







}