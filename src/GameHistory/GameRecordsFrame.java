package GameHistory;

import javax.swing.*;

public class GameRecordsFrame extends JFrame{
    public static final int width = 350;
    public static final int height = 550;

    GameRecordsPanel gameRecordsPanel;

    public GameRecordsFrame() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameRecordsPanel = new GameRecordsPanel();
        this.add(gameRecordsPanel);

        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }
}
