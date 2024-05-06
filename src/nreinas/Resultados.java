
package nreinas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import static nreinas.Reina.soluciones;

public class Resultados extends JPanel{
    @Override
    public void paint(Graphics g) {
        
            Dimension d = this.getSize();
                                     
            g.setColor(Color.black);
            Font f = new Font("Comic Sans MS", Font.BOLD, 90);
            g.setFont(f);
            g.drawString(soluciones + "", 50, d.height/2 + 40);
            
           
            repaint();
            
    }
}
