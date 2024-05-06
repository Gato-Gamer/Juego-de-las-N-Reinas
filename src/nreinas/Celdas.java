
package nreinas;

public class Celdas {
    private int numero;
    
    public Celdas() {
        this.numero = 0;
        
    }

     @Override
    public String toString(){
        return "Celda -->"+ "numero= "+numero+"/ es correcto = ";
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
}
