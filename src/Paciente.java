import java.util.ArrayList;

public class Paciente {
	int rfid;
    int idade;
    String nome;
    String doenca;
    ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public Paciente(int rfid, int idade, String nome, String doenca, Medicamento medicamento) {
        this.rfid = rfid;
        this.idade = idade;
        this.nome = nome;
        this.doenca = doenca;
        this.medicamentos.add(medicamento);
    }

    public int getRfid() {
        return this.rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDoenca() {
        return this.doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public void addMedicamentos(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }
}
