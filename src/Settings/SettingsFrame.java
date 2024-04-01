package Settings;

import GameHistory.GameHistoryPanel;
import Menu.MenuFrame;
import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener {

    public static final int width = 350;
    public static final int height = 550;

    SettingsPanel settingsPanel;
    JButton buttonBack;
    public SettingsFrame() {
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

        settingsPanel = new SettingsPanel();
        this.add(settingsPanel);

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
