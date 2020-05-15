public class ListaDeCuidado {
    private int id;
    Paciente paciente;
    int tempoDeAplicacao;
    Medicamento medicamento; // Quantidade em dias

    public ListaDeCuidado(int id, Paciente paciente,int tempoDeAplicacao,Medicamento medicamento)
    {
        this.id = id;
        this.paciente = paciente;
        this.tempoDeAplicacao = tempoDeAplicacao;
        this.medicamento = medicamento;
    }
    
    public ListaDeCuidado(int id)
    {
        this.id = id;
    }
    
    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medicamento getMedicamento() {
        return this.medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getTempoDeAplicacao() {
        return this.tempoDeAplicacao;
    }

    public void setTempoDeAplicacao(int tempoDeAplicacao) {
        this.tempoDeAplicacao = tempoDeAplicacao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
