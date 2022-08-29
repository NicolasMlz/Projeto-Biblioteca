package backendTeste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import backend.Biblioteca;
import backend.Bibliotecario;

class BibliotecaTeste {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testeRemoverLivroVerdadeiro() {
        boolean removerLivro = Biblioteca.removerLivroTotal(3L);
        assertTrue(removerLivro);
    }
	
	@Test
	void testeRemoverLivroFalso() {
        boolean removerLivro = Biblioteca.removerLivroTotal(30L);
        assertFalse(removerLivro);
    }
	
	@Test
    void testeRemoverClienteFalso() {
        boolean removerCliente = Biblioteca.removerCliente(-9L);
        assertFalse(removerCliente);
    }
	
	@Test
    void testeRemoverClienteVerdadeiro() {
        boolean removerCliente = Biblioteca.removerCliente(1L);
        assertTrue(removerCliente);
    }
    
    @Test
    void testeAdicionarBibliotecarioFalso() {
    	Bibliotecario b = new Bibliotecario(43688302810L, "Nicolas Marcelo Maulaiz", "11931525036", 2L, "nic", "321");
        boolean adicionar = Biblioteca.adicionarBibliotecario(b);
        assertFalse(adicionar);
    }
}
