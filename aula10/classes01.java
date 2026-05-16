import java.util.Scanner;

public class classes01 {
    public static Scanner  scanner = new Scanner(System.in) {
       public static void main(String[] args) {
        Pessoa maria = new  Pesssoa();
        preencherPessoaExemplos(pessoa1);
       } 
        public static void preencherPessoaExemplos(Pessoa  p){
            p.nome = "Maria";
            p.idade = 20;
            p.peso = 65.7;
            p.altura  = 1.74;
        }
    }
    
}