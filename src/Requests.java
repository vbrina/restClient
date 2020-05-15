import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Requests{
	
	// -------------- GET -------------- //
	
	public void selecionarEventos() throws IOException {
		URL url = new URL("http://localhost:8080/eventos");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
		Gson gson = new Gson();
		
		InputStream in = con.getInputStream();
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		Evento[] eventos = gson.fromJson(reader, Evento[].class);
		
		for(int i=0; i < eventos.length; i++) {
			System.out.println("Data: " + eventos[i].getData()+ "\n");
			System.out.println("Hora: " + eventos[i].getHora()+ "\n");
			System.out.println("ID Sensor: " + eventos[i].getIdSensor()+ "\n");
			System.out.println("Tipo Sensor: " + eventos[i].getTipoSensor()+ "\n");
			System.out.println("Valor Lido: " + eventos[i].getValorLido() + "\n");
		}
		
		con.getResponseCode();
	}
	
	public void selecionarMedicamento() throws IOException {
		URL url = new URL("http://localhost:8080/medicamento");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
		Gson gson = new Gson();
		
		InputStream in = con.getInputStream();
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		Medicamento[] medicamentos = gson.fromJson(reader, Medicamento[].class);
		
		for(int i=0; i < medicamentos.length; i++) {
			System.out.println("ID: " + medicamentos[i].getId()+ "\n");
			System.out.println("Nome: " + medicamentos[i].getNome()+ "\n");
			System.out.println("Principio Ativo: " + medicamentos[i].getPrincipioAtivo() + "\n");
			
		}
		
		con.getResponseCode();
	}
	
	public void selecionarPaciente() throws IOException {
		URL url = new URL("http://localhost:8080/paciente");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
		Gson gson = new Gson();
		
		InputStream in = con.getInputStream();
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		Paciente[] pacientes = gson.fromJson(reader, Paciente[].class);
		
		for(int i=0; i < pacientes.length; i++) {
			System.out.println("RFID: " + pacientes[i].getRfid() + "\n");
			System.out.println("Nome: " + pacientes[i].getNome() + "\n");
			System.out.println("Idade: " + pacientes[i].getIdade() + "\n");
			System.out.println("Doenca: " + pacientes[i].getDoenca() + "\n");
			System.out.println("Medicamentos: " + pacientes[i].getMedicamentos() + "\n");
		}
		
		con.getResponseCode();
	}
	
	public void selecionarListaDeCuidado() throws IOException {
		URL url = new URL("http://localhost:8080/ListaDeCuidado");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
		Gson gson = new Gson();
		
		InputStream in = con.getInputStream();
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		ListaDeCuidado[] listaDeCuidado = gson.fromJson(reader, ListaDeCuidado[].class);
		
		for(int i=0; i < listaDeCuidado.length; i++) {
			System.out.println("ID: " + listaDeCuidado[i].getId() + "\n");
			System.out.println("Paciente: " + listaDeCuidado[i].getPaciente() + "\n");
			System.out.println("Tempo de Aplicacao: " + listaDeCuidado[i].getTempoDeAplicacao() + "\n");
			System.out.println("Medicamento: " + listaDeCuidado[i].getMedicamento() + "\n");
		}
		
		con.getResponseCode();
	}
	
	public void selecionarClinica() throws IOException {
		URL url = new URL("http://localhost:8080/clinica");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
		Gson gson = new Gson();
		
		InputStream in = con.getInputStream();
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		Clinica[] clinica = gson.fromJson(reader, Clinica[].class);
		
		for(int i=0; i < clinica.length; i++) {
			System.out.println("ID: " + clinica[i].getId() + "\n");
			System.out.println("Nome: " + clinica[i].getNome() + "\n");
			System.out.println("Endereco: " + clinica[i].getEndereco() + "\n");
			System.out.println("Cidade: " + clinica[i].getCidade() + "\n");
			System.out.println("Numero de pacientes: " + clinica[i].getNoPaciente() + "\n");
		}
		
		con.getResponseCode();
	}
	
	// -------------- POST -------------- //
	
	public void insereMedicamento(int id, String nome, String principioAtivo) throws IOException {
		URL url = new URL("http://localhost:8080/medicamento");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Medicamento medicamento = new Medicamento(id, nome, principioAtivo);
		Gson gson = new Gson();
		String json = gson.toJson(medicamento);
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void inserePaciente(int rfid, int idade, String nome, String doenca, Medicamento medicamento) throws IOException {
		URL url = new URL("http://localhost:8080/paciente");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Paciente paciente = new Paciente(rfid, idade, nome, doenca, medicamento);
		Gson gson = new Gson();
		String json = gson.toJson(paciente);
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void insereListaDeCuidado(int id, Paciente paciente, int tempoDeAplicacao, Medicamento medicamento) throws IOException {
		URL url = new URL("http://localhost:8080/ListaDeCuidado");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		ListaDeCuidado listaDeCuidado = new ListaDeCuidado(id, paciente, tempoDeAplicacao, medicamento);
		Gson gson = new Gson();
		String json = gson.toJson(listaDeCuidado);
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}

	public void insereClinica(int id, String nome, String endereco, String cidade, int numeroPacientes) throws IOException {
		URL url = new URL("http://localhost:8080/clinica");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Clinica clinica = new Clinica(id, nome, endereco, cidade, numeroPacientes);
		Gson gson = new Gson();
		String json = gson.toJson(clinica);
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void insereSensor(int id, int tipoSensor) throws IOException {
		URL url = new URL("http://localhost:8080/sensor");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Sensor sensor = new Sensor(id, tipoSensor);
		Gson gson = new Gson();
		String json = gson.toJson(sensor);
		
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	// -------------- PUT -------------- //
	
	public void atualizaMedicamento(int id, String nome, String principioAtivo) throws IOException{
		URL url = new URL("http://localhost:8080/medicamento");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Medicamento medicamento = new Medicamento(id, nome, principioAtivo);
		Gson gson = new Gson();
		String json = gson.toJson(medicamento);
		
		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void atualizaPaciente(int rfid, int idade, String nome, String doenca, Medicamento medicamento) throws IOException{
		URL url = new URL("http://localhost:8080/paciente");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Paciente paciente = new Paciente(rfid, idade, nome, doenca, medicamento);
		Gson gson = new Gson();
		String json = gson.toJson(paciente);
		
		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void atualizaListaDeCuidado(int id, Paciente paciente, int tempoDeAplicacao, Medicamento medicamento) throws IOException {
		URL url = new URL("http://localhost:8080/ListaDeCuidado");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		ListaDeCuidado listaDeCuidado = new ListaDeCuidado(id, paciente, tempoDeAplicacao, medicamento);
		Gson gson = new Gson();
		String json = gson.toJson(listaDeCuidado);
		
		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	public void atualizaClinica(int id, String nome, String endereco, String cidade, int numeroPacientes) throws IOException {
		URL url = new URL("http://localhost:8080/clinica");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		Clinica clinica = new Clinica(id, nome, endereco, cidade, numeroPacientes);
		Gson gson = new Gson();
		String json = gson.toJson(clinica);
		
		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		
		OutputStream out = con.getOutputStream();
		out.write(json.getBytes());
		
		con.getResponseCode();
	}
	
	// -------------- DELETE -------------- //
	
	public void deletaMedicamento(int id) throws IOException {
		URL url = new URL("http://localhost:8080/medicamento/"+id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("DELETE");
		con.getResponseCode();
	}
	
	public void deletaPaciente(int id) throws IOException {
		URL url = new URL("http://localhost:8080/medicamento/"+id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("DELETE");
		con.getResponseCode();
	}
	
	public void deletaListaDeCuidado(int id) throws IOException {
		URL url = new URL("http://localhost:8080/ListaDeCuidado/"+id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("DELETE");
		con.getResponseCode();
	}
	
	public void deletaClinica(int id) throws IOException {
		URL url = new URL("http://localhost:8080/clinica/"+id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("DELETE");
		con.getResponseCode();
	}
}
