public class Medicamento {
	int id;
    String nome;
    String principioAtivo;

    public Medicamento(int id, String nome, String principioAtivo) {
        this.id = id;
        this.nome = nome;
        this.principioAtivo = principioAtivo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return this.principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }
}
