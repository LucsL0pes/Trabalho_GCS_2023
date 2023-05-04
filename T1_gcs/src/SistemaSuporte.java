import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class SistemaSuporte {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Chamado> chamados = new ArrayList<>();
    private static List<Equipamento> equipamentos = new ArrayList<>();
    private static Funcionario funcionarioLogado;

    public static void main(String[] args) {
        // Inicializar lista de funcionários, equipamentos e chamados (exemplo)
        
        Funcionario J = new Funcionario(1, "João", "RH");
        funcionarios.add(J);
        funcionarios.add(new Funcionario(2, "Maria", "Suporte"));
        funcionarios.add(new Funcionario(3, "Pedro", "Financeiro"));
        Equipamento E = new Equipamento(1, "Notebook", LocalDate.of(2020, 10, 15), "RH");
        equipamentos.add(E);
        equipamentos.add(new Equipamento(2, "Impressora", LocalDate.of(2021, 3, 28), "Suporte"));
        equipamentos.add(new Equipamento(3, "Mesa de escritório", LocalDate.of(2019, 7, 6), "RH"));
        chamados.add(new Chamado(1, J, "Computador-DESKTOP01", "Windows nao inicializa"));
        chamados.get(0).setFuncionarioAtendimento(funcionarios.get(1));

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

            for (Chamado chamado : chamados) {
                System.out.println("Lista de chamados:");
                if (chamado.getFuncionarioAbertura().equals(funcionarioLogado)) {
                    System.out.println(" ID: " + chamado.getId() +
                            ", data de abertura: " + chamado.getDataAbertura() + ", status: " + chamado.getStatus());
                }
            }
            
            System.out.println();
            boolean sair = false;

            while (!sair) {
                System.out.println("----------- MENU -----------");
                System.out.println("1) Abrir novo chamado");
                System.out.println("2) Atualizar status de chamado");
                System.out.println("3) Mover equipamento para outro setor");
                System.out.println("4) Pesquisar equipamentos por descrição");
                System.out.println("5) Listar chamados de um equipamento");
                System.out.println("6) Localizar chamados por palavra-chave");
                System.out.println("7) Visualizar painel de dados");
                System.out.println("8) Funcionalidade adicional 1");
                System.out.println("9) Funcionalidade adicional 2");
                System.out.println("0) Sair");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    
                    case 1:
                    //cria um novo chamado
                    try {
                    System.out.println("Informe o equipamento que necessita de suporte: ");
                    scanner.nextLine();
                    String equip = scanner.nextLine();
                    System.out.println("Informe a descricao do problema: ");
                    String desc = scanner.nextLine();

                    //o id cresce conforme a lista de chamados aumenta
                    int numChamado=chamados.size()+1;

                    //adiciona o novo chamado na lista total de chamados
                    Chamado novoChamado = new Chamado(numChamado, funcionarioLogado, equip, desc);
                    chamados.add(novoChamado);
                    System.out.println("Chamado aberto com sucesso!");
                    break;
                    }

                    catch (Exception e) {
                        System.out.println("nao foi possivel realizar a abertura do chamado");
                        break;
                    }
    
                    case 2:
                    if(funcionarioLogado.getDepartamento().equals("Suporte")){ 
                        System.out.println("Chamados em andamento: ");
                        for (Chamado chamado : chamados) {
                            if (chamado.getFuncionarioAtendimento().equals(funcionarioLogado) && chamado.getStatus().equals("Em andamento")) {
                                System.out.println(" ID: " + chamado.getId() +
                                        ", data de abertura: " + chamado.getDataAbertura() + ", status: " + chamado.getStatus());
                            }
                        }
                        
                        System.out.println("Digite qual chamado deseja atualizar: ");
                        int idChamado = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite a resolução");
                        String resolucao = scanner.nextLine();
                        Chamado chamadoAtualizado = buscarChamadoPorId(idChamado);
                        if(chamadoAtualizado != null) {
                            chamadoAtualizado.setStatusConcluido(resolucao);
                            System.out.println(" ID: " + chamadoAtualizado.getId() +
                            ", data de abertura: " + chamadoAtualizado.getDataAbertura() + ", status: " + chamadoAtualizado.getStatus() + ", resolucao: " + chamadoAtualizado.getResolucao());
                        } else {
                            System.out.println("ID não encontrado");
                        }
                    }
                    else{System.out.println("Voce nao possui permissão para atualizar status de chamado");}
                        break;
                    case 3:
                        // Mover equipamento para outro setor
                        if(funcionarioLogado.getDepartamento().equals("Suporte")){ 
                            System.out.println("Equipamentos disponiveis para mover de setor: ");
                            for (Equipamento equipamento : equipamentos) {
                                System.out.println("ID: " + equipamento.getIdentificador() +
                                        ", Descrição: " + equipamento.getDescricao() +
                                        ", Data de aquisição: " + equipamento.getDataAquisicao() + ", Setor: " + equipamento.getSetor());
                            }
                            
                            System.out.println("Digite qual equipamento deseja mover: ");
                            int identificador = scanner.nextInt();
                            scanner.nextLine();
                            Equipamento equipamentoAtualizado = buscarEquipamentoPorId(identificador);
                            if(equipamentoAtualizado != null) {
                                System.out.println("Informe o novo setor do equipamento: ");
                                String novoSetor = scanner.nextLine();
                                equipamentoAtualizado.setSetor(novoSetor);
                                System.out.println(" ID: " + equipamentoAtualizado.getIdentificador() +
                                ", Descrição: " + equipamentoAtualizado.getDescricao() +
                                ", Data de aquisição: " + equipamentoAtualizado.getDataAquisicao() + ", Setor: " + equipamentoAtualizado.getSetor());
                            } else {
                                System.out.println("ID não encontrado");
                            }
                        }
                        else{System.out.println("Voce nao possui permissão para mover equipamentos");}
                        break;
                    case 4:
                        // Pesquisar equipamentos por descrição
                        System.out.println("Digite a descrição do equipamento a ser pesquisado: ");
                        scanner.nextLine();
                        String descricao = scanner.nextLine();
                        Equipamento equipamentoEncontrado = buscarPorDescricao(descricao);
                        if (equipamentoEncontrado == null) {
                            System.out.println("Nenhum equipamento encontrado com a descrição " + descricao);
                        } else {
                        System.out.println("Equipamento encontrado:");
                        System.out.println("ID: " + equipamentoEncontrado.getIdentificador() +
                            ", Descrição: " + equipamentoEncontrado.getDescricao() +
                            ", Data de aquisição: " + equipamentoEncontrado.getDataAquisicao() +
                            ", Setor: " + equipamentoEncontrado.getSetor());
                        }
                        break;
                    case 5:
                        // Listar chamados de um equipamento
                        break;
                    case 6:
                        // Localizar chamados por palavra-chave
                        break;
                    case 7:
                        // Visualizar painel de dados
                        break;
                    case 8:
                        // Funcionalidade adicional 1
                        break;
                    case 9:
                        // Funcionalidade adicional 2
                        break;
                    case 0:
                        // Sair
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }
            }
        }
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
    private static Chamado buscarChamadoPorId (int id) {
        for (Chamado chamado: chamados) {
            if (chamado.getId() == id) {
                return chamado;
            }
        }
        return null;
    }

    // Método para buscar equipamento pela descricao
    private static Equipamento buscarPorDescricao (String descricao) {
        for (Equipamento equipamento: equipamentos) {
            if (equipamento.getDescricao().equals(descricao)) {
                return equipamento;
            }
        }
        return null;
    }

    public static Equipamento buscarEquipamentoPorId(int identificador) {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.getIdentificador() == identificador) {
                return equipamento;
            }
        }
        return null;
    }
}