package backend;

public abstract class Pessoa {
	
	//ATRIBUTOS
	private Long cpf;
	private String nome;
	private String telefone;
	
	//CONSTRUTOR
	public Pessoa(Long cpf, String nome, String telefone) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }
	
	//METODOS
	@Override
	public String toString() {
		return "Nome: " + nome + "\ncpf: " + cpf + " - Telefone: " + telefone;
	}
	
	
	//GETTER E SETTERS
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
