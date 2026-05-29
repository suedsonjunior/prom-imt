class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Questao3 {
    public static void main(String[] args) {
        // Método main vazio - Sem testes manuais ou fictícios
    }

    public static double imc(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }

    // QUESTÃO 3
    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        int iMaisVelha = -1;
        for (int i = 0; i < qtd; i += 1) {
            if (imc(v[i]) < 18.5) {
                if (iMaisVelha == -1 || v[i].idade > v[iMaisVelha].idade) {
                    iMaisVelha = i;
                }
            }
        }
        return iMaisVelha;
    }
}