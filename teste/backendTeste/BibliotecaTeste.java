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
    void testeRemoverBibliotecarioFalso() {
        boolean removerBibliotecario = Biblioteca.removerBibliotecario(-988928L);
        assertFalse(removerBibliotecario);
    }
    
} 