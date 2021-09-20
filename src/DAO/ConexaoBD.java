package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	public Connection obterConexaoBD() throws Exception {
		
	    String myDriver = "com.mysql.cj.jdbc.Driver";

	    String bancoUrl = "jdbc:mysql://127.0.0.1/imobiliaria?useTimezone=true&serverTimezone=UTC";
	    String bancoLogin = "root";
	    String bancoSenha = "Macaco123";
	    
	    Class.forName(myDriver);
	    
	    Connection conexao = DriverManager.getConnection(bancoUrl, bancoLogin, bancoSenha);
		
	    return conexao;
		
	}
	
}
