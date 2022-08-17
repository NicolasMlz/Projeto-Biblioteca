package modelo;

public interface OperacoesInterface {
	
	//OPERACOES DE ENTRADA
	boolean login();
	
	//OPERACOES DE INCLUSAO
	void adicionarBibliotecario(Bibliotecario bibliotecario);
	void adicionarNovoLivro(Livro livro);
	void adicionarEstoque(Livro livro, int qtde);
	void adicionarCliente();
	
	//OPERACOES DE EXCLUSAO
	void removerBibliotecario(Bibliotecario bibliotecario);
	void removerLivro(Livro livro);
	void removerEstoque(Livro livro, int qtde);
	void removerCliente();
	
}
