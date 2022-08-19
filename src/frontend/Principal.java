package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;

public class Principal {
	public static void main(String[] args) {
		
		//INSTANCIAS
		Biblioteca.adicionarBibliotecario(new Bibliotecario(111111111111L, "hello", "62625588548", 584555555555L, "hello", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(222222222222L, "nic", "62625588548", 020223132123L, "ninic", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(333333333333L, "edu", "62625588548", 78779754754L, "edu", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(444444444444L, "pedro", "62625588548", 44141414422L, "pedro", "123") );
        Biblioteca.adicionarBibliotecario(new Bibliotecario(111111111111L, "lucas", "62625588548", 584555555554L, "hello", "123") );
        
        Biblioteca.adicionarCliente(new Cliente(111111111111L, "hello", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(222222222222L, "nic", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(333333333333L, "edu", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(444444444444L, "pedro", "62625588548", "teste@gmail.com"));
        Biblioteca.adicionarCliente(new Cliente(555555555555L, "lucas", "62625588548", "teste@gmail.com"));
        
        //SISTEMA
        Login.telaPrincipal();
	}
}