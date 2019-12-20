package view;
import models.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomPanel extends JPanel {


    private JLabel introductionLabel;
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

        container.add(startGameButton,BorderLayout.SOUTH);



        container.add(introductionLabel,BorderLayout.NORTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);



    }

    private class ButtonListener implements ActionListener {



        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == startGameButton) {

                Player newPlayer = new Player();

                GamePanel gamePanel = new GamePanel(layoutWindow,newPlayer);
            }



        }

    }


}