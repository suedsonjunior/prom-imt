class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Questao4 {
    public static void main(String[] args) {
        // Método main vazio - Sem testes manuais ou fictícios
    }

    // QUESTÃO 4
    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i <= qtd - 1; i += 1) {
            Pessoa chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].nome.compareToIgnoreCase(chave.nome) > 0) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    }
}