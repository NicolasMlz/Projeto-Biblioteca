package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {
	
	//ATRIBUTOS
	private String email;
	private List<Livro> livrosAlugados = new ArrayList<>();
	
	//CONSTRUTOR
	public Cliente(Long cpf, String nome, String telefone, Date dataNascimento, String email) {
        super(cpf, nome, telefone, dataNascimento);
        this.email = email;
    }

	
	//GETTERS E SETTERS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Livro> getLivrosAlugados() {
		return livrosAlugados;
	}
	public void setLivrosAlugados(List<Livro> livrosAlugados) {
		this.livrosAlugados = livrosAlugados;
	}
	
}
