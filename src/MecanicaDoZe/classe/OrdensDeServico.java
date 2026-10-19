package MecanicaDoZe.classe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdensDeServico {
    private static int proximoId = 1;

    private final int id;
    private final String nomeCliente;
    private final String cpf;
    private final String endereco;
    private final String telefone;
    private final String descricaoServico;
    private final double valor;
    private final LocalDate dataRecebimento;
    private final LocalDate dataEntregaEstimada;
    private boolean concluido;

    public OrdensDeServico(String nomeCliente, String cpf, String endereco, String telefone,
                           String descricaoServico, double valor, LocalDate dataRecebimento,
                           LocalDate dataEntregaEstimada, boolean concluido) {
        this.id = proximoId++;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.descricaoServico = descricaoServico;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataEntregaEstimada = dataEntregaEstimada;
        this.concluido = concluido;
    }

    public int getId() {
        return id;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void exibirOrdem() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("ID: " + id);
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereco: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Descricao do Servico: " + descricaoServico);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data de Recebimento: " + dataRecebimento.format(formato));
        System.out.println("Data de Entrega Estimada: " + dataEntregaEstimada.format(formato));
        System.out.println("Concluido: " + (concluido ? "Sim" : "Nao"));
        System.out.println("---------------------------------------------------");
    }
}
