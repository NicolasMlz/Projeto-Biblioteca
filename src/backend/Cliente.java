package backend;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	
	//ATRIBUTOS
	private String email;
	private List<Livro> livrosAlugados = new ArrayList<>();
	
	//CONSTRUTOR
	public Cliente(Long cpf, String nome, String telefone, String email) {
        super(cpf, nome, telefone);
        this.email = email;
    }

	//METODOS
	@Override
	public String toString() {
		String livros = "";
		for(Livro l : livrosAlugados) {
			livros += l.toStringCliente();
		}
		return super.toString() + " - E-mail: " + email + "\nLivros alugados: \n" + livros + "\n";
	}
	
	public void adicionarLivroAlugado(Livro livro) {
        livrosAlugados.add(livro);
    }
    public void removerLivroAlugado(Livro livro) {
        livrosAlugados.remove(livro);
    }
    
    //GETTERS E SETTERS
	public String getEmail() {
		return email;
	}

	public List<Livro> getLivrosAlugados() {
		return livrosAlugados;
	}

	public void setLivrosAlugados(List<Livro> livrosAlugados) {
		this.livrosAlugados = livrosAlugados;
	}
	
	
}
