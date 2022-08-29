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
		return "Nome: " + nome + "\nCpf: " + cpf + " - Telefone: " + telefone;
	}
	
	//GETTER E SETTERS
	public Long getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	
}
