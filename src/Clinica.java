public class Clinica {
	int id;
    String nome;
    String endereco;
    String cidade;
    int noPaciente;

    public Clinica(int id, String nome, String endereco, String cidade, int noPaciente) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.noPaciente = noPaciente;
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

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNoPaciente() {
        return this.noPaciente;
    }

    public void setNoPaciente(int noPaciente) {
        this.noPaciente = noPaciente;
    }
}
