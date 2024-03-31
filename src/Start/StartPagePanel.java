package Start;

import Game.Ball;
import Game.GameFrame;
import Menu.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPagePanel extends JPanel implements ActionListener {


    JComboBox gameLevelBox;
    JButton color;
    public static Color ballColor;
    JTextField name;
    public static String playerName;
    public static int gameLevel;
    JButton buttonStart;
    JButton buttonBack;
    StartPagePanel() {
        this.setBackground(new Color(0x0D283B));


        JLabel gameLevelLabel = new JLabel("difficulty : ");
        gameLevelLabel.setHorizontalTextPosition(JLabel.LEFT);
        gameLevelLabel.setBackground(new Color(0x0D283B));
        gameLevelLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gameLevelLabel.setOpaque(true);
        gameLevelLabel.setBounds(60, 80, 150, 50);
        gameLevelLabel.setForeground(new Color(0x1C8F09));
        String[] gameLevels = {"Medium", "Easy", "Hard"};
        gameLevelBox = new JComboBox(gameLevels);
        gameLevelBox.addActionListener(this);
        gameLevelBox.setBounds(180, 95, 70, 20);


        JLabel ballColorLabel = new JLabel("Ball Color : ");
        ballColorLabel.setHorizontalTextPosition(JLabel.LEFT);
        ballColorLabel.setBackground(new Color(0x0D283B));
        ballColorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ballColorLabel.setOpaque(true);
        ballColorLabel.setBounds(50, 160, 150, 50);
        ballColorLabel.setForeground(new Color(0x1C8F09));
        color = new JButton();
        color.setFocusable(false);
        color.setBackground(new Color(0x770404));
        color.setText("Color");
        color.setForeground(new Color(0x1C8F09));
        color.setBounds(180, 160, 100, 50);
        color.addActionListener(this);
        color.setBorder(BorderFactory.createEtchedBorder());



        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setHorizontalTextPosition(JLabel.LEFT);
        nameLabel.setBackground(new Color(0x0D283B));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setOpaque(true);
        nameLabel.setBounds(90, 245, 150, 50);
        nameLabel.setForeground(new Color(0x1C8F09));
        name = new JTextField();
        name.setBounds(160, 255, 150, 30);




        buttonStart = new JButton();
        buttonStart.setFocusable(false);
        buttonStart.setBackground(new Color(0x770404));
        buttonStart.setText("Start");
        buttonStart.setForeground(new Color(0x1C8F09));
        buttonStart.setBounds(200, 350, 100, 50);
        buttonStart.addActionListener(this);
        buttonStart.setBorder(BorderFactory.createEtchedBorder());



        buttonBack = new JButton();
        buttonBack.setFocusable(false);
        buttonBack.setBackground(new Color(0x770404));
        buttonBack.setText("Back");
        buttonBack.setForeground(new Color(0x1C8F09));
        buttonBack.setBounds(50, 350, 100, 50);
        buttonBack.addActionListener(this);
        buttonBack.setBorder(BorderFactory.createEtchedBorder());



        this.add(gameLevelBox);
        this.add(color);
        this.add(name);
        this.add(buttonStart);
        this.add(buttonBack);
        this.setSize(StartPage.width, StartPage.height);
        this.setLayout(null);
        this.setVisible(true);
        this.add(gameLevelLabel);
        this.add(ballColorLabel);
        this.add(nameLabel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameLevelBox) {
            gameLevel = gameLevelBox.getSelectedIndex();
        }
        if (e.getSource() == color) {
            JColorChooser jColorChooser = new JColorChooser();
            ballColor = jColorChooser.showDialog(null, "pick a color : ", new Color(0x0C4203));
            Ball.colorChosen = true;
        }
        if (e.getSource() == buttonStart) {
            playerName = name.getText();
            GameFrame frame = new GameFrame();
        }
        if (e.getSource() == buttonBack) {
            MenuFrame frame = new MenuFrame();
        }

    }

}
