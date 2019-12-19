package view;

import models.Constants;
import models.Entity;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private Container container;
    private JButton cancel,next,confirm;
    private JLabel actionLabel, myEntitiesLabel,newEntitiesLabel,squareXLabel,squareYLabel ;
    private JComboBox actionCombo, myEntitiesCombo,newEntitiesCombo,squareXCombo,squareYCombo;
    private JPanel buttonPanel, boardPanel , actionPanel,titlePanel;
    private LayoutWindow layoutWindow;
    private Player player;


    public GamePanel(LayoutWindow layoutWindow,Player player)
    {
        this.layoutWindow = layoutWindow;
        container = layoutWindow.getContentPane();
        container.removeAll();

        //Region button

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        cancel = new JButton("Annuler");
        next = new JButton("Suivant");

        ButtonListener listener = new ButtonListener();
        cancel.addActionListener(listener);
        next.addActionListener(listener);



        buttonPanel.setLayout(new GridLayout(1,3,100,100));
        buttonPanel.add(cancel);
        buttonPanel.add(next);


        //endregion


        // Region Action

        actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(6,2));

        actionLabel = new JLabel("Action");
        actionLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(actionLabel);

        actionCombo = new JComboBox();
        String action1 = "Deplacer";
        String action2 = "Ajouter entity";
        String action3 = "Suicide";
        actionCombo.addItem(action1);
        actionCombo.addItem(action2);
        actionCombo.addItem(action3);

        ComboListener listenerCombo = new ComboListener();

        actionCombo.addItemListener(listenerCombo);
        actionPanel.add(actionCombo);


        //endregion

        //Region select my entity

        myEntitiesLabel = new JLabel("Selection mes entités");
        myEntitiesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(myEntitiesLabel);

        myEntitiesCombo = new JComboBox(); //TODO : add listener to illuminate the entity select

        List<Entity> list = player.getEntities();
        for (Entity entity: list) {

            myEntitiesCombo.addItem(entity.getName());
        }

        actionPanel.add(myEntitiesCombo);

        // endregion

        //Region add new entity

        newEntitiesLabel = new JLabel("Selection nouvelle entité");
        newEntitiesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(newEntitiesLabel);

        newEntitiesCombo = new JComboBox(); //TODO : add listener to the entity select

        String entity1 = "Paysan";  //TODO : create a list of entities the player can add
        String entity2 = "Soldat";
        String entity3 = "Grenier";
        String entity4 = "Maison";
        String entity5 = "Caserne";
        newEntitiesCombo.addItem(entity1);
        newEntitiesCombo.addItem(entity2);
        newEntitiesCombo.addItem(entity3);
        newEntitiesCombo.addItem(entity4);
        newEntitiesCombo.addItem(entity5);

        actionPanel.add(newEntitiesCombo);

        //endregion

        //Region square

        squareXLabel = new JLabel("Coordonnée X");
        squareXLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(squareXLabel);

        squareXCombo = new JComboBox(); //TODO : add listener to illuminate the entity select

        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            squareXCombo.addItem(i);

        }

        actionPanel.add(squareXCombo);

        squareYLabel = new JLabel("Coordonnée Y");
        squareYLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(squareYLabel);

        squareYCombo = new JComboBox();

        for (int i = 0; i < Constants.DIMENSION_BOARD; i++) {
            squareYCombo.addItem(i);

        }

        actionPanel.add(squareYCombo);

        //endregion

        //Region Container

        container.add(buttonPanel,BorderLayout.NORTH);

        //container.add(panelInformation,BorderLayout.CENTER);

        container.add(actionPanel,BorderLayout.SOUTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);

        //endregion
    }


    private class ButtonListener implements ActionListener {



        public void actionPerformed(ActionEvent e) {


                if (e.getSource() == cancel) {

                    WelcomPanel welcomePanel = new WelcomPanel(layoutWindow);

                }

                if (e.getSource() == next) {
                    // Insert2Panel insert2Panel = new Insert2Panel(layoutWindow, employeeData, updateBool, returnBool);


                    switch (actionCombo.getSelectedIndex())
                    {
                        case 0 : //Deplacer
                            break;
                        case 1 : //Ajouter
                            break;
                        case 2: //Suicide
                            break;
                    }

                }

        }

    }

    private class ComboListener implements ActionListener, ItemListener {


        public void actionPerformed(ActionEvent a)
        {

        }

        @Override
        public void itemStateChanged(ItemEvent e) {

            switch (actionCombo.getSelectedIndex())
            {
                case 0 : //Deplacer
                    break;
                case 1 : //Ajouter
                    break;
                case 2: //Suicide
                    break;
            }

        }
    }


}
