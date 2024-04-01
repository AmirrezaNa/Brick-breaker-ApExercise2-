package Start;

import Game.Ball;
import Game.GameFrame;
import Menu.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPagePanel extends JPanel{


    public static Color ballColor;
    public static String playerName;
    public static int gameLevel;
    StartPagePanel() {
        this.setBackground(new Color(0x0D283B));


        this.setSize(StartPage.width, StartPage.height);
        this.setLayout(null);
        this.setVisible(true);

    }


}
