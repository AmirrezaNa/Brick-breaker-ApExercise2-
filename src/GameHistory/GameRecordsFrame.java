package GameHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Menu.MenuFrame;

public class GameRecordsFrame extends JFrame implements ActionListener {
    public static final int width = 350;
    public static final int height = 550;

    GameRecordsPanel gameRecordsPanel;

    JButton buttonBack;

    public GameRecordsFrame() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        buttonBack = new JButton();
        buttonBack.setFocusable(false);
        buttonBack.setBackground(new Color(0x770404));
        buttonBack.setText("Back");
        buttonBack.setForeground(new Color(0x1C8F09));
        buttonBack.setBounds(50, 350, 100, 50);
        buttonBack.addActionListener(this);
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        this.add(buttonBack);


        gameRecordsPanel = new GameRecordsPanel();
        this.add(gameRecordsPanel);

        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack) {
            this.dispose();
            MenuFrame frame = new MenuFrame();
        }
    }
}
