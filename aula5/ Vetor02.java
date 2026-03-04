import java.util.Random;

public class Vetor02 {

     public static final int TAM = 100;
     public static final int TAM_MIN = 1;
     public static final int TAM_MAX = 30;

    public static void main(String[] args) {
        int[] Numeros = new int[TAM];
        double media = calcularMedia
        System.out.println("digite numeros inteiro entre 1 a 30: ");
        for (int i = 0; i < TAM_MAX; i++) {
            Numeros[i] = randow.nextInt(30) + 1;
        }
        System.out.println("O número sorteado foi: " + Numeros[0]);
    }
}