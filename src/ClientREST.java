import java.io.IOException;
import java.util.Scanner;

public class ClientREST {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		Requests request = new Requests();
		int opc, opc2, opc3 = 0;
		do {
			System.out.print("##--Bem-vindo a nossa clinica--##\n\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("| Opção 1 - Listar Eventos    |\n");
			System.out.print("| Opção 2 - Medicamentos      |\n");
			System.out.print("| Opção 3 - Pacientes         |\n");
			System.out.print("| Opção 4 - Lista de Cuidados |\n");
			System.out.print("| Opção 5 - Clinicas          |\n");
			System.out.print("| Opção 6 - Listar Sensores   |\n");
			System.out.print("| Opção 0 - Sair              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("Digite uma opção: ");
			
			opc = Integer.parseInt(input.nextLine());
			
			switch(opc) {
				case 1: request.selecionarEventos(); break;
				case 2: {
					System.out.print("\n##--Medicamentos--##\n\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("| Opção 1 - Listar Medicamentos         |\n");
					System.out.print("| Opção 2 - Inserir Medicamentos        |\n");
					System.out.print("| Opção 3 - Editar Medicamentos         |\n");
					System.out.print("| Opção 4 - Remover Medicamentos        |\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("Digite uma opção: ");
					
					opc2 = Integer.parseInt(input.nextLine());
					
					switch(opc2) {
					case 1: request.selecionarMedicamento(); break;
					case 2: {
						System.out.println("Digite um ID: ");
						int idMedicamento = Integer.parseInt(input.nextLine());
						
						System.out.println("\nDigite um nome: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o Principio Ativo: ");
						String principioAtivo = input.nextLine();						
						
						request.insereMedicamento(idMedicamento, nomeMedicamento, principioAtivo);
					}; break;
					case 3: {
						System.out.print("##--Editar medicamento--##\n\n");
						System.out.println("Digite um ID: ");
						int idMedicamento = input.nextInt();
						
						System.out.println("\nDigite um nome: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o Principio Ativo: ");
						String principioAtivo = input.nextLine();
						
						request.atualizaMedicamento(idMedicamento, nomeMedicamento, principioAtivo);
					}; break;
					case 4: {
						System.out.print("##--Remover medicamento--##\n\n");
						System.out.println("Digite o ID do Medicamento: ");
						opc3 = input.nextInt();
						request.deletaMedicamento(opc3);
					}; break;
					}
				} break;
				case 3: {
					System.out.print("\n##--Pacientes--##\n\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("| Opção 1 - Listar Pacientes            |\n");
					System.out.print("| Opção 2 - Inserir Pacientes           |\n");
					System.out.print("| Opção 3 - Editar Pacientes            |\n");
					System.out.print("| Opção 4 - Remover Pacientes           |\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("Digite uma opção: ");
					
					opc2 = input.nextInt();
					
					switch(opc2) {
					case 1: request.selecionarPaciente(); break;
					case 2: {
						System.out.println("Digite um RFID para o paciente: ");
						int idPaciente = input.nextInt();
						
						System.out.println("\nDigite o nome do paciente: ");
						String nomePaciente = input.nextLine();
						
						System.out.println("\nDigite a idade do paciente: ");
						int idadePaciente = input.nextInt();	
						
						System.out.println("\nDigite a doenca do paciente: ");
						String doencaPaciente = input.nextLine();
						
						System.out.println("\nMedicamento: ");
						System.out.println("\nDigite o id do medicamento:  ");
						int idMedicamento = input.nextInt();
						
						System.out.println("\nDigite o nome do medicamento: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o principio ativo do medicamento: ");
						String principioAtivo = input.nextLine();
						
						Medicamento medicamento = new Medicamento(idMedicamento, nomeMedicamento, principioAtivo);
						
						request.inserePaciente(idPaciente, idadePaciente, nomePaciente, doencaPaciente, medicamento);
					}; break;
					case 3: {
						System.out.print("##--Editar Paciente--##\n\n");
						System.out.println("Digite o RFID do paciente: ");
						int idPaciente = input.nextInt();
						
						System.out.println("\nDigite o nome do paciente: ");
						String nomePaciente = input.nextLine();
						
						System.out.println("\nDigite a idade do paciente: ");
						int idadePaciente = input.nextInt();	
						
						System.out.println("\nDigite a doenca do paciente: ");
						String doencaPaciente = input.nextLine();
						
						System.out.println("\nMedicamento: ");
						System.out.println("\nDigite o id do medicamento:  ");
						int idMedicamento = input.nextInt();
						
						System.out.println("\nDigite o nome do medicamento: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o principio ativo do medicamento: ");
						String principioAtivo = input.nextLine();
						
						Medicamento medicamento = new Medicamento(idMedicamento, nomeMedicamento, principioAtivo);
						
						request.atualizaPaciente(idPaciente, idadePaciente, nomePaciente, doencaPaciente, medicamento);
					}; break;
					case 4: {
						System.out.print("##--Remover Paciente--##\n\n");
						System.out.println("Digite o RFID do Paciente: ");
						opc3 = input.nextInt();
						request.deletaPaciente(opc3);
					}; break;
				} 
				} break;
				case 4: {
					System.out.print("\n##--Lista de Cuidados--##\n\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("| Opção 1 - Lista de Cuidados           |\n");
					System.out.print("| Opção 2 - Inserir na Lista de Cuidados|\n");
					System.out.print("| Opção 3 - Editar da Lista de Cuidados |\n");
					System.out.print("| Opção 4 - Remover da Lista de Cuidados|\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("Digite uma opção: ");
					
					opc2 = input.nextInt();
					
					switch(opc2) {
					case 1: request.selecionarListaDeCuidado(); break;
					case 2: {
						System.out.println("Digite um ID: ");
						int id = input.nextInt();
						
						System.out.println("Digite o RFID do paciente: ");
						int idPaciente = input.nextInt();
						
						System.out.println("\nDigite o nome do paciente: ");
						String nomePaciente = input.nextLine();
						
						System.out.println("\nDigite a idade do paciente: ");
						int idadePaciente = input.nextInt();	
						
						System.out.println("\nDigite a doenca do paciente: ");
						String doencaPaciente = input.nextLine();
						
						Paciente paciente = new Paciente(idPaciente, idadePaciente, nomePaciente, doencaPaciente, null);
						
						System.out.println("\nDigite o tempo de aplicacao: ");
						int tempoAplicacao = input.nextInt();
						
						System.out.println("\nMedicamento: ");
						System.out.println("\nDigite o id do medicamento:  ");
						int idMedicamento = input.nextInt();
						
						System.out.println("\nDigite o nome do medicamento: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o principio ativo do medicamento: ");
						String principioAtivo = input.nextLine();
						
						Medicamento medicamento = new Medicamento(idMedicamento, nomeMedicamento, principioAtivo);
						
						request.insereListaDeCuidado(id, paciente, tempoAplicacao, medicamento);
					}; break;
					case 3: {
						System.out.print("##--Editar da Lista de Cuidados--##\n\n");
						System.out.println("Digite o ID: ");
						int id = input.nextInt();
						
						System.out.println("Digite o RFID do paciente: ");
						int idPaciente = input.nextInt();
						
						System.out.println("\nDigite o nome do paciente: ");
						String nomePaciente = input.nextLine();
						
						System.out.println("\nDigite a idade do paciente: ");
						int idadePaciente = input.nextInt();	
						
						System.out.println("\nDigite a doenca do paciente: ");
						String doencaPaciente = input.nextLine();
						
						Paciente paciente = new Paciente(idPaciente, idadePaciente, nomePaciente, doencaPaciente, null);
						
						System.out.println("\nDigite o tempo de aplicacao: ");
						int tempoAplicacao = input.nextInt();
						
						System.out.println("\nMedicamento: ");
						System.out.println("\nDigite o id do medicamento:  ");
						int idMedicamento = input.nextInt();
						
						System.out.println("\nDigite o nome do medicamento: ");
						String nomeMedicamento = input.nextLine();
						
						System.out.println("\nDigite o principio ativo do medicamento: ");
						String principioAtivo = input.nextLine();
						
						Medicamento medicamento = new Medicamento(idMedicamento, nomeMedicamento, principioAtivo);
						
						request.atualizaListaDeCuidado(id, paciente, tempoAplicacao, medicamento);
					}; break;
					case 4: {
						System.out.print("##--Remover da Lista de Cuidados--##\n\n");
						System.out.println("Digite o ID do Cuidado");
						opc3 = input.nextInt();
						request.deletaListaDeCuidado(opc3);
					}; break;
					}
				}; break;
				case 5: {
					System.out.print("\n##--Clinicas--##\n\n");
					System.out.print("|-----------------------------|\n");
					System.out.print("| Opção 1 - Listar Clinicas   |\n");
					System.out.print("| Opção 2 - Inserir Clinica   |\n");
					System.out.print("| Opção 3 - Editar Clinica    |\n");
					System.out.print("| Opção 4 - Remover Clinica   |\n");
					System.out.print("|-----------------------------|\n");
					System.out.print("Digite uma opção: ");
					
					opc2 = input.nextInt();
					
					switch(opc2) {
					case 1: request.selecionarClinica(); break;
					case 2: {
						System.out.println("Digite um ID: ");
						int id = input.nextInt();
						
						System.out.println("\nDigite o nome da Clinica: ");
						String nomeClinica = input.nextLine();
						
						System.out.println("\nDigite o endereco da Clinica: ");
						String enderecoClinica = input.nextLine();	
						
						System.out.println("\nDigite a cidade da Clinica: ");
						String cidadeClinica = input.nextLine();
						
						System.out.println("Digite o numero de pacientes: ");
						int numeroPacientes = input.nextInt();
						
						request.insereClinica(id, nomeClinica, enderecoClinica, cidadeClinica, numeroPacientes);
					}; break;
					case 3: {
						System.out.print("##--Editar Clinica--##\n\n");
						System.out.println("Digite o ID da Clinica: ");
						int id = input.nextInt();
						
						System.out.println("\nDigite o nome da Clinica: ");
						String nomeClinica = input.nextLine();
						
						System.out.println("\nDigite o endereco da Clinica: ");
						String enderecoClinica = input.nextLine();	
						
						System.out.println("\nDigite a cidade da Clinica: ");
						String cidadeClinica = input.nextLine();
						
						System.out.println("Digite o numero de pacientes: ");
						int numeroPacientes = input.nextInt();
						
						request.atualizaClinica(id, nomeClinica, enderecoClinica, cidadeClinica, numeroPacientes);
					}; break;
					case 4: {
						System.out.print("##--Remover Clinica--##\n\n");
						System.out.println("Digite o ID da Clinica: ");
						opc3 = input.nextInt();
						request.deletaClinica(opc3);
					}; break;
					}
				}; break;
				case 6: { 
					System.out.print("\n##--Inserir Sensor--##\n\n");

					System.out.println("Digite o ID do Sensor: ");
					int id = input.nextInt();
					
					System.out.println("Digite o tipo do Sensor (0 - Pressao | 1 - Presenca): ");
					int tipoSensor = input.nextInt();
					
					request.insereSensor(id, tipoSensor);
				}; break;
			}
		}while (opc != 0);
		System.out.println("Programa terminado!");
		input.close();
		}
	}
