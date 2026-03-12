package aula6;
import java.util.Scanner;

public class VetorSRept {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];
        int i = 0;

        while (i < 10) {
            System.out.print("Digite o valor para a posição [" + i + "]: ");
            int valorDigitado = leitor.nextInt();
            boolean repetido = false;

            // 1. Percorre o vetor até a posição ATUAL (i) para verificar duplicatas
            for (int j = 0; j < i; j++) {
                if (vetor[j] == valorDigitado) {
                    repetido = true;
                    break; // Se achou um igual, já para de procurar
                }
            }

            // 2. Só adiciona ao vetor e pula para o próximo índice se NÃO for repetido
            if (repetido) {
                System.out.println("Erro: O valor " + valorDigitado + " já foi inserido. Tente outro!");
            } else {
                vetor[i] = valorDigitado;
                i++; // Incrementa o índice apenas quando o valor é válido
            }
        }

        // 3. Exibe o vetor final para conferência
        System.out.println("\n--- Vetor Final Sem Repetições ---");
        for (int k = 0; k < 10; k++) {
            System.out.print(vetor[k] + " ");
        }
        
        leitor.close();
    }
}