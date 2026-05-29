class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Questao2 {
    public static void main(String[] args) {
        // Método main vazio - Sem testes manuais ou fictícios
    }

    // Função à parte para cálculo do IMC exigida pelo enunciado da Questão 2
    public static double imc(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }

    // QUESTÃO 2
    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i += 1) {
            System.out.printf("Nome: %s, Idade: %d, Peso: %.2f, Altura: %.2f, IMC: %.2f\n",
                v[i].nome, v[i].idade, v[i].peso, v[i].altura, imc(v[i])
            );
        }
    }
}