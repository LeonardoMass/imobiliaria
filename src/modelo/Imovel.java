package modelo;

public class Imovel {
	
	private int codigo;
	private String endereço, cpf_dono;
	
	public Imovel() {
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public String getEndereço() {
		return endereço;
	}

	public String getCpf_dono() {
		return cpf_dono;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public void setCpf_dono(String cpf_dono) {
		this.cpf_dono = cpf_dono;
	}
	
	
	

}
