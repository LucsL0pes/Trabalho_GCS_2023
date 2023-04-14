import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private int id;
    private String nome;
    private String departamento;

    // Construtor
    public Funcionario(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }
}

public class SistemaSuporte {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Funcionario funcionarioLogado; // Funcionário logado no sistema

    public static void main(String[] args) {
        // Inicializar lista de funcionários (exemplo)
        funcionarios.add(new Funcionario(1, "João", "RH"));
        funcionarios.add(new Funcionario(2, "Maria", "Suporte"));
        funcionarios.add(new Funcionario(3, "Pedro", "Financeiro"));

        // Selecionar funcionário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() +
                    ", Nome: " + funcionario.getNome() +
                    ", Departamento: " + funcionario.getDepartamento());
        }
        System.out.print("Digite o ID do funcionário que está usando o sistema: ");
        int idFuncionario = scanner.nextInt();

        funcionarioLogado = buscarFuncionarioPorId(idFuncionario);
        if (funcionarioLogado != null) {
            System.out.println("Funcionário logado: " + funcionarioLogado.getNome());
            // Aqui você pode chamar as demais funcionalidades do sistema
        } else {
            System.out.println("Funcionário não encontrado. Encerrando o sistema...");
        }
        scanner.close();
    }

    // Método para buscar funcionário por ID
    private static Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }
}

