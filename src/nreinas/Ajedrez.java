
package nreinas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static nreinas.Reina.tamano;
import static nreinas.Reina.crearCeldas;

public class Ajedrez extends JPanel {
    public static boolean mostrar = false;
    static int pos = 0;
   /* @Override
    public void paint(Graphics g) {

        ImageIcon imagen = new ImageIcon("princes1.png");
        g.fillRect(0, 0, tamano * 80, tamano * 80);
        
        //PINTA LOS CUADROS DEL TABLERO

        for (int i = 0; i <= (tamano * 80); i += 160) {
            for (int j = 0; j <= (tamano * 80); j += 160) {
                g.clearRect(i, j, 80, 80);
            }
        }

        for (int i = 80; i <= (tamano - 1) * 80; i += 160) {
            for (int j = 80; j <= (tamano - 1) * 80; j += 160) {
                g.clearRect(i, j, 80, 80);
            }
        }

        int x = 0, y = 0;
        //PONE EL ICONO EN EL TABLERO
        for (int i = 0; i <= (tamano - 1) * 80; i += 80) {
            for (int j = 0; j <= (tamano - 1) * 80; j += 80) {
                if (Reina.tablero[x][y].getNumero() == 1) {
                    g.drawImage(imagen.getImage(), i, j, 80, 80, null);
                }
                y++;
            }
            y = 0;
            x++;
        }
        x = 0;

        repaint();
}*/
    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    //System.out.print("Insertar tamaño del tablero: ");
                    //int tam = Integer.parseInt(br.readLine());
                   int tam= Integer.parseInt(JOptionPane.showInputDialog( "Introduzca el tamaño del tablero: "));
                    
                    Reina.tamano = tam;

                    //crearCeldas();
                    JFrame frame = new JFrame();
                    frame.setSize((int) tamano * 85, (tamano * 85) + 21);
                    
                    frame.getContentPane().add(new Reina());
                    frame.setLocationRelativeTo(null);
                    frame.setBackground(Color.LIGHT_GRAY);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setAlwaysOnTop(true);
                    Reina peaches = new Reina();
                    peaches.setVisible(true);

                    if (mostrar == true) {
                        System.out.println("Showing results...");
                        JFrame results = new JFrame("Results");
                        results.setContentPane(new Resultados());
                        results.setContentPane(new Resultados());
                        results.setVisible(true);
                        results.setSize(new Dimension(300, 260));
                        results.setBackground(Color.red);
                        results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        results.setLocationRelativeTo(null);
                        results.setAlwaysOnTop(true);

                        

                        System.out.println("DEBUG ARRAYL SIZE: " + Reina.solucionesMatriz.size());
                        Reina.tablero = Reina.solucionesMatriz.get(pos);

                        results.addKeyListener(new KeyListener() {

                            public void keyPressed(KeyEvent e) {

                                int code = e.getKeyCode();
                                if (pos < Reina.solucionesMatriz.size()-1 && code == KeyEvent.VK_ENTER) {
                                    pos++;
                                    Reina.tablero = Reina.solucionesMatriz.get(pos);
                                }
                                /*if (code == KeyEvent.VK_R)
                                    pos = 0;
                                    Reina.tablero = Reina.solucionesMatriz.get(pos);
*/
                            }

                            @Override
                            public void keyTyped(KeyEvent e) {
                            }

                            @Override
                            public void keyReleased(KeyEvent e) {
                            }

                        });

                        System.out.println("IMPRIMIENDO TABLAS ALMACENADAS EN ARRAYLIST");
                        for (int i = 0; i < Reina.solucionesMatriz.size(); i++) {
                            for (int j = 0; j < Reina.tablero.length; j++) {
                                for (int k = 0; k < Reina.tablero.length; k++) {
                                    System.out.print(Reina.solucionesMatriz.get(i)[j][k].toString() + "\n");
                                }
                            }
                            System.out.println("");
                        }

                    }

                } /*catch (IOException ex) {
                    System.out.println("Error en la lectura por teclado");
                    System.exit(1);
                } 
                catch (IndexOutOfBoundsException e) {
                    System.out.println("No es posible ordenar las reinas");
                    System.exit(1);
                }
                
                */
                catch (NumberFormatException e) {
                    System.out.println("Error en la introducción de los números");
                    System.exit(1);
                }
                
            }

        };
        t.start();

    }
    
}
