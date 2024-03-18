package Menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{


    Image image;



    MenuPanel() {

        //background------------------

        image = new ImageIcon("MenuBackground.jfif").getImage();

        //---------------------------


        this.setPreferredSize(new Dimension(800, 400));


    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 200, 0, 600, 400, null);
    }
}
