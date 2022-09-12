package backendTeste;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import backend.Biblioteca;


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
    void testeRemoverBibliotecarioFalso() {
        boolean removerBibliotecario = Biblioteca.removerBibliotecario(-988928L);
        assertFalse(removerBibliotecario);
    }
    
} 