
package controlador;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;

public class JmbledImageApplet extends JApplet{
    
    

        static String imageFileName = "examples/duke_skateboard.jpg";
        private URL imageSrc;
        private JumbledImage jumbledImage;

        public JmbledImageApplet () {
        }

        public JmbledImageApplet (URL imageSrc) {
            this.imageSrc = imageSrc;
        }

        public void init() {
            try {
                imageSrc = new URL(getCodeBase(), imageFileName);
            } catch (MalformedURLException e) {
            }
            buildUI();
        }

        public void buildUI() {
            final JumbledImage ji = new JumbledImage(imageSrc);
            add("Center", ji);
            JButton jumbleButton = new JButton("Jumble");
            jumbleButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton)e.getSource();
                        ji.jumble();
                        ji.repaint();
                    };
                });
            Dimension jumbleSize = ji.getPreferredSize();
            resize(jumbleSize.width, jumbleSize.height+40);
            add("South", jumbleButton);
        }

        public static void main(String s[]) {
            JFrame f = new JFrame("Jumbled Image");
            f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            });
            URL imageSrc = null;
            try {
                 imageSrc = ((new File(imageFileName)).toURI()).toURL();
            } catch (MalformedURLException e) {
            }
            JmbledImageApplet jumbler = new JmbledImageApplet(imageSrc);
            jumbler.buildUI();
            f.add("Center", jumbler);
            f.pack();
            f.setVisible(true);
        }
    
}

    

