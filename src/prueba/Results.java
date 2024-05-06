package prueba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import static prueba.QueenChess.solutions;

public class Results extends JPanel {
    @Override
    public void paint(Graphics g) {
        
            Dimension d = this.getSize();
                                     
            g.setColor(Color.BLACK);
            Font f = new Font("Comic Sans MS", Font.BOLD, 90);
            g.setFont(f);
            g.drawString(solutions + "", 0, d.height/2 + 40);
           
            repaint();
            
    }
}
