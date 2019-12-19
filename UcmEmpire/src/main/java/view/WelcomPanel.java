package view;
import javax.swing.*;

import java.awt.*;



public class WelcomPanel extends JPanel {


    private JLabel introductionLabel;
    private LayoutWindow layoutWindow;
    private Container container;



    public WelcomPanel(LayoutWindow layoutWindow){



        this.layoutWindow = layoutWindow;

        container = layoutWindow.getContentPane();

        container.removeAll();



        introductionLabel = new JLabel("BIENVENU SUR UCM-EMPIRE");


        this.setLayout(new FlowLayout());

        introductionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(introductionLabel);



        container.add(introductionLabel,BorderLayout.NORTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);



    }

}