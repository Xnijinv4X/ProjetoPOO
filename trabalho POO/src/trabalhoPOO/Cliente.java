package trabalhoPOO;

public class Cliente {
	private String nome, cpf, email;
	private int codigo;
	
	public Cliente(String nome, String cpf, String email, int codigo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.codigo = codigo;
	}
	
	public Cliente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
