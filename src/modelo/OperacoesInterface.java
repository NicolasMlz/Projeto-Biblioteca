package modelo;

public interface OperacoesInterface {
	
	//OPERACOES DE INCLUSAO
	void adicionarBibliotecario(Bibliotecario bibliotecario);
	void adicionarLivroNovo(Livro livro);
	void adicionarLivroQtde(Long id, int qtde);
	void adicionarCliente(Cliente cliente);
	
	//OPERACOES DE EXCLUSAO
	void removerBibliotecario(Long matricula);
	void removerLivroTotal(Long id);
	void removerLivroParcial(Long id, int qtde);
	void removerCliente(Long cpf);
	
	//OPERACOES DE ALTERACAO
	void alterarBibliotecario(Long matricula, Bibliotecario bibliotecario);
	void alterarCliente(Long cpf, Cliente cliente);
	void alterarLivro(Long id, Livro livro);
	
	//OPERACOES DE CONSULTA
	String consultarLivroUnico(Long id);
	String consultarLivrosTotais();
	String consultarBibliotecarioUnico(Long matricula);
	String consultarBibliotecariosTotais();
	String consultarClienteUnico(Long cpf);
	String consultarClientesTotais();	
}
