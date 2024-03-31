package Start;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JFrame {


    public static final int width = 350;
    public static final int height = 550;
    StartPagePanel panel;

    public StartPage() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new StartPagePanel();
        this.add(panel);

        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }

}
