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
	
	//CONSTRUTOR
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
		this.qtdeTotal = qtdeTotal + qtde;
		this.qtdeDisponiveis = qtdeDisponiveis + qtde;
	}
	@Override
	public String toString() {
		return "Título: " + titulo + " - Id: " + id + " - autor: " + autor + " - editora: " + editora + " - edição:"
				+ edicao + " - gênero:" + genero + " - quantidade total:" + qtdeTotal + " - quantidade disponíveis:" + qtdeDisponiveis
				+ "\n";
	}
	public String toStringCliente() {
		return "Título: " + titulo + " - Id: " + id + "\n";
	}

	//GETTER E SETTERS
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getEditora() {
		return editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public String getGenero() {
		return genero;
	}
	public int getQtdeTotal() {
		return qtdeTotal;
	}
	public int getQtdeDisponiveis() {
		return qtdeDisponiveis;
	}
	public void setQtdeDisponiveis(int qtdeDisponiveis) {
		this.qtdeDisponiveis = qtdeDisponiveis;
	}
	public void setQtdeTotal(int qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	
	
}
