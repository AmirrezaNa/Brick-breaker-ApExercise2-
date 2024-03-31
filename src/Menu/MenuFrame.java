package Menu;

import GameHistory.GameHistoryFrame;
import GameHistory.GameRecordsFrame;
import Settings.SettingsFrame;
import Start.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        buttonStart.setBackground(new Color(0x770404));
        buttonStart.setText("Start");
        buttonStart.setForeground(new Color(0x1C8F09));
        buttonStart.setBounds(50, 10, 100, 50);
        buttonStart.addActionListener(this);
        buttonStart.setBorder(BorderFactory.createEtchedBorder());



        buttonRecords = new JButton();
        buttonRecords.setFocusable(false);
        buttonRecords.setBackground(new Color(0x770404));
        buttonRecords.setText("Records");
        buttonRecords.setForeground(new Color(0x1C8F09));
        buttonRecords.setBounds(50, 80, 100, 50);
        buttonRecords.addActionListener(this);
        buttonRecords.setBorder(BorderFactory.createEtchedBorder());


        buttonHistory = new JButton();
        buttonHistory.setFocusable(false);
        buttonHistory.setBackground(new Color(0x770404));
        buttonHistory.setText("Game History");
        buttonHistory.setForeground(new Color(0x1C8F09));
        buttonHistory.setBounds(50, 150, 100, 50);
        buttonHistory.addActionListener(this);
        buttonHistory.setBorder(BorderFactory.createEtchedBorder());


        buttonSettings = new JButton();
        buttonSettings.setFocusable(false);
        buttonSettings.setBackground(new Color(0x770404));
        buttonSettings.setText("Settings");
        buttonSettings.setForeground(new Color(0x1C8F09));
        buttonSettings.setBounds(50, 220, 100, 50);
        buttonSettings.addActionListener(this);
        buttonSettings.setBorder(BorderFactory.createEtchedBorder());


        buttonExit = new JButton();
        buttonExit.setFocusable(false);
        buttonExit.setBackground(new Color(0x770404));
        buttonExit.setText("Exit");
        buttonExit.setForeground(new Color(0x1C8F09));
        buttonExit.setBounds(50, 290, 100, 50);
        buttonExit.addActionListener(this);
        buttonExit.setBorder(BorderFactory.createEtchedBorder());


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
            GameHistoryFrame gameHistoryFrame = new GameHistoryFrame();

        } else if (e.getSource() == buttonRecords) {
            this.dispose();
            GameRecordsFrame gameRecords = new GameRecordsFrame();

        } else if (e.getSource() == buttonSettings) {
            this.dispose();
            SettingsFrame settings = new SettingsFrame();
        }
    }
}