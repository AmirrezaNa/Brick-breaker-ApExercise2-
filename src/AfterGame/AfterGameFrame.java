package AfterGame;

import Game.Brick;
import Game.GameFrame;
import Game.GamePanel;
import Menu.MenuFrame;
import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterGameFrame extends JFrame implements ActionListener {

    public static final int width = 350;
    public static final int height = 550;
    AfterGamePanel afterGamePanel;
    JButton startPageButton;
    JButton RematchButton;
    JButton MenuButton;

    public AfterGameFrame() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        startPageButton = new JButton();
        startPageButton.setFocusable(false);
        startPageButton.setBackground(new Color(0x770404));
        startPageButton.setText("Start Page");
        startPageButton.setForeground(new Color(0x1C8F09));
        startPageButton.setBounds(100, 130, 100, 50);
        startPageButton.addActionListener(this);
        startPageButton.setBorder(BorderFactory.createEtchedBorder());


        RematchButton = new JButton();
        RematchButton.setFocusable(false);
        RematchButton.setBackground(new Color(0x770404));
        RematchButton.setText("Rematch");
        RematchButton.setForeground(new Color(0x1C8F09));
        RematchButton.setBounds(100, 230, 100, 50);
        RematchButton.addActionListener(this);
        RematchButton.setBorder(BorderFactory.createEtchedBorder());


        MenuButton = new JButton();
        MenuButton.setFocusable(false);
        MenuButton.setBackground(new Color(0x770404));
        MenuButton.setText("Menu");
        MenuButton.setForeground(new Color(0x1C8F09));
        MenuButton.setBounds(100, 330, 100, 50);
        MenuButton.addActionListener(this);
        MenuButton.setBorder(BorderFactory.createEtchedBorder());


        this.add(startPageButton);
        this.add(MenuButton);
        this.add(RematchButton);

        afterGamePanel = new AfterGamePanel();
        this.add(afterGamePanel);


        this.setVisible(true);

        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startPageButton) {
            this.dispose();
            StartPage startPage = new StartPage();
        }
        if (e.getSource() == RematchButton) {
            this.dispose();
            GameFrame gameFrame = new GameFrame();
            GamePanel.pauseGame = false;
        }
        if (e.getSource() == MenuButton) {
            this.dispose();
            MenuFrame menuFrame = new MenuFrame();
        }
    }
}

