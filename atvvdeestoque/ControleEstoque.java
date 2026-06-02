import java.util.Scanner;

// =========================================================================
// CLASSE PRODUTO (Estrutura do Objeto)
// =========================================================================
class Produto {
    String nome;
    int qtdEstoque;
    double precoUnitario;
    String categoria;
    int qtdMinima;
}

// =========================================================================
// CLASSE PRINCIPAL (Controle do Sistema)
// =========================================================================
public class ControleEstoque {
    public static final int TAM = 100; // Capacidade máxima do estoque
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Produto[] estoque = new Produto[TAM];
        int qtdCadastrada = 0;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========= MENU CONTROLE DE ESTOQUE =========");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Todos os Produtos");
            System.out.println("3. Filtrar por Categoria");
            System.out.println("4. Ordenar por Nome");
            System.out.println("5. Remover Elemento");
            System.out.println("6. Atualizar Preco");
            System.out.println("7. Listagem com Subtotal por Categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            
            if (!input.hasNextInt()) break; // Proteção para fim de arquivo do txt
            opcao = input.nextInt();
            input.nextLine(); // Limpa o buffer do ENTER

            switch (opcao) {
                case 1:
                    qtdCadastrada = cadastrarProduto(estoque, qtdCadastrada);
                    break;
                case 2:
                    listarProdutos(estoque, qtdCadastrada);
                    break;
                case 3:
                    filtrarPorCategoria(estoque, qtdCadastrada);
                    break;
                case 4:
                    ordenarPorNome(estoque, qtdCadastrada);
                    break;
                case 5:
                    qtdCadastrada = removerProduto(estoque, qtdCadastrada);
                    break;
                case 6:
                    atualizarPreco(estoque, qtdCadastrada);
                    break;
                case 7:
                    listagemComSubtotal(estoque, qtdCadastrada);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    // =========================================================================
    // 1. CADASTRAR PRODUTO (Garante unicidade pelo nome)
    // =========================================================================
    public static int cadastrarProduto(Produto[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Erro: Estoque com capacidade maxima atingida!");
            return qtd;
        }

        Produto novo = new Produto();
        System.out.print("Digite o nome/descricao do produto: ");
        novo.nome = input.nextLine();

        // Evita a duplicidade de produtos com o mesmo nome
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(novo.nome)) {
                System.out.println("Erro: Já existe um produto cadastrado com esse nome!");
                return qtd;
            }
        }

        System.out.print("Digite a quantidade em estoque: ");
        novo.qtdEstoque = input.nextInt();
        System.out.print("Digite o preco unitario: ");
        novo.precoUnitario = input.nextDouble();
        input.nextLine(); // Limpa buffer

        System.out.print("Digite a categoria do produto: ");
        novo.categoria = input.nextLine();
        System.out.print("Digite a quantidade minima permitida: ");
        novo.qtdMinima = input.nextInt();
        input.nextLine(); // Limpa buffer

        v[qtd] = novo;
        System.out.println("Produto cadastrado com sucesso!");
        return qtd + 1;
    }

    // =========================================================================
    // 2. LISTAR TODOS
    // =========================================================================
    public static void listarProdutos(Produto[] v, int qtd) {
        if (qtd == 0) {
            System.out.println("Nenhum produto cadastrado no estoque.");
            return;
        }
        System.out.println("\n--- LISTAGEM GERAL DE PRODUTOS ---");
        for (int i = 0; i < qtd; i++) {
            System.out.printf("Nome: %s | Qtd: %d | Preco: R$ %.2f | Cat: %s | Qtd Min: %d\n",
                v[i].nome, v[i].qtdEstoque, v[i].precoUnitario, v[i].categoria, v[i].qtdMinima);
        }
    }

    // =========================================================================
    // 3. FILTRAR POR CATEGORIA
    // =========================================================================
    public static void filtrarPorCategoria(Produto[] v, int qtd) {
        System.out.print("Digite a categoria que deseja filtrar: ");
        String filtro = input.nextLine();
        boolean encontrou = false;

        System.out.printf("\n--- PRODUTOS DA CATEGORIA: %s ---\n", filtro);
        for (int i = 0; i < qtd; i++) {
            if (v[i].categoria.equalsIgnoreCase(filtro)) {
                System.out.printf("Nome: %s | Qtd: %d | Preco: R$ %.2f\n", 
                    v[i].nome, v[i].qtdEstoque, v[i].precoUnitario);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum produto encontrado nesta categoria.");
    }

    // =========================================================================
    // 4. ORDENAR POR NOME (Insertion Sort)
    // =========================================================================
    public static void ordenarPorNome(Produto[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Produto chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].nome.compareToIgnoreCase(chave.nome) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
        System.out.println("Estoque ordenado por nome com sucesso!");
    }

    // =========================================================================
    // 5. REMOVER ELEMENTO (Busca e puxa os elementos para preencher o buraco)
    // =========================================================================
    public static int removerProduto(Produto[] v, int qtd) {
        System.out.print("Digite o nome do produto que deseja remover: ");
        String alvo = input.nextLine();
        int indiceEncontrado = -1;

        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(alvo)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("Produto nao encontrado para remocao.");
            return qtd;
        }

        // Desloca os elementos subsequentes uma posição para a esquerda
        for (int i = indiceEncontrado; i < qtd - 1; i++) {
            v[i] = v[i + 1];
        }
        v[qtd - 1] = null; // Libera o último ponteiro
        System.out.println("Produto removido com sucesso!");
        return qtd - 1;
    }

    // =========================================================================
    // 6. ATUALIZAR PREÇO
    // =========================================================================
    public static void atualizarPreco(Produto[] v, int qtd) {
        System.out.print("Digite o nome do produto para atualizar o preco: ");
        String alvo = input.nextLine();

        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(alvo)) {
                System.out.print("Digite o novo preco unitario: ");
                v[i].precoUnitario = input.nextDouble();
                input.nextLine(); // Limpa buffer
                System.out.println("Preco atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto nao encontrado.");
    }

    // =========================================================================
    // 7. LISTAGEM COM SUBTOTAL POR CATEGORIA (Ordena por Categoria + Quebra de Nível)
    // =========================================================================
    public static void listagemComSubtotal(Produto[] v, int qtd) {
        if (qtd == 0) {
            System.out.println("Estoque vazio.");
            return;
        }

        // Ordenação obrigatória por Categoria usando Selection Sort antes da listagem
        for (int i = 0; i < qtd - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < qtd; j++) {
                if (v[j].categoria.compareToIgnoreCase(v[menor].categoria) < 0) {
                    menor = j;
                }
            }
            Produto aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }

        System.out.println("\n=============================================");
        System.out.println("   LISTAGEM DE ESTOQUE COM DETALHE POR CATEGORIA");
        System.out.println("=============================================");

        double totalGeral = 0;
        int i = 0;

        // Processamento das quebras de categoria
        while (i < qtd) {
            String categoriaAtual = v[i].categoria;
            double subtotalCategoria = 0;

            System.out.printf("\nCategoria: %s\n", categoriaAtual.toUpperCase());
            System.out.println("---------------------------------------------");

            // Varre enquanto pertencer à mesma categoria
            while (i < qtd && v[i].categoria.equalsIgnoreCase(categoriaAtual)) {
                double valorEmEstoque = v[i].qtdEstoque * v[i].precoUnitario;
                System.out.printf(" * %s - Qtd: %d - Preco Un: R$ %.2f (Total: R$ %.2f)\n",
                    v[i].nome, v[i].qtdEstoque, v[i].precoUnitario, valorEmEstoque);
                
                subtotalCategoria += valorEmEstoque;
                i++;
            }
            System.out.printf(" > Subtotal %s: R$ %.2f\n", categoriaAtual, subtotalCategoria);
            totalGeral += subtotalCategoria;
        }

        System.out.println("=============================================");
        System.out.printf("TOTAL GERAL EM ESTOQUE: R$ %.2f\n", totalGeral);
        System.out.println("=============================================");
    }
}
