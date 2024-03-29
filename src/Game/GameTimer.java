package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends JLabel {
    int second;
    JLabel timeLabel;
    Timer timer;

    public GameTimer() {
        this.setBounds(300, 20, 30, 20);
        this.setBackground(new Color(0xE5E5E5));
        second = 0;
        timeLabel = new JLabel();
        gameTimer();
        timer.start();
    }

    public void gameTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;


            }
        });
    }


}
