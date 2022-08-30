package backendTeste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import arquivoTXT.Arquivo;
import backend.Biblioteca;
import backend.Bibliotecario;


class BibliotecaTeste {

	@Test
	void testeRemoverLivroFalso() {
        boolean removerLivro = Biblioteca.removerLivroTotal(30L);
        assertFalse(removerLivro);
    }
	
	@Test
    void testeRemoverClienteFalso() {
        boolean removerCliente = Biblioteca.removerCliente(999999999L);
        assertFalse(removerCliente);
    }
	
	@Test
    void testeRemoverClienteVerdadeiro() {
		
		Arquivo.ReadCliente("cliente.txt");
		
        boolean removerCliente = Biblioteca.removerCliente(22222222222L);
        assertTrue(removerCliente);
    }
    
    @Test
    void testeAdicionarBibliotecarioFalso() {
    	
		Arquivo.ReadBibliotecario("bibliotecario.txt");

    	Bibliotecario b = new Bibliotecario(43688302810L, "Nicolas Marcelo Maulaiz", "11931525036", 2L, "nic", "321");
        boolean adicionar = Biblioteca.adicionarBibliotecario(b);
        assertFalse(adicionar);
    }
    
    @Test
	void testeRemoverLivroVerdadeiro() {
    	
		Arquivo.ReadLivro("livro.txt");

        boolean removerLivro = Biblioteca.removerLivroTotal(1L);
        assertTrue(removerLivro);
    }
} 