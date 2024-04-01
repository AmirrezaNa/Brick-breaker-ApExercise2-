package AfterGame;

import Game.GameFrame;
import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Menu.MenuFrame;

public class AfterGamePanel extends JPanel{


    AfterGamePanel() {
        this.setBackground(new Color(0x0D283B));


        this.setSize(StartPage.width, StartPage.height);
        this.setLayout(null);
        this.setVisible(true);
    }

}
