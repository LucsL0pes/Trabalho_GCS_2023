import java.time.LocalDate;

class Chamado {
    private int id;
    private Funcionario funcionarioAbertura;
    private Equipamento equipamento;
    private LocalDate dataAbertura;
    private String descricao;
    private String status;
    private Funcionario funcionarioAtendimento;
    private LocalDate dataConclusao;
    private String resolucao;

    // Construtor
    public Chamado(int id, Funcionario funcionarioAbertura, Equipamento equipamento, String descricao) {
        this.id = id;
        this.funcionarioAbertura = funcionarioAbertura;
        this.equipamento = equipamento;
        this.descricao = descricao;
        this.status = "Aberto"; // Status inicial é "Aberto"
        this.dataAbertura = LocalDate.now(); // Data de abertura é a data atual
    }

    // Getters e Setters
    // ...

    public Funcionario getFuncionarioAbertura() {
        return funcionarioAbertura;
    }

    public void setFuncionarioAbertura(Funcionario funcionarioAbertura) {
        this.funcionarioAbertura = funcionarioAbertura;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionarioAtendimento() {
        return funcionarioAtendimento;
    }

    public void setFuncionarioAtendimento(Funcionario funcionarioAtendimento) {
        this.funcionarioAtendimento = funcionarioAtendimento;
        this.status = "Em andamento";
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método para mudar o status do chamado para "Em andamento"
    public void setStatusEmAndamento(Funcionario funcionarioAtendimento) {
        this.status = "Em andamento";
        this.funcionarioAtendimento = funcionarioAtendimento;
    }

    // Método para mudar o status do chamado para "Concluído"
    public void setStatusConcluido(String resolucao) {
        this.status = "Concluído";
        this.dataConclusao = LocalDate.now(); // Data de conclusão é a data atual
        this.resolucao = resolucao;
    }

    public String getInfoBusca() {
        return this.funcionarioAbertura.getNome() + " " +
               this.equipamento.getDescricao() + " " +
               this.equipamento.getSetor() + " " +
               this.descricao + " " +
               this.resolucao;
    }
    

    public String toString() {
        String chamadoString = "ID: " + this.id + "\n";
        chamadoString += "Funcionário de abertura: " + this.funcionarioAbertura.getNome() + "\n";
        chamadoString += "Equipamento: " + this.equipamento.getDescricao() + "\n";
        chamadoString += "Data de abertura: " + this.dataAbertura + "\n";
        chamadoString += "Descrição: " + this.descricao + "\n";
        chamadoString += "Status: " + this.status + "\n";
        if (this.funcionarioAtendimento != null) {
            chamadoString += "Funcionário de atendimento: " + this.funcionarioAtendimento.getNome() + "\n";
        }
        if (this.dataConclusao != null) {
            chamadoString += "Data de conclusão: " + this.dataConclusao + "\n";
            chamadoString += "Resolução: " + this.resolucao + "\n";
        }
        return chamadoString;
    }
}
