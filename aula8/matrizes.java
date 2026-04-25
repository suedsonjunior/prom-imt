import java.util.Scanner;
public class matrizes {
    public static void main(String[] args) {
        Scanner matriz = new Scanner(System.in);
        int m[][] = new int[3][3];
        for (int i = 0; i < m.length; i+=1) {
            for (int j = 0; j < m.[i].length; j+=1) {
                System.out.printf("Digite m{%d][%d]:" , i+=1, j+=1);
                matriz[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < m.length; i+=1) {
            for (int j = 0; j < m.[i].length; j+=1) {
                System.out.print(m[i][j]+" ");
            }
          System.out.println();
        }

    }
}