package trabalhoPOO;

public class Livro {
	private String titulo, autor, genero;
	private int edicao;
	private String codigo;
	private boolean status, reservado;
	
	public Livro(String titulo, String autor, String genero, int edicao, String codigo, boolean status, boolean reservado) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.edicao = edicao;
		this.status = status;
		this.reservado = reservado;
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isReservado() {
		return reservado;
	}
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	public Livro() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
