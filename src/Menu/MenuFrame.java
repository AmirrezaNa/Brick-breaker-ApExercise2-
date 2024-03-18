package Menu;

import Game.GameHistory;
import Game.GameRecords;
import Settings.Settings;
import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class MenuFrame extends JFrame implements ActionListener{


    MenuPanel menuPanel;

    JButton buttonStart;
    JButton buttonRecords;
    JButton buttonHistory;
    JButton buttonSettings;
    JButton buttonExit;

    public MenuFrame() {

        //menu buttons------------------------------


        buttonStart = new JButton();
        buttonStart.setFocusable(false);
        buttonStart.setText("Start");
        buttonStart.setBounds(50, 10, 100, 50);
        buttonStart.addActionListener(this);



        buttonRecords = new JButton();
        buttonRecords.setFocusable(false);
        buttonRecords.setText("Records");
        buttonRecords.setBounds(50, 80, 100, 50);
        buttonRecords.addActionListener(this);


        buttonHistory = new JButton();
        buttonHistory.setFocusable(false);
        buttonHistory.setText("Game History");
        buttonHistory.setBounds(50, 150, 100, 50);
        buttonHistory.addActionListener(this);


        buttonSettings = new JButton();
        buttonSettings.setFocusable(false);
        buttonSettings.setText("Settings");
        buttonSettings.setBounds(50, 220, 100, 50);
        buttonSettings.addActionListener(this);


        buttonExit = new JButton();
        buttonExit.setFocusable(false);
        buttonExit.setText("Exit");
        buttonExit.setBounds(50, 290, 100, 50);
        buttonExit.addActionListener(this);


        //----------------------------

        this.add(buttonExit);
        this.add(buttonHistory);
        this.add(buttonRecords);
        this.add(buttonStart);
        this.add(buttonSettings);



        menuPanel = new MenuPanel();



        this.setTitle("Menu");
        this.setResizable(false);
        this.add(menuPanel);
        this.setBackground(new Color(13, 40, 59));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(250, 165, 800, 400);
        this.setVisible(true);
        

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonStart) {
            this.dispose();
            StartPage startPage = new StartPage();

        } else if (e.getSource() == buttonExit) {
            System.exit(0);

        } else if (e.getSource() == buttonHistory) {
            this.dispose();
            GameHistory gameHistory = new GameHistory();

        } else if (e.getSource() == buttonRecords) {
            this.dispose();
            GameRecords gameRecords = new GameRecords();

        } else if (e.getSource() == buttonSettings) {
            this.dispose();
            Settings settings = new Settings();
        }
    }
}