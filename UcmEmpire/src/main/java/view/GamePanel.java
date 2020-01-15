package view;

import models.Character;
import models.Constants;
import models.Entity;
import models.Player;
import models.boardPackage.Board;
import models.boardPackage.SpecialSquare;
import models.boardPackage.Square;
import models.resources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private Container container, boardcontainer;
    private JButton cancel, next, confirm, square;
    private JLabel actionLabel, myEntitiesLabel, newEntitiesLabel, squareXLabel, squareYLabel;
    private JComboBox actionCombo, myEntitiesCombo, newEntitiesCombo, squareXCombo, squareYCombo;
    private JPanel buttonPanel, boardPanel, actionPanel, titlePanel;
    private LayoutWindow layoutWindow;
    private Player player;
    private ArrayList<ArrayList<JButton>> buttonsBoard;
    private Color color = Color.WHITE;
    private int selectSquareIndex;

    public GamePanel(LayoutWindow layoutWindow, Player player, Board board) {
        this.layoutWindow = layoutWindow;
        container = layoutWindow.getContentPane();
        container.removeAll();

        // region button

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        cancel = new JButton("Quitter");
        next = new JButton("Suivant");

        ButtonListener listener = new ButtonListener();
        cancel.addActionListener(listener);
        next.addActionListener(listener);


        buttonPanel.setLayout(new GridLayout(1, 3, 100, 100));
        buttonPanel.add(cancel);
        buttonPanel.add(next);


        //endregion

        // region Board

        boardPanel = new JPanel();

        boardPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipady = gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.weightx = board.getBoard().size();
        gridBagConstraints.weighty = board.getBoard().size();
        //TODO : change image with a transparent alpha canal
        Icon iconMine = new ImageIcon("src/main/resources/images/mine.jpg");
        Icon iconForest = new ImageIcon("src/main/resources/images/forest.jpg");
        Icon iconPerso = new ImageIcon("src/main/resources/images/perso.jpg");

        buttonsBoard = new ArrayList<>(Constants.DIMENSION_BOARD);
        SquareListener squareListener = new SquareListener();

        for (int x = 0; x < Constants.DIMENSION_BOARD; x++) {

            buttonsBoard.add(new ArrayList<>());

            for (int y = 0; y < Constants.DIMENSION_BOARD; y++) {

                square = new JButton(); //TODO : bug to fix  : select only the last listener create but i need to listeen all the square to collect these infosmations
                square.addActionListener(squareListener);

                //TODO : take away in other class and color code in enum ?

                squareModifierColor(board.getBoard().get(x).get(y));

                if (board.getBoard().get(x).get(y) instanceof SpecialSquare) {

                    switch (((Resource)(board.getBoard().get(x).get(y).getContent())).getResourceName()) { //TODO : need to decide if the content of a special case is an entity or a ressource type (code review by Bryan)
                        case STONE: {
                            square.setIcon(iconMine);
                        }
                        break;

                        case WOOD: {
                            square.setIcon(iconForest);
                        }
                        break;
                        default:
                            square.setIcon(null);

                    }

                }

                if (board.getBoard().get(x).get(y).getContent() instanceof Character) {
                    //TODO : continue with differents character
                    square.setIcon(iconPerso);

                }


                if (!board.getBoard().get(x).get(y).isWalkable()) {
                    square.setEnabled(false);
                }

                buttonsBoard.get(x).add(square);
                gridBagConstraints.gridx = x;
                gridBagConstraints.gridy = y;
                boardPanel.add(square, gridBagConstraints);

            }
        }


        //endregion


        // region Action

        actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(6, 2));

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

        //region select my entity

        myEntitiesLabel = new JLabel("Selection mes entités");
        myEntitiesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(myEntitiesLabel);

        myEntitiesCombo = new JComboBox(); //TODO : add listener to illuminate the entity select

        List<Entity> list = player.getEntities();
        for (Entity entity : list) {

            myEntitiesCombo.addItem(entity.getName());
        }

        actionPanel.add(myEntitiesCombo);

        // endregion

        //region add new entity

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

        //region square

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

        //region Container

        container.add(buttonPanel, BorderLayout.NORTH);

        container.add(boardPanel, BorderLayout.CENTER);

        container.add(actionPanel, BorderLayout.SOUTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);

        //endregion
    }

    public void squareModifierColor(Square boardSquare) {

        switch (boardSquare.getBiome().toString()) {
            case "PLAINS": {
                square.setBackground(Color.WHITE);
            }
            break;
            case "MOUNTAIN": {
                square.setBackground(Color.DARK_GRAY);
            }
            break;
            case "SEA": {
                square.setBackground(Color.BLUE);
            }
            break;
            case "DESERT": {
                square.setBackground(Color.ORANGE);
            }
            break;
            case "FOREST": {
                square.setBackground(Color.GREEN);
            }
            break;
            default:
                square.setBackground(Color.BLACK);

        }
    }


    private class ButtonListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == cancel) {

                WelcomPanel welcomePanel = new WelcomPanel(layoutWindow);

            }

            if (e.getSource() == next) {


                switch (actionCombo.getSelectedIndex()) {
                    case 0: //Deplacer
                        break;
                    case 1: //Ajouter
                        break;
                    case 2: //Suicide
                        break;
                }

            }

        }

    }

    private class ComboListener implements ActionListener, ItemListener {


        public void actionPerformed(ActionEvent a) {

        }

        @Override
        public void itemStateChanged(ItemEvent e) {

            switch (actionCombo.getSelectedIndex()) {
                case 0: //Deplacer
                    break;
                case 1: //Ajouter
                    break;
                case 2: //Suicide
                    break;
            }

        }
    }

    private class SquareListener implements ActionListener {


        public void actionPerformed(ActionEvent p) {

             //TODO : link between board and boardbutton
            color = ((JButton) p.getSource()).getBackground();
            selectSquareIndex = buttonsBoard.indexOf((p.getSource()));
            ((JButton) p.getSource()).setBackground(Color.YELLOW);


        }

    }


}
