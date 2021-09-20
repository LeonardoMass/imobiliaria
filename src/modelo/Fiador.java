package modelo;

public class Fiador {
	
	private String cpf;
	private String nome;
	private Double renda;
	private String ocupa��o;
	
	public Fiador(String cpf, String nome, Double renda, String ocupa��o) {
	
		this.cpf = cpf;
		this.nome = nome;
		this.renda = renda;
		this.ocupa��o = ocupa��o;
	}
	public Fiador() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Double getRenda() {
		return renda;
	}

	public String getOcupa��o() {
		return ocupa��o;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public void setOcupa��o(String ocupa��o) {
		this.ocupa��o = ocupa��o;
	}
	
	
	
	
	

}
