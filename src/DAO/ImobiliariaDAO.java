package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Imovel;



public class ImobiliariaDAO  {
	
	private Connection conexao;
	
	public ImobiliariaDAO(Connection conexao) throws Exception{
		
		this.conexao = conexao;
	}
	Scanner tec = new Scanner(System.in);
	
	public void listarTodos() throws Exception {
		
		String query = "SELECT codigo, endereco, cpf_dono FROM imovel ORDER BY codigo ASC";
		PreparedStatement st = this.conexao.prepareStatement( query );
		//PASSO 4: Executar a query (neste caso de alteração é um executeUpdate)		
		ResultSet rs = st.executeQuery(query);
		
	    System.out.format("\n %6s %22s %35s ", "Codigo", "Endereço", " CPF do dono");
			System.out.format("\n ----------------------------------------------------------------------------------");
			
	    while (rs.next()){
	    	
	    	Imovel imovelTemp = new Imovel();	    	
	    	
	    	imovelTemp.setCodigo( rs.getInt("codigo") );
	    	imovelTemp.setEndereço( rs.getString("endereco") );
	    	imovelTemp.setCpf_dono( rs.getString("cpf_dono") );
	    	System.out.format("\n %4s %40s %20s",imovelTemp.getCodigo(),imovelTemp.getEndereço(),imovelTemp.getCpf_dono());
	    }
	    
	    rs.close();
	    st.close();   
	}
	
	public List<Imovel> buscarCidade(String buscar) throws Exception {
		
		ArrayList <Imovel> listaImovel = new ArrayList();
		
		String query = "SELECT codigo,endereco FROM imovel WHERE endereco LIKE ?";
		PreparedStatement st = this.conexao.prepareStatement( query );
		 st.setString(1, "%"+buscar+"%");
		ResultSet rs = st.executeQuery();
	
		while(rs.next()) { 
			
			Imovel imovelTemp = new Imovel();
			
			imovelTemp.setCodigo(  rs.getInt("codigo"));
	    	imovelTemp.setEndereço( rs.getString("endereco"));
	    	listaImovel.add(imovelTemp);
		}
	    rs.close();
	    st.close();  
	    return listaImovel;
	}
	
	public void listarImovelNome() throws Exception {
		
		String query = "SELECT cliente.nome, imovel.codigo, imovel.endereco FROM cliente JOIN imovel ON cliente.cpf = imovel.cpf_dono ORDER BY cliente.nome ASC";
		PreparedStatement st = this.conexao.prepareStatement( query );
		//PASSO 4: Executar a query (neste caso de alteração é um executeUpdate)		
		ResultSet rs = st.executeQuery(query);
		
	    System.out.println( "\n   Nome do dono        "+ "  Codigo"+ "       Endereço");
			System.out.format("----------------------------------------------------------------------------------");
			
	    while (rs.next()){
	    	
	    	Imovel imovelTemp = new Imovel();	    
	    	Cliente clienteTemp = new Cliente();
	    	
	      	clienteTemp.setNome( rs.getString("cliente.nome") );
	    	imovelTemp.setCodigo( rs.getInt("imovel.codigo") );
	    	imovelTemp.setEndereço( rs.getString("imovel.endereco") );
	  
	    	System.out.format("\n %4s %15s %40s",clienteTemp.getNome(),imovelTemp.getCodigo(),imovelTemp.getEndereço());
	    }
	    
	    rs.close();
	    st.close();   
	}
	public void listarClienteFiador() throws Exception {
		
		
		// apenas clientes que tem contrato como fiador
		//String query = ("SELECT cliente.nome , cliente.cpf FROM cliente  inner JOIN contrato on cliente.cpf = contrato.cpf_fiador inner join fiador on cliente.cpf = fiador.cpf where fiador.renda >4000");
				
		// apenas cliente que são fiadores 
		String query = ("SELECT cliente.nome , cliente.cpf FROM cliente JOIN fiador on cliente.cpf = fiador.cpf where fiador.renda > 4000");
		PreparedStatement st = this.conexao.prepareStatement( query );		
		ResultSet rs = st.executeQuery(query);
		
	    System.out.println( "\n   Nome     "+ "       CPF");
			System.out.format("----------------------------------------------------------------------------------");
			
	    while (rs.next()){
	    		    
	    	Cliente clienteTemp = new Cliente();
	    	
	      	clienteTemp.setNome( rs.getString("cliente.nome") );
	    	clienteTemp.setCpf ( rs.getString("cliente.cpf") );
	  
	    	System.out.format("\n %4s %15s",clienteTemp.getNome(),clienteTemp.getCpf());
	    }
	    
	    rs.close();
	    st.close();   
	}
	
	public List<Cliente> buscarFiadorOcu(String buscar) throws Exception {
		
		ArrayList <Cliente> listaFiador = new ArrayList();
		
		// apenas clientes que tem contratos como fiador
		//String query = ("SELECT cliente.nome , cliente.cpf FROM cliente  inner JOIN contrato on cliente.cpf = contrato.cpf_fiador inner join fiador on cliente.cpf = fiador.cpf where fiador.ocupacao like ?");
		
		// apenas cliente que são fiadores 
		String query = ("SELECT cliente.nome , cliente.cpf FROM cliente JOIN fiador on cliente.cpf = fiador.cpf where ocupacao like ?");
		
		
		PreparedStatement st = this.conexao.prepareStatement( query );
		 st.setString(1, "%"+buscar+"%");
		ResultSet rs = st.executeQuery();
		
	  
			
	    while (rs.next()){
	    	   
	    	Cliente clienteTemp = new Cliente();
	    	
	      	clienteTemp.setNome( rs.getString("cliente.nome") );
	    	clienteTemp.setCpf ( rs.getString("cliente.cpf") );
	    	listaFiador.add(clienteTemp);
	
	    }
	    	
	   
	    
	    rs.close();
	    st.close(); 
	    return listaFiador;
	}
	
	public void listarFiadorOcu() throws Exception {
		
		String query = "SELECT ocupacao, count(*) FROM fiador GROUP BY ocupacao";
		PreparedStatement st = this.conexao.prepareStatement( query );		
		ResultSet rs = st.executeQuery(query);
		
	    System.out.println( "\n  Total    "+ " Ocupação ");
			System.out.format("----------------------------------------------------------------------------------");
			
	    while (rs.next()){
	    	
	    	String ocup =  rs.getString("ocupacao") ;
	    	int i = rs.getInt("count(*)") ;
	    	
	  
	    	System.out.format("\n %4s %15s ",i ,ocup);
	    }
	    
	    rs.close();
	    st.close();   
	}
	
	
	
}