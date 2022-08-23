package backend;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	
	//ATRIBUTOS
	private Long cpf_cliente;
	private Long id_livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	//CONSTRUTOR
	public Emprestimo(Long cpf_cliente, Long id_livro, Date dataEmprestimo) {
		super();
		this.cpf_cliente = cpf_cliente;
		this.id_livro = id_livro;
		this.dataEmprestimo = dataEmprestimo;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataEmprestimo);
		cal.add(Calendar.DATE, 14);
		this.dataDevolucao = cal.getTime();
	}
	
	
	//METODOS
    public boolean alugarLivro() {
        for( Livro l : Biblioteca.livros) {
            if(l.getId().equals(this.id_livro)) {
                for(Cliente c : Biblioteca.clientes) {
                    if(c.getCpf().equals(this.cpf_cliente)) {
                        l.setQtdeDisponiveis(l.getQtdeDisponiveis() - 1);
                        c.adicionarLivroAlugado(l);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean devolverLivro() {
        for( Livro l : Biblioteca.livros) {
            if(l.getId().equals(this.id_livro)) {
                for(Cliente c : Biblioteca.clientes) {
                    if(c.getCpf().equals(this.cpf_cliente)) {
                        l.setQtdeDisponiveis(l.getQtdeDisponiveis() + 1);
                        c.removerLivroAlugado(l);
                        return true;
                    }
                }
            }
        }
        return false;
    }


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
