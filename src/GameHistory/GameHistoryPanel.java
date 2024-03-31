package GameHistory;

import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameHistoryPanel extends JPanel {

    GameHistoryPanel() {
        this.setBackground(new Color(0x0D283B));
        this.setSize(StartPage.width, StartPage.height);
        this.setLayout(null);
        this.setVisible(true);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Map<String, Integer> allNamesScores = GameHistory.getNamesAndScoresMap();
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.PLAIN  , 18));
        int x = 10;
        int y = 30;
        for (Map.Entry<String, Integer> entry : allNamesScores.entrySet()) {
            g.drawString(entry.getKey() + ": " + entry.getValue(), x, y);
            y += 30;
        }
    }

}
