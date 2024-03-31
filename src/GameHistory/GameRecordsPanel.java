package GameHistory;

import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GameRecordsPanel extends JPanel {

    GameRecordsPanel() {
        this.setBackground(new Color(0x0D283B));
        this.setSize(StartPage.width, StartPage.height);
        this.setLayout(null);
        this.setVisible(true);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.drawString("Game Record : ", 80, 200);
        g.drawString(String.valueOf(GameHistory.findMax()), 160, 250);
    }
}
