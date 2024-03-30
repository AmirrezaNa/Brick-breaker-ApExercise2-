package Game;

import Game.GamePanel;

import javax.swing.*;

public class GameFrame extends JFrame{


    public static final int width = 350;
    public static final int height = 550;
    static boolean gameIsRunning = true;
    GamePanel gamePanel;

    public GameFrame() {

        // building the game frame -----------------------------------

        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // adding the stuff to the frame -----------------------------


        gamePanel = new GamePanel();
        this.add(gamePanel);
        Thread thread = new Thread(gamePanel);
        thread.start();
        this.setVisible(true);


    }


}
