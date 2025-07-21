import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Agenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Contato> agenda = new ArrayList<Contato>();

        while (true){
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada: Adicionar Contato.");
                    // lógica para adicionar
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada: Listar Contatos.");
                    // lógica para listar
                    listarContatos(agenda);
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada: Buscar Contato.");
                    // lógica para buscar
                    procurarContato(agenda, scanner);
                    break;
                case 4:
                    System.out.println("Opção 4 selecionada: Remover Contato.");
                    // lógica para remover
                    excluirContato(agenda, scanner);
                    break;
                case 5:
                    System.out.println("Opção 5 selecionada: Atualizar Contato.");
                    // lógica para atualizar
                    break;
                case 6:
                    System.out.println("Saindo da agenda...");
                    break;
                default:
                    printLinha();
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }

    public static void adicionarContato(List<Contato> agenda, Scanner scanner) {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();  // Corrigido: precisa dos parênteses ()

        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email do contato: ");
        String email = scanner.nextLine();

        // Criar novo contato, uma instancia
        Contato novoContato = new Contato(nome, telefone, email);

        // Adicionar na agenda
        agenda.add(novoContato);

        System.out.println("Contato adicionado com sucesso!");
        printLinha();
    }

    public static void listarContatos(List<Contato> agenda){
        printLinha();
        for (int i = 0; i < agenda.size() ; i++) {
            System.out.println("Contato: " + (1+i));
            System.out.println(agenda.get(i).toString());
            printLinha();
        }
    }

    public static void excluirContato(List<Contato> agenda, Scanner scanner) {
        if (agenda.isEmpty()) {
            System.out.println("A agenda está vazia.");
            return;
        }

        listarContatos(agenda);  // mostra a lista com os índices

        System.out.print("Digite o número do contato que deseja excluir: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer

        if (indice > 0 && indice <= agenda.size()) {
            Contato removido = agenda.remove(indice - 1);
            printLinha();
            System.out.println("Contato '" + removido.getNome() + "' removido com sucesso!");
            printLinha();
        } else {
            printLinha();
            System.out.println("Índice inválido. Nenhum contato foi removido.");
            printLinha();
        }
    }




    public static void procurarContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Digite o nome do contato: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size() ; i++) {
            if (procurar.equals(agenda.get(i).getNome())) {
                printLinha();
                System.out.println("Contato encontrado !!!");
                System.out.println(agenda.get(i).toString());
                printLinha();
                contatoEncontrado = true;
                break;
            }
            // equals() != "==" sao totalmente diferente
        }
        if (!contatoEncontrado){
            printLinha();
            System.out.println("Opss!! Contato nao encontradoo !!!");
            printLinha();
        }
    }

    public static void mostrarMenu() {
        System.out.println("===== Menu da Agenda de Contatos =====");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Listar Contatos");
        System.out.println("3. Buscar Contato");
        System.out.println("4. Remover Contato");
        System.out.println("5. Atualizar Contato");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void printLinha(){
        System.out.println("---------------------------------------------------");
    }

}

