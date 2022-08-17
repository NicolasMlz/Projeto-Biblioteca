package modelo;

import java.util.Date;

public class Bibliotecario extends Pessoa {
	
	//ATRIBUTOS
	private Long matricula;
	private String login;
	private String senha;
	
	//CONSTRUTOR
	public Bibliotecario(Long cpf, String nome, String telefone, Date dataNascimento, Long matricula, String login, String senha) {
        super(cpf, nome, telefone, dataNascimento);
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }

	
	//GETTERS E SETTERS
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
