
package nreinas;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Reina extends JPanel {
    public static int soluciones = 0;
    
    public static int tamano = 11;
    public static int x = 0;
    public static int y = 0;

    Graphics g;
    private static int reinas = 0;
    public static Celdas[][] tablero;
    public static ArrayList<Celdas[][]> solucionesMatriz = new ArrayList<Celdas[][]>();
    
    public Reina() {

        if (tamano > 0) {
            crearCeldas();

            recursivo(y, x);
            //paint(g);
            System.out.println("Total numero de Soluciones: " + soluciones);

            Ajedrez.mostrar = true;
            
        } else {
            System.out.println("No hay solución");
            System.exit(0);
        }
        
    }
    public final void recursivo(int fila, int columna) {

        fila--;
        while (fila != tamano - 1) {

            fila++;

            if (ordenarReina(fila, columna)) {
                agregar(fila, columna);
                
                if (reinas == tamano) {
                    soluciones++;
                    
                    Celdas[][] temp_table = new Celdas[tamano][tamano];
                    for (int i = 0; i < tamano; i += 1) {
                        for (int j = 0; j < tamano; j += 1) {
                            int val = tablero[i][j].getNumero();
                            Celdas casilla = new Celdas();                            
                            temp_table[i][j] = casilla;
                            temp_table[i][j].setNumero(val);
                        }
                    }
                    
                    solucionesMatriz.add(temp_table);
                    
                    
                    System.out.println(""); // DEBUG
                    quitar(fila, columna);
                } else {

                    recursivo(0, columna + 1);

                    quitar(fila, columna);

                }
            }

        }
        
    }

    public void agregar(int i, int j) {
        tablero[i][j].setNumero(1);
        reinas++;
        
    }

    public void quitar(int i, int j) {
        tablero[i][j].setNumero(0);
        reinas--;
        
    }


    public boolean ordenarReina(int i, int j) {

        int ii = i;
        int jj = j;
        
        if (tablero[i][j].getNumero() == 1) {
            return false;
        }

        while (i + 1 != tamano) {
            i++;
            System.out.println("while 1 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        i = ii;

        while (i - 1 != -1) {

            i--;
            System.out.println("while 2 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        i = ii;

        while (j - 1 != -1) {

            j--;
            System.out.println("while 3 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        j = jj;

        while (j + 1 != tamano) {

            j++;
            System.out.println("while 4 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        j = jj;

        while (i + 1 != tamano && j - 1 != -1) {

            i++;
            j--;
            System.out.println("while 5 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i + 1 != tamano && j + 1 != tamano) {

            i++;
            j++;
            System.out.println("while 6 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i - 1 != -1 && j - 1 != -1) {

            i--;
            j--;
            System.out.println("while 7 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i - 1 != -1 && j + 1 != tamano) {

            i--;
            j++;
            System.out.println("while 8 tab["+i+"]["+j+"]= "+tablero[i][j].getNumero());
            if (tablero[i][j].getNumero() == 1) {
                return false;
            }

        }
        System.out.println("Fin whiles");
       
        return true;
        

    }

    public static void crearCeldas() {
        tablero = new Celdas[tamano][tamano];
        for (int i = 0; i < tamano; i +=1) {
            for (int j = 0; j < tamano; j += 1) {
                Celdas casilla = new Celdas();
                tablero[i][j] = casilla;    
            }
        }

    }

    @Override
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
    }
    
}
