import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GerenciadorDeVendas {

    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Pedido> pedidos;
    private Scanner scanner;

    public GerenciadorDeVendas() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        while (true) {
            exibeMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    realizarPedido();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 5:
                    listarClientes();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void exibeMenu() {
        System.out.println("\n************* Gerenciador de Vendas *************");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Realizar Pedido");
        System.out.println("4. Listar Produtos");
        System.out.println("5. Listar Clientes");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço de venda produto: ");
        double precoVenda = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
        Produto produto = new Produto(nome, precoVenda);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!\n");
        voltarMenu();
    }

    private void cadastrarCliente() {
        System.out.println("*** Cadastro de cliente ");
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!\n");
        voltarMenu();
    }

    private void realizarPedido() {
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Optional<Cliente> cliente = buscarClientesPorNome(nome);
        if (cliente.isEmpty()) {
            System.out.println("Cliente não cadastrado!\n");
            voltarMenu();
            return;
        }

        Pedido pedido = new Pedido(cliente.get());

        boolean cadastrarProdutosPedido = true;
        do {
            System.out.println("Digite a descricao do produto: ");
            String descricao = scanner.nextLine();

            Optional<Produto> produto = buscarProdutoPorDescricao(descricao);
            if (produto.isEmpty()) {
                System.out.println("Produto não cadastrado!\n");
                voltarMenu();
                return;
            }

            System.out.println("Digite a quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            pedido.adicionarProduto(produto.get(), quantidade);

            System.out.println("Digite 1 para adicionar outro produto | ou apenas Enter para finalizarmos o pedido.");
            String opcao = scanner.nextLine();
            if (!opcao.equals("1")) {
                cadastrarProdutosPedido = false;
            }
        } while (cadastrarProdutosPedido);
        pedido.resumoPedido();
        voltarMenu();
    }

    private void listarProdutos() {
        System.out.println("\n=== Produtos ===");
        this.produtos.forEach(System.out::println);
        System.out.println();
        voltarMenu();
    }

    private void listarClientes() {
        System.out.println("\n=== Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
        System.out.println();
        voltarMenu();
    }
    
    private void voltarMenu() {
        System.out.println("Pressione Enter para voltar ao menu!");
        scanner.nextLine();
    }

    private Optional<Cliente> buscarClientesPorNome(String nome) {
        return this.clientes.stream().filter(cliente -> cliente.getNome().equalsIgnoreCase(nome)).findAny();
    }

    private Optional<Produto> buscarProdutoPorDescricao(String descricao) {
        return this.produtos.stream().filter(produto -> produto.getDescricao().equalsIgnoreCase(descricao)).findAny();
    }

    public static void main(String[] args) {
        GerenciadorDeVendas gerenciador = new GerenciadorDeVendas();
        gerenciador.iniciar();
    }
}
