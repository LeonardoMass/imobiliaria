package modelo;

public class Imovel {
	
	private int codigo;
	private String enderešo, cpf_dono;
	
	public Imovel() {
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public String getEnderešo() {
		return enderešo;
	}

	public String getCpf_dono() {
		return cpf_dono;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}

	public void setCpf_dono(String cpf_dono) {
		this.cpf_dono = cpf_dono;
	}
	
	
	

}
