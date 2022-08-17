package modelo;

import java.util.Date;

public abstract class Pessoa {
	
	//ATRIBUTOS
	private Long cpf;
	private String nome;
	private String telefone;
	private Date dataNascimento;
	
	//CONSTRUTOR
	public Pessoa(Long cpf, String nome, String telefone, Date dataNascimento) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
