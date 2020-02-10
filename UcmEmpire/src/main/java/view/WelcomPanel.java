package view;
import models.Player;
import models.boardPackage.Board;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomPanel extends JPanel {


    private JLabel introductionLabel,creditLabel;
    private JPanel centerPanel,animationPanel;
    private LayoutWindow layoutWindow;
    private Container container;
    private JButton startGameButton;
    private ThreadAnimation threadAnimation;



    public WelcomPanel(LayoutWindow layoutWindow){



        this.layoutWindow = layoutWindow;

        container = layoutWindow.getContentPane();

        container.removeAll();


        // region north Panel

        introductionLabel = new JLabel("BIENVENU SUR UCM-EMPIRE");
        this.setLayout(new FlowLayout());

        introductionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(introductionLabel);

        // endregion

        // region Center Panel

        centerPanel = new JPanel();


        animationPanel = new JPanel();

        threadAnimation = new ThreadAnimation(this);
        threadAnimation.start();

        centerPanel.add(animationPanel,BorderLayout.NORTH);

        startGameButton = new JButton("Lancer une nouvelle partie");
        ButtonListener buttonListener = new ButtonListener();
        startGameButton.addActionListener(buttonListener);
        centerPanel.add(startGameButton,BorderLayout.SOUTH);

        // endregion

        // region South Panel

        //TODO : repaint welcom Panel with option menu
        creditLabel = new JLabel("Alex, Bryan, Damien, Florent");
        creditLabel.setHorizontalAlignment(SwingConstants.CENTER);


        // endregion

        // region Conteneur

        container.add(creditLabel,BorderLayout.SOUTH);
        container.add(centerPanel,BorderLayout.CENTER);
        container.add(introductionLabel,BorderLayout.NORTH);

        // endregion

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);



    }

    public JPanel getAnimationPanel() { return animationPanel; }

    private class ButtonListener implements ActionListener {



        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == startGameButton) {

                Player newPlayer = new Player(1);
                Board board = new Board("plateau");

                GamePanel gamePanel = new GamePanel(layoutWindow,newPlayer,board);
            }



        }

    }


}