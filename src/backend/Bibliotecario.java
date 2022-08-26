package backend;

public class Bibliotecario extends Pessoa {
	
	//ATRIBUTOS
	private Long matricula;
	private String login;
	private String senha;
	
	//CONSTRUTOR
	public Bibliotecario(Long cpf, String nome, String telefone, 
			Long matricula, String login, String senha) {
        super(cpf, nome, telefone);
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }

	//METODOS
	@Override
	public String toString() {
		return super.toString() + " - Matrícula: " + matricula + " - Login: " + login + "\n";
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

