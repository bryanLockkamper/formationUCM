package view;

import models.Character;
import models.Constants;
import models.Entity;
import models.Player;
import models.boardPackage.Board;
import models.boardPackage.SpecialSquare;
import models.boardPackage.Square;
import models.resources.Resource;
import models.resources.ResourceName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import static models.Constants.ACTION_AJOUTER_ENTITE;

public class GamePanel extends JPanel {

    private Container container, boardcontainer;
    private JButton cancel, nextAction,nextRound, confirm, square;
    private JLabel actionLabel, myEntitiesLabel, newEntitiesLabel,timerLabel, ressourceLabel, notifLabel,squareCoordSelected;
    private JTextArea notifArea;
    private JComboBox actionCombo, myEntitiesCombo, newEntitiesCombo, squareXCombo, squareYCombo;
    private JPanel northPanel, boardPanel, actionPanel, southPanel, southButtonPanel, centerPanel,notifPanel;
    private LayoutWindow layoutWindow;
    private Player player;
    private List<JButton> buttonsBoard;
    private Color color = Color.WHITE;
    private int selectSquareIndex;
    private Board board;
    private String labelCoord;

    public GamePanel(LayoutWindow layoutWindow, Player player, Board board) {
        this.board = board;
        this.layoutWindow = layoutWindow;
        container = layoutWindow.getContentPane();
        container.removeAll();

        // region North : exit - timer

        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 3, 100, 100));

        cancel = new JButton("Quitter");
        cancel.setPreferredSize(new Dimension(200,40));
        ButtonListener listener = new ButtonListener();
        cancel.addActionListener(listener);
        northPanel.add(cancel);

        //TODO : ZONE RESSOURCE PLAYER
        ressourceLabel = new JLabel("RESSOURCE PLAYER ZONE");
        northPanel.add(ressourceLabel);

        //TODO : ZONE TIMER
        timerLabel = new JLabel("TIMER ZONE");
        northPanel.add(timerLabel);


        //endregion

        // region Center

        centerPanel = new JPanel();

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


            for (int y = 0; y < Constants.DIMENSION_BOARD; y++) {

                square = new JButton();
                square.setPreferredSize(new Dimension(70,70)); // dimension of a square in the board
                square.addActionListener(squareListener);
                squareCoordSelected = new JLabel(x+";"+y);
                squareCoordSelected.setVisible(false);
                square.add(squareCoordSelected);

                //TODO : take away in other class and color code in enum ?

                squareModifierColor(board.getBoard().get(x).get(y),square);

                if (board.getBoard().get(x).get(y) instanceof SpecialSquare) {

                    switch (((Resource)(board.getBoard().get(x).get(y).getContent())).getResourceName()) {
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

                buttonsBoard.add(square);
                gridBagConstraints.gridx = x;
                gridBagConstraints.gridy = y;
                boardPanel.add(square, gridBagConstraints);

            }
        }


        //endregion

           // region Notification
        notifPanel = new JPanel();
        notifArea = new JTextArea();
        notifArea.setEditable(false);
        notifPanel.add(notifArea);


        // endregion


        // region Action

        actionPanel = new JPanel(new BorderLayout());
        actionPanel.setLayout(new GridLayout(3, 2));

        actionLabel = new JLabel("Action");
        actionLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(actionLabel);

        actionCombo = new JComboBox();
        actionCombo.setEnabled(false);

        ComboListener listenerCombo = new ComboListener();

        actionCombo.addItemListener(listenerCombo);
        actionPanel.add(actionCombo);


        //endregion

        //region select my entity

       /* myEntitiesLabel = new JLabel("Selection mes entités");
        myEntitiesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(myEntitiesLabel);

        myEntitiesCombo = new JComboBox();

        List<Entity> list = player.getEntities();
        for (Entity entity : list) {

            myEntitiesCombo.addItem(entity.getName());
        }

        actionPanel.add(myEntitiesCombo);*/

        // endregion

        //region add new entity

        newEntitiesLabel = new JLabel("Selection nouvelle entité");
        newEntitiesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        actionPanel.add(newEntitiesLabel);

        newEntitiesCombo = new JComboBox();
        newEntitiesCombo.setEnabled(false); //TODO : add an item listener for the combo-Box
        actionPanel.add(newEntitiesCombo);

        //endregion

        centerPanel.add(actionPanel,BorderLayout.WEST);
        centerPanel.add(boardPanel,BorderLayout.CENTER);
        centerPanel.add(notifPanel,BorderLayout.EAST);
        // endregion

        // region South

        southPanel = new JPanel();


        // region button

        southButtonPanel = new JPanel();

        nextAction = new JButton("Action Suivante");
        nextAction.setPreferredSize(new Dimension(300,80));
        nextAction.addActionListener(listener);

        southButtonPanel.add(nextAction,BorderLayout.NORTH);

        nextRound = new JButton("Terminer mon tour");
        nextRound.setPreferredSize(new Dimension(300,80));
        nextRound.addActionListener(listener);
        southButtonPanel.add(nextRound,BorderLayout.SOUTH);

        // endregion

        southPanel.add(southButtonPanel,BorderLayout.SOUTH);

        // endregion

        //region Container

        container.add(northPanel, BorderLayout.NORTH);

        container.add(centerPanel, BorderLayout.CENTER);

        container.add(southPanel, BorderLayout.SOUTH);

        layoutWindow.getContentPane().repaint();

        layoutWindow.setVisible(true);

        //endregion
    }

    public void squareModifierColor(Square boardSquare, JButton square) {


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

    public void updateActionCombo (JComboBox actionCombo,Square square)
    {
        actionCombo.setEnabled(true);
        actionCombo.removeAllItems();
        System.out.println("test");

        if (square.getContent() == null)
        {
            actionCombo.addItem(ACTION_AJOUTER_ENTITE);
        } else if (square.getContent() instanceof Character) {
            actionCombo.addItem(Constants.ACTION_DEPLACER_ENTITE);
            actionCombo.addItem(Constants.ACTION_SUICIDER_ENTITE);

        } else if (square instanceof SpecialSquare) {
            actionCombo.addItem(Constants.ACTION_SORTIR_ENTITY_SPSQUARE);

        } else actionCombo.setEnabled(false);

    }

    private class ButtonListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == cancel) {

                WelcomPanel welcomePanel = new WelcomPanel(layoutWindow);

            }

            if (e.getSource() == nextAction) {


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

    private class ComboListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {

            newEntitiesCombo.setEnabled(false);

            if (e.getSource().equals(actionCombo))
            {
                System.out.println("coucou"+e.getSource().toString()); //TODO : problems with onclick on square to show the actionComboBox option, two call in the itemStateChanged
                if (actionCombo.getSelectedItem() != null)
                {
                    switch (actionCombo.getSelectedItem().toString()) {
                        case Constants.ACTION_DEPLACER_ENTITE :
                        {
                            //Deplacer

                        }
                        break;
                        case ACTION_AJOUTER_ENTITE: //Ajouter
                        {
                            newEntitiesCombo.setEnabled(true);
                            //TODO : use the method to check if any ressource to create the entity, however enabled= false
                            newEntitiesCombo.removeAllItems();
                            newEntitiesCombo.addItem(Constants.ENTITE_PAYSAN);
                            newEntitiesCombo.addItem(Constants.ENTITE_SOLDAT);
                            newEntitiesCombo.addItem(Constants.ENTITE_CASERNE);
                            newEntitiesCombo.addItem(Constants.ENTITE_GRENIER);
                            newEntitiesCombo.addItem(Constants.ENTITE_MAISON);
                        }
                        break;
                        case Constants.ACTION_SUICIDER_ENTITE: //Suicide
                            break;
                    }

                }


            }

        }
    }

    private class SquareListener implements ActionListener {


        public void actionPerformed(ActionEvent p) {

             //TODO : link between board and boardbutton
            String [] coord;
            if (labelCoord != null)
            {
                coord = (labelCoord.split(";"));
                buttonsBoard.stream()
                        .filter(b -> ((JLabel) b.getComponent(0)).getText().equals(labelCoord))
                        .forEach(b -> squareModifierColor(board.getBoard().get(Integer.parseInt(coord[0])).get(Integer.parseInt(coord[1])),b));
                labelCoord = (((JLabel)(((JButton)(p.getSource())).getComponent(0))).getText());
            } else {
                labelCoord = (((JLabel) (((JButton) (p.getSource())).getComponent(0))).getText());
                coord = (labelCoord.split(";"));

            }

            notifArea.setText("Vous avez séléctionné la case : "+labelCoord);
            ((JButton) p.getSource()).setBackground(Color.YELLOW);
            updateActionCombo(actionCombo,board.getBoard().get(Integer.parseInt(coord[0])).get(Integer.parseInt(coord[1])));


        }

    }


}
