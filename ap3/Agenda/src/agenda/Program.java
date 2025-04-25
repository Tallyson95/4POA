package agenda;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ContatoService service = new ContatoService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Remover Contato");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    service.adicionarContato(nome, telefone);
                    break;
                case 2:
                    System.out.println("\nLista de Contatos:");
                    service.listarContatos().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Nome do contato para remover: ");
                    String nomeRemover = scanner.nextLine();
                    service.removerContato(nomeRemover);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
