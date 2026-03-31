import java.util.Arrays;

public class questaoC {

    public static void main(String[] args) {
        int[] V = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] VSR = new int[V.length];

        int tamVSR = gerarVetorSemRepeticao(V, V.length, VSR);

        System.out.println("Vetor original V: " + Arrays.toString(V));
        System.out.print("Vetor VSR: { ");
        for (int i = 0; i < tamVSR; i++) {
            System.out.print(VSR[i] + (i < tamVSR - 1 ? ", " : ""));
        }
        System.out.println(" }");
        System.out.println("Tamanho VSR: " + tamVSR);
    }

    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {
            boolean repetido = false;

            for (int j = 0; j < tamVSR; j++) {
                if (v[i] == vsr[j]) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }

        return tamVSR;
    }
}