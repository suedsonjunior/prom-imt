import java.util.Arrays;

public class questaoD {

    public static void main(String[] args) {
        int[] v1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Exemplo 1 - Original: " + Arrays.toString(v1));
        rotacionar(v1, v1.length, k1);
        System.out.println("Rotacionado (k=2): " + Arrays.toString(v1));

        int[] v2 = {1, 2, 3, 4, 5};
        int k2 = -1;
        System.out.println("\nExemplo 2 - Original: " + Arrays.toString(v2));
        rotacionar(v2, v2.length, k2);
        System.out.println("Rotacionado (k=-1): " + Arrays.toString(v2));
    }

    public static void rotacionar(int[] v, int tam, int k) {
        if (tam <= 1) return;

        k = k % tam;

        if (k < 0) {
            k = k + tam;
        }

        if (k == 0) return;

        reverter(v, 0, k - 1);
        reverter(v, k, tam - 1);
        reverter(v, 0, tam - 1);
    }

    private static void reverter(int[] v, int inicio, int fim) {
        while (inicio < fim) {
            int temp = v[inicio];
            v[inicio] = v[fim];
            v[fim] = temp;
            inicio++;
            fim--;
        }
    }
}