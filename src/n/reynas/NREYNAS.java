
package n.reynas;


public class NREYNAS {
 
    

   
    public static void main(String[] args) {
       int n=8;
        int a[][]=new int[n][n];
        
        ponerReinas(a,0);
    }
    public static void ponerReinas(int[][]a ,int j){
        if(j<a.length)
        {
            for(int i=0; i<a.length; i++){
                if(isValid(a, i, j))
                {
                    a[i][j]=i;
                    ponerReinas(a, j+1);
                    a[i][j]=0;
                }
            }
        }
        else
        {
            imprimirMatriz(a);
    }
    }

    private static boolean isValid(int[][] a, int i, int j) {
        boolean flag =true;
        
        for (int k=0;k<a.length && flag==true;K++){
            if(a[i][k]==1)
            {
                flag=false;
            }
        }
        for(int m=0; m<a.length && flag==true;m++){
            for (int n=0; n<a.length && flag ==true;n++){
                if(m-n== i-j && a[m][n]==1)
                {
                    flag=false;
                }
                if(m+n==i+j && a[m][n]==1)
                {
                    flag=false;
                }
            }
        }
        return flag;
       
    }

    private static void imprimirMatriz(int[][] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
