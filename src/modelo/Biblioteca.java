package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	//ATRIBUTOS
	static private List<Bibliotecario> bibliotecarios = new ArrayList<>();
	static private List<Cliente> clientes = new ArrayList<>();
	static private List<Livro> livros = new ArrayList<>();
	
	
	//CONSTRUTOR
	private Biblioteca() {
		
	}

	
	//GETTERS E SETTERS
	public static List<Bibliotecario> getBibliotecarios() {
		return bibliotecarios;
	}
	public static void setBibliotecarios(List<Bibliotecario> bibliotecarios) {
		Biblioteca.bibliotecarios = bibliotecarios;
	}
	public static List<Cliente> getClientes() {
		return clientes;
	}
	public static void setClientes(List<Cliente> clientes) {
		Biblioteca.clientes = clientes;
	}
	public static List<Livro> getLivros() {
		return livros;
	}
	public static void setLivros(List<Livro> livros) {
		Biblioteca.livros = livros;
	}
	
}
