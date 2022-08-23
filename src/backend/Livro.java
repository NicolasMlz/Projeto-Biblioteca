package backend;

public class Livro {
	
	//ATRIBUTOS
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private int edicao;
	private String genero;
	private int qtdeTotal;
	private int qtdeDisponiveis;
	
	//CONSTRUTORES
	public Livro(Long id, String titulo, String autor, String editora, int edicao, String genero, int qtdeTotal,
			int qtdeDisponiveis) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.genero = genero;
		this.qtdeTotal = qtdeTotal;
		this.qtdeDisponiveis = qtdeDisponiveis;
	}
	public Livro(Long id, String titulo, String autor, String editora, int edicao, String genero, int qtdeTotal) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.genero = genero;
		this.qtdeTotal = qtdeTotal;
		this.qtdeDisponiveis = qtdeTotal;
	}
	
	//METODOS
	void atualizarQtde(int qtde) {
		this.qtdeTotal += qtde;
	}
	@Override
	public String toString() {
		return "Titulo: " + titulo + " - Id: " + id + " - autor: " + autor + " - editora: " + editora + " - edicao:"
				+ edicao + " - genero:" + genero + " - qtdeTotal:" + qtdeTotal + " - qtdeDisponiveis:" + qtdeDisponiveis
				+ "\n";
	}

	//GETTER E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getQtdeTotal() {
		return qtdeTotal;
	}
	public void setQtdeTotal(int qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	public int getQtdeDisponiveis() {
		return qtdeDisponiveis;
	}
	public void setQtdeDisponiveis(int qtdeDisponiveis) {
		this.qtdeDisponiveis = qtdeDisponiveis;
	}
	
}
