import java.time.LocalDate;

public class Equipamento {
    private int identificador;
    private String descricao;
    private LocalDate dataAquisicao;
    private String setor;

    public Equipamento(int identificador, String descricao, LocalDate dataAquisicao, String setor) {
        this.identificador = identificador;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.setor = setor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public String getSetor() {
        return setor;
    }

    public void setId(int identificador) {
        this.identificador = identificador;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}