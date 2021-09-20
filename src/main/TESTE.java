package main;
import java.sql.Connection;

import java.util.List;
import java.util.Scanner;
import DAO.ConexaoBD;
import DAO.ImobiliariaDAO;
import modelo.Cliente;
import modelo.Imovel;



public class TESTE {

	public static void main(String[] args)  throws Exception {
		int n = -1;
		Scanner tec = new Scanner(System.in);
		
		
		do {
		
			if (n == 1) {
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				ImovelD.listarTodos();
				conexao.close();
				
			}
			if (n == 2 ) {
				
				
				System.out.print("Digite uma cidade: ");
				tec.nextLine();
				String buscar = tec.nextLine();
				
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				
				List<Imovel> Imovelbd = ImovelD.buscarCidade(buscar);
				
				if(Imovelbd.isEmpty()) {
					System.out.println("\nNenhum imovel nesta cidade");
					}else {
						System.out.format("\n %6s %22s ", "Codigo", "Endereço");
						System.out.format("\n ----------------------------------------------------------------------------------");
						for (int i=0;i < Imovelbd.size();i++) {
							System.out.format("\n %4s %40s", Imovelbd.get(i).getCodigo(), Imovelbd.get(i).getEndereço());
						}
				}
				conexao.close();
			}
			if (n == 3) {
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				ImovelD.listarImovelNome();
				conexao.close();
			}
			if (n == 4) {
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				ImovelD.listarClienteFiador();
				conexao.close();
			}
			if (n == 5) {
				System.out.print("Digite a profissão: ");
				tec.nextLine();
				String buscar = tec.nextLine();
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				
				List<Cliente> listaFiador = ImovelD.buscarFiadorOcu(buscar);
				
				
				if(listaFiador.isEmpty()) {
					System.out.println("Nenhuma ocupação  de "+buscar+" entre os fiadores");
				}else {
						System.out.println( "\n   Nome     "+ "       CPF");
						System.out.format("----------------------------------------------------------------------------------");
						for (int i = 0;i < listaFiador.size(); i++) {
							System.out.format("\n %4s %10s", listaFiador.get(i).getNome(), listaFiador.get(i).getCpf());
						}
				 }
				conexao.close();
			}
			if (n == 6) {
				Connection conexao = new ConexaoBD().obterConexaoBD();		
				ImobiliariaDAO ImovelD = new ImobiliariaDAO(conexao);
				ImovelD.listarFiadorOcu();
				conexao.close();
			}
		
			
			
			System.out.println();
			System.out.println("\nDigite o numero do comando que deseja: \n"
					+" 1 - Listar os imoveis.\n"
					+" 2 - Buscar imoveis por cidade.\n"
					+" 3 - Listar imoveis ordenados por nome do dono.\n"
					+" 4 - Listar CPF de fiador com renda maior que 4000.\n"
					+" 5 - Buscar fiadores por ocupação.\n"
					+" 6 - Listar Total entre ocupações dos fiadores.\n"
					+" 0 - Sair.\n");
					n = tec.nextInt();
			
		}while (n != 0);
	}

}
