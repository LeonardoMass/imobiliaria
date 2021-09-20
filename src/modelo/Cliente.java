package modelo;

public class Cliente {
	
	private String cpf,nome,telefone,data;

	public Cliente(String cpf, String nome, String telefone, String data) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.data = data;
	}
	public Cliente() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getData() {
		return data;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	

}
