import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Questao1 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Método main vazio - Sem testes manuais ou fictícios
    }

    // Função à parte para busca exigida pelo enunciado da Questão 1
    public static int buscaSequencialPorNome(Pessoa[] vp, int tam, String nome) {
        for (int i = 0; i < tam; i += 1) {
            if (vp[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    // QUESTÃO 1
    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Erro: Não é possível cadastrar, vetor cheio.");
            return qtd;
        }

        Pessoa novaPessoa = new Pessoa();
        String nomeDigitado;

        while (true) {
            System.out.println("Digite o nome: ");
            nomeDigitado = input.nextLine();

            if (buscaSequencialPorNome(v, qtd, nomeDigitado) == -1) {
                novaPessoa.nome = nomeDigitado;
                break;
            } else {
                System.out.println("Nome já existente. Digite novamente outro nome.");
            }
        }

        System.out.println("Digite a idade: ");
        novaPessoa.idade = input.nextInt();
        System.out.println("Digite o peso: ");
        novaPessoa.peso = input.nextDouble();
        System.out.println("Digite a altura: ");
        novaPessoa.altura = input.nextDouble();
        input.nextLine(); 

        v[qtd] = novaPessoa;
        return qtd + 1;
    }
}