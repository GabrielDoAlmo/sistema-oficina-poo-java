package MecanicaDoZe.main;
import MecanicaDoZe.classe.OrdensDeServico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MecanicaDoZe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdensDeServico[] ordens = new OrdensDeServico[100];
        int contador = 0;
        boolean executando = true;

        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (executando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar nova Ordem de Servico");
            System.out.println("2. Listar IDs das Ordens em Aberto");
            System.out.println("3. Listar IDs das Ordens Concluidas");
            System.out.println("4. Imprimir Ordem de Servico por ID");
            System.out.println("5. Fechar Ordem de Servico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                if (contador < ordens.length) {
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();

                    String cpf;
                    while (true) {
                        System.out.print("CPF (somente numeros - 11 digitos): ");
                        cpf = scanner.nextLine();
                        if (cpf.matches("\\d{11}")) break;
                        System.out.println("CPF invalido! Digite exatamente 11 digitos numericos.");
                    }

                    System.out.print("Endereco: ");
                    String endereco = scanner.nextLine();

                    String telefone;
                    while (true) {
                        System.out.print("Telefone (somente numeros - 10 digitos): ");
                        telefone = scanner.nextLine();
                        if (telefone.matches("\\d{10}")) break;
                        System.out.println("Telefone invalido! Digite exatamente 10 digitos numericos.");
                    }

                    System.out.print("Descricao do Servico: ");
                    String descricao = scanner.nextLine();

                    double valor;
                    while (true) {
                        System.out.print("Valor do Servico (R$): ");
                        valor = scanner.nextDouble();
                        scanner.nextLine();
                        if (valor >= 0) break;
                        System.out.println("Valor invalido! O valor nao pode ser negativo.");
                    }

                    System.out.print("Data de Recebimento (dd-MM-aaaa): ");
                    LocalDate dataRecebimento = LocalDate.parse(scanner.nextLine(), formatoBrasileiro);

                    System.out.print("Data de Entrega Estimada (dd-MM-aaaa): ");
                    LocalDate dataEntrega = LocalDate.parse(scanner.nextLine(), formatoBrasileiro);

                    System.out.print("Servico Concluido? (true/false): ");
                    boolean concluido = scanner.nextBoolean();
                    scanner.nextLine();

                    OrdensDeServico novaOrdem = new OrdensDeServico(
                            nome, cpf, endereco, telefone,
                            descricao, valor, dataRecebimento, dataEntrega, concluido
                    );

                    ordens[contador] = novaOrdem;
                    contador++;

                    System.out.println("Ordem registrada com sucesso!");
                } else {
                    System.out.println("Capacidade maxima atingida!");
                }

            } else if (opcao == 2) {
                System.out.println("\n=== Ordens em Aberto ===");
                for (int i = 0; i < contador; i++) {
                    if (!ordens[i].isConcluido()) {
                        System.out.println("ID: " + ordens[i].getId());
                    }
                }

            } else if (opcao == 3) {
                System.out.println("\n=== Ordens Concluidas ===");
                for (int i = 0; i < contador; i++) {
                    if (ordens[i].isConcluido()) {
                        System.out.println("ID: " + ordens[i].getId());
                    }
                }

            } else if (opcao == 4) {
                System.out.print("Digite o ID da ordem: ");
                int idBusca = scanner.nextInt();
                scanner.nextLine();
                boolean encontrada = false;
                for (int i = 0; i < contador; i++) {
                    if (ordens[i].getId() == idBusca) {
                        ordens[i].exibirOrdem();
                        encontrada = true;
                        break;
                    }
                }
                if (!encontrada) {
                    System.out.println("Ordem de servico nao encontrada.");
                }

            } else if (opcao == 5) {
                System.out.print("Digite o ID da ordem a ser concluida: ");
                int idConcluir = scanner.nextInt();
                scanner.nextLine();
                boolean achou = false;
                for (int i = 0; i < contador; i++) {
                    if (ordens[i].getId() == idConcluir) {
                        ordens[i].setConcluido(true);
                        System.out.println("Ordem marcada como concluida.");
                        achou = true;
                        break;
                    }
                }
                if (!achou) {
                    System.out.println("Ordem nao encontrada.");
                }

            } else if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
                executando = false;

            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
