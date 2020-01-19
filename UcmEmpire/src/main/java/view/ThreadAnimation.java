package view;

import javax.swing.*;

public class ThreadAnimation extends Thread {

    private WelcomPanel welcomPanel;
    private JLabel[] images = new JLabel[40];

    public ThreadAnimation (WelcomPanel welcomPanel)
    {
        this.welcomPanel = welcomPanel;
        for (int i = 0 ; i<images.length ; i++)
        {
            images[i] = new JLabel(new ImageIcon("src/main/resources/giphy/giphy-00" + ((i<10)?"0":"") + i + ".jpg"));
        }
    }
    public void run()
    {
        try
        {
            while(true)
            {
                for (int i = 0; i<images.length; i++)
                {
                    welcomPanel.getAnimationPanel().add(images[i]);
                    welcomPanel.getAnimationPanel().repaint();
                    welcomPanel.getAnimationPanel().validate();
                    Thread.sleep(30);
                    welcomPanel.getAnimationPanel().removeAll();
                }
            }
        }
        catch(InterruptedException ie)
        {
            JOptionPane.showMessageDialog(null, ie, "Erreur lors de l'animation!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
