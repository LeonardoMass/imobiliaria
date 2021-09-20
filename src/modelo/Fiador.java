package modelo;

public class Fiador {
	
	private String cpf;
	private String nome;
	private Double renda;
	private String ocupação;
	
	public Fiador(String cpf, String nome, Double renda, String ocupação) {
	
		this.cpf = cpf;
		this.nome = nome;
		this.renda = renda;
		this.ocupação = ocupação;
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

	public String getOcupação() {
		return ocupação;
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

	public void setOcupação(String ocupação) {
		this.ocupação = ocupação;
	}
	
	
	
	
	

}
