import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Classes01 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        preencherPessoaExemplo(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        preencherPessoa(pessoa2);

        System.out.println("\nImpressão das pessoas\n");
        imprimirPessoa(pessoa1);
        System.out.println();
        imprimirPessoaCompacto(pessoa2);
    }

    public static void preencherPessoaExemplo(Pessoa p) {
        p.nome = "Maria";
        p.idade = 20;
        p.peso = 65.7;
        p.altura = 1.74;
    }

    public static void preencherPessoa(Pessoa p) {
        System.out.println("Digite o nome: ");
        p.nome = input.nextLine();
        System.out.println("Digite a idade: ");
        p.idade = input.nextInt();
        System.out.println("Digite o peso: ");
        p.peso = input.nextDouble();
        System.out.println("Digite a altura: ");
        p.altura = input.nextDouble();
    }

    public static void imprimirPessoa(Pessoa p) {
        System.out.println("Nome: " + p.nome);
        System.out.println("Idade: " + p.idade + " anos");
        System.out.println("Peso: " + p.peso + " kg");
        System.out.println("Altura: " + p.altura + " m");
    }

    public static void imprimirPessoaCompacto(Pessoa p) {
        System.out.printf("[%s, %d anos, %.2f kg, %.2f m]\n",
            p.nome, p.idade, p.peso, p.altura 
        );
    }


}