public class Sensor {
	int id;
    int tipoSensor;// 0 - Pressão, 1 - Presença

    public Sensor(int id, int tipoSensor) {
        this.id = id;
        this.tipoSensor = tipoSensor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoSensor() {
        return this.tipoSensor;
    }

    public void setTipoSensor(int tipoSensor) {
        this.tipoSensor = tipoSensor;
    }
}
