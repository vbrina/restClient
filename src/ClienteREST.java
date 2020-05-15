import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		URL url = new URL("http://localhost:8080/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int opc, opc2, opc3 = 0;
		do {
			System.out.print("##--Bem-vindo a nossa clinica--##\n\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("| Opção 1 - Eventos           |\n");
			System.out.print("| Opção 2 - Medicamentos      |\n");
			System.out.print("| Opção 3 - Pacientes         |\n");
			System.out.print("| Opção 4 - Lista de Cuidados |\n");
			System.out.print("| Opção 5 - Clinicas          |\n");
			System.out.print("| Opção 6 - Listar Sensores   |\n");
			System.out.print("| Opção 0 - Sair              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("Digite uma opção: ");
			
			opc = input.nextInt();
			
			switch(opc) {
				case 1: {
					System.out.print("\n##--Eventos--##\n\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("| Opção 1 - Listar Eventos              |\n");
					System.out.print("| Opção 2 - Eventos de sensor especifico|\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("Digite uma opção: ");
					opc2 = input.nextInt();
					
					switch(opc2) {
						case 1: selecionarEventos(); break;
						case 2: {
							System.out.print("##--Eventos de sensor especifico--##\n\n");
							System.out.print("|------------------------------|\n");
							System.out.print("| Opção 1 - Sensor de Pressao  |\n");
							System.out.print("| Opção 2 - Sensor de Presenca |\n");
							System.out.print("|------------------------------|\n");
							System.out.print("Digite uma opção: ");
							opc3 = input.nextInt();
							
							switch(opc3) {
								case 1: System.out.println("listarEventosSensorPressao()\n\n"); break;
								case 2: System.out.println("listarEventosSensorPresenca()\n\n"); break;
							}
						}
					}
				} break;
				case 2: {
					System.out.print("\n##--Medicamentos--##\n\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("| Opção 1 - Listar Medicamentos         |\n");
					System.out.print("| Opção 2 - Inserir Medicamentos        |\n");
					System.out.print("| Opção 3 - Editar Medicamentos         |\n");
					System.out.print("| Opção 4 - Remover Medicamentos        |\n");
					System.out.print("|---------------------------------------|\n");
					System.out.print("Digite uma opção: ");
					
					opc2 = input.nextInt();
					
					switch(opc2) {
					case 1: selecionarMedicamento(); break;
					case 2: insereMedicamento(); break;
					case 3: {
						System.out.print("##--Editar medicamento--##\n\n");
						System.out.println("Digite o ID do Medicamento");
						opc3 = input.nextInt();
						atualizaMedicamento();
					}; break;
					case 4: {
						System.out.print("##--Remover medicamento--##\n\n");
						System.out.println("Digite o ID do Medicamento");
						opc3 = input.nextInt();
						deletaMedicamento(opc3);
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
					case 1: selecionarPaciente(); break;
					case 2: inserePaciente(); break;
					case 3: {
						System.out.print("##--Editar Paciente--##\n\n");
						System.out.println("Digite o ID do Paciente");
						opc3 = input.nextInt();
						atualizaPaciente();
					}; break;
					case 4: {
						System.out.print("##--Remover Paciente--##\n\n");
						System.out.println("Digite o ID do Paciente");
						opc3 = input.nextInt();
						deletaPaciente(opc3);
					}; break;
					}
				}; break;
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
					case 1: selecionarListaDeCuidado(); break;
					case 2: insereListaDeCuidado(); break;
					case 3: {
						System.out.print("##--Editar da Lista de Cuidados--##\n\n");
						System.out.println("Digite o ID do Cuidado");
						opc3 = input.nextInt();
						atualizaListaDeCuidado();
					}; break;
					case 4: {
						System.out.print("##--Remover da Lista de Cuidados--##\n\n");
						System.out.println("Digite o ID do Cuidado");
						opc3 = input.nextInt();
						deletaListaDeCuidado(opc3);
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
					case 1: selecionarClinica(); break;
					case 2: insereClinica(); break;
					case 3: {
						System.out.print("##--Editar Clinica--##\n\n");
						System.out.println("Digite o ID da Clinica");
						opc3 = input.nextInt();
						atualizaClinica();
					}; break;
					case 4: {
						System.out.print("##--Remover Clinica--##\n\n");
						System.out.println("Digite o ID da Clinica");
						opc3 = input.nextInt();
						deletaClinica(opc3);
					}; break;
					}
				}; break;
				case 6: { 
					System.out.print("\n##--Listar Sensores--##\n\n");
					System.out.println("listarSensores()\n\n");
				}; break;
			}
		}while (opc != 0);
		System.out.println("Programa terminado!");
		input.close();
		}
	}
