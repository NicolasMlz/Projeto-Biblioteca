package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;
import backend.Livro;

public class Principal {
	public static void main(String[] args) {
		
		//INSTANCIAS
		Biblioteca.adicionarBibliotecario(new Bibliotecario(1L, "hello", "62625588548", 1L, "hello", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(2L, "nic", "62625588548", 2L, "ninic", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(3L, "edu", "62625588548", 3L, "edu", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(4L, "pedro", "62625588548", 4L, "pedro", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(1L, "lucas", "62625588548", 5L, "hello", "123") );
        
        Biblioteca.adicionarCliente(new Cliente(1L, "hello", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(2L, "nic", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(3L, "edu", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(4L, "pedro", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(5L, "lucas", "62625588548", "teste@gmail.com"));
        
        Biblioteca.adicionarLivroNovo(new Livro(1l, "livro1", "autor1", "editora1", 1, "romance", 10));
        Biblioteca.adicionarLivroNovo(new Livro(2l, "livro1", "autor2", "editora2", 1, "guerra", 10));
        Biblioteca.adicionarLivroNovo(new Livro(3l, "livro3", "autor3", "editora3", 1, "romance", 10));
        Biblioteca.adicionarLivroNovo(new Livro(4l, "livro4", "autor4", "editora4", 1, "guerra", 10));
        Biblioteca.adicionarLivroNovo(new Livro(5l, "livro5", "autor5", "editora5", 1, "auto-ajuda", 10));
        Biblioteca.adicionarLivroNovo(new Livro(6l, "livro6", "autor6", "editora6", 1, "romance", 10));
        Biblioteca.adicionarLivroNovo(new Livro(7l, "livro7", "autor7", "editora7", 1, "auto-ajuda", 10));
        
        //SISTEMA
        Telas.telaPrincipal();
	}
}