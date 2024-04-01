package Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.Ball;
import Game.GameFrame;
import Game.GamePanel;
import Menu.MenuFrame;

public class StartPage extends JFrame implements ActionListener {


    public static final int width = 350;
    public static final int height = 550;
    StartPagePanel panel;
    JComboBox gameLevelBox;
    JButton color;
    JTextField name;

    JButton buttonStart;
    static JButton buttonBack;

    public StartPage() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        panel = new StartPagePanel();
        this.add(panel);
        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameLevelBox) {
            StartPagePanel.gameLevel = gameLevelBox.getSelectedIndex();
        }
        if (e.getSource() == color) {
            JColorChooser jColorChooser = new JColorChooser();
            StartPagePanel.ballColor = jColorChooser.showDialog(null, "pick a color : ", new Color(0x0C4203));
            Ball.colorChosen = true;
        }
        if (e.getSource() == buttonStart) {
            StartPagePanel.playerName = name.getText();
            this.dispose();
            GamePanel.pauseGame = false;
            GameFrame frame = new GameFrame();
        }
        if (e.getSource() == buttonBack) {
            this.dispose();
            MenuFrame menuFrame = new MenuFrame();
        }


    }
}
