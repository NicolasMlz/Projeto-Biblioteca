package backend;

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


	
	//GETTERS E SETTERS
	public Long getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(Long cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	public Long getId_livro() {
		return id_livro;
	}
	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
