package modelo;

import java.util.Date;

public class Emprestimo {
	
	//ATRIBUTOS
	private Long cpf_cliente;
	private Long id_livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	//CONSTRUTOR
	public Emprestimo(Long cpf_cliente, Long id_livro, Date dataEmprestimo, Date dataDevolucao) {
		super();
		this.cpf_cliente = cpf_cliente;
		this.id_livro = id_livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	
	//METODOS
	void alugarLivro(Long cpf, Long id) {}
	void devolverLivro(Long cpf, Long id) {}

}
