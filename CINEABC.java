import java.util.Scanner;

public class CINEABC {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        
        

        int MsalaA[][] = new int[10][10];
        int T[][] = new int[10][10];
        char x = 'A';

        for (int i = 0; i < MsalaA.length; i++) {
            int cont = 1;
            for (int j = 0; j < MsalaA.length; j++) {
                MsalaA[i][j] = cont;
                cont++;
                
            }
            
           
        }
        for (int i = 0; i < MsalaA.length; i++) {
            for (int j = 0; j < MsalaA.length -1; j++) {
                System.out.print(x +"-"+"0"+MsalaA[i][j]+"\t");
            }
            
               System.out.print(x +"-"+MsalaA[i][9]+"\t");
            
            
            x++;
            System.out.println();
        }
        
        

    }

}
