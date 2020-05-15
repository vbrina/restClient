public class Evento {
	String data;
    int idSensor;
    String hora;
    int tipoSensor; // 0 - Pressão, 1 - Presença
    int valorLido;
    // Se tipoSensor == 0, valorLido = 0 - Não há ninguém na cama, 1 - Há alguém na
    // cama.
    // Se tipoSensor == 1, valorLido = RFID da pessoa.

    public Evento(String data, int idSensor, String hora, int tipoSensor, int valorLido) {
        this.data = data;
        this.hora = hora;
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.valorLido = valorLido;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdSensor() {
        return this.idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public int getTipoSensor() {
        return this.tipoSensor;
    }

    public void setTipoSensor(int tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public int getValorLido() {
        return this.valorLido;
    }

    public void setValorLido(int valorLido) {
        this.valorLido = valorLido;
    }
}
