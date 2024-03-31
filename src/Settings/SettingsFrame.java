package Settings;

import GameHistory.GameHistoryPanel;
import Start.StartPagePanel;

import javax.swing.*;

public class SettingsFrame extends JFrame {

    public static final int width = 350;
    public static final int height = 550;

    SettingsPanel settingsPanel;
    public SettingsFrame() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        settingsPanel = new SettingsPanel();
        this.add(settingsPanel);

        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }
}
