import java.util.Arrays;

public class questaoAeB {

    public static void main(String[] args) {
        int[] vetorA = {1, 2, 3, 4, 8};
        int[] vetorB = {3, 4, 5, 6, 8};
        
        int[] vetorU = new int[vetorA.length + vetorB.length];

        int tamanhoUniao = uniao(vetorA, vetorA.length, vetorB, vetorB.length, vetorU);

        System.out.println("Vetor A: " + Arrays.toString(vetorA));
        System.out.println("Vetor B: " + Arrays.toString(vetorB));
        System.out.print("União: ");
        for (int i = 0; i < tamanhoUniao; i++) {
            System.out.print(vetorU[i] + " ");
        }
        System.out.println("\nNovo tamanho: " + tamanhoUniao);
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i++) {
            if (!existeNoVetor(u, tamU, a[i])) {
                u[tamU] = a[i];
                tamU++;
            }
        }

        for (int i = 0; i < tamB; i++) {
            if (!existeNoVetor(u, tamU, b[i])) {
                u[tamU] = b[i];
                tamU++;
            }
        }
        return tamU;
    }

    private static boolean existeNoVetor(int[] vetor, int tamanhoAtual, int valor) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (vetor[i] == valor) {
                return true;
            }
        }
        return false;
    }
    public static void ordenar(int[] v, int n) {
    for (int i = 1; i < n; i++) {
        int chave = v[i];
        int j = i - 1;

        while (j >= 0 && v[j] > chave) {
            v[j + 1] = v[j];
            j = j - 1;
        }

        v[j + 1] = chave;
    }
  }
}