package backend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	
	//ATRIBUTOS
	private Long cpf_cliente;
	private Long id_livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private boolean livroDevolvido;
	
	//CONSTRUTOR
	public Emprestimo(Long cpf_cliente, Long id_livro, Date dataEmprestimo, boolean livroDevolvido) {
		super();
		this.cpf_cliente = cpf_cliente;
		this.id_livro = id_livro;
		this.dataEmprestimo = dataEmprestimo;
		this.livroDevolvido = livroDevolvido;
		
		//DEFINIR DATA DE DEVOLUCAO
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataEmprestimo);
		cal.add(Calendar.DATE, 14);
		this.dataDevolucao = cal.getTime();
	}
	
	
	//METODOS
	public boolean alugarLivro() {
		
		for(Emprestimo e : Biblioteca.emprestimos) {
            if(e.getCpf_cliente().equals(this.cpf_cliente) && 
                e.getId_livro().equals(this.id_livro) && !e.isLivroDevolvido())

                return false;
        }
		
        for(Livro l : Biblioteca.getLivros()) {
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
        for( Livro l : Biblioteca.getLivros()) {
            if(l.getId().equals(this.id_livro)) {
                for(Cliente c : Biblioteca.clientes) {
                    if(c.getCpf().equals(this.cpf_cliente)) {
                        l.setQtdeDisponiveis(l.getQtdeDisponiveis() + 1);
                        c.removerLivroAlugado(l);
                        livroDevolvido = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString() {

        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        String dtDevolver = f1.format(dataDevolucao);
        String dtEmprestar = f1.format(dataEmprestimo);

        String atrasado;
        String devolvido;
        
        if(livroDevolvido == true) 
        	devolvido = "devolvido";
        else 
        	devolvido = "não devolvido";

        if(emprestimoAtrasado()) atrasado = "Atrasado";
        else atrasado = "No prazo";

        return "Cpf do cliente: " + cpf_cliente + " - Id do livro: " + id_livro + " - Data do empréstimo: "
                + dtEmprestar + " - Data de devolução: " + dtDevolver + " - " + atrasado + " e " + devolvido + "\n";
    }
    
    public boolean emprestimoAtrasado() {
    	if(dataDevolucao.before(new Date())) {
    		return true;
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
	public boolean isLivroDevolvido() {
		return livroDevolvido;
	}
	public void setLivroDevolvido(boolean livroDevolvido) {
		this.livroDevolvido = livroDevolvido;
	}
}
