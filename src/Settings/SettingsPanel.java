package Settings;

import Start.StartPage;
import Menu.MenuFrame;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SettingsPanel extends JPanel implements ActionListener {

    JComboBox aimBox;
    JComboBox themeBox;
    JComboBox saveBox;
    public static int aimNumber;
    static int themeNumber;
    public static int saveNumber;


    SettingsPanel() {
        this.setBackground(new Color(0x0D283B));


        JLabel aimLabel = new JLabel("Aim : ");
        aimLabel.setHorizontalTextPosition(JLabel.LEFT);
        aimLabel.setBackground(new Color(0x0D283B));
        aimLabel.setFont(new Font("Arial", Font.BOLD, 20));
        aimLabel.setOpaque(true);
        aimLabel.setBounds(110, 80, 150, 50);
        aimLabel.setForeground(new Color(0x1C8F09));
        String[] aimOnOff = {"ON", "Off"};
        aimBox = new JComboBox(aimOnOff);
        aimBox.addActionListener(this);
        aimBox.setBounds(180, 95, 70, 20);



        JLabel themeLabel = new JLabel("Theme song : ");
        themeLabel.setHorizontalTextPosition(JLabel.LEFT);
        themeLabel.setBackground(new Color(0x0D283B));
        themeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        themeLabel.setOpaque(true);
        themeLabel.setBounds(30, 170, 150, 50);
        themeLabel.setForeground(new Color(0x1C8F09));
        String[] themeOnOff = {"Off", "ON"};
        themeBox = new JComboBox(themeOnOff);
        themeBox.addActionListener(this);
        themeBox.setBounds(180, 185, 70, 20);



        JLabel saveLabel = new JLabel("Save : ");
        saveLabel.setHorizontalTextPosition(JLabel.LEFT);
        saveLabel.setBackground(new Color(0x0D283B));
        saveLabel.setFont(new Font("Arial", Font.BOLD, 20));
        saveLabel.setOpaque(true);
        saveLabel.setBounds(100, 260, 150, 50);
        saveLabel.setForeground(new Color(0x1C8F09));
        String[] saveOnOff = {"ON", "Off"};
        saveBox = new JComboBox(saveOnOff);
        saveBox.addActionListener(this);
        saveBox.setBounds(180, 275, 70, 20);





        this.add(aimBox);
        this.add(themeBox);
        this.add(saveBox);
        this.setSize(SettingsFrame.width, SettingsFrame.height);
        this.setLayout(null);
        this.setVisible(true);
        this.add(aimLabel);
        this.add(themeLabel);
        this.add(saveLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aimBox) {
            aimNumber = aimBox.getSelectedIndex();
        }
        if (e.getSource() == themeBox) {
            themeNumber = themeBox.getSelectedIndex();
            playThemeSong();
        }
        if (e.getSource() == saveBox) {
            saveNumber = saveBox.getSelectedIndex();
        }
    }

    public static void playThemeSong() {
        if (themeNumber == 1) {
            String songPath = "01-3.wav";
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(songPath));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
