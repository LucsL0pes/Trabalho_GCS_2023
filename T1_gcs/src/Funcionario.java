public class Funcionario {
    private int id;
    private String nome;
    private String departamento;

    // Construtor
    public Funcionario(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

    // Getters e Setters
    // ...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
