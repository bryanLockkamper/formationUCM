package view;
import models.Player;
import models.boardPackage.Board;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomPanel extends JPanel {


    private JLabel introductionLabel,creditLabel;
    private JPanel buttonPanel;
    private LayoutWindow layoutWindow;
    private Container container;
    private JButton startGameButton;



    public WelcomPanel(LayoutWindow layoutWindow){



        this.layoutWindow = layoutWindow;

        container = layoutWindow.getContentPane();

        container.removeAll();



        introductionLabel = new JLabel("BIENVENU SUR UCM-EMPIRE");
        this.setLayout(new FlowLayout());

        introductionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(introductionLabel);

        startGameButton = new JButton("Lancer une nouvelle partie");
        ButtonListener buttonListener = new ButtonListener();
        startGameButton.addActionListener(buttonListener);
        buttonPanel = new JPanel();
        buttonPanel.add(startGameButton,BorderLayout.SOUTH); // NOK

        //TODO : repaint welcom Panel with option menu
        creditLabel = new JLabel("Alex, Bryan, Damien, Florent");
        creditLabel.setHorizontalAlignment(SwingConstants.CENTER);



        container.add(creditLabel,BorderLayout.SOUTH);
        container.add(buttonPanel,BorderLayout.CENTER);
        container.add(introductionLabel,BorderLayout.NORTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);



    }

    private class ButtonListener implements ActionListener {



        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == startGameButton) {

                Player newPlayer = new Player();
                Board board = new Board("plateau");

                GamePanel gamePanel = new GamePanel(layoutWindow,newPlayer,board);
            }



        }

    }


}