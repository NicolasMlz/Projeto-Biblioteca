package frontend;

import arquivosTXT.Arquivo;

public class Principal {
	public static void main(String[] args) {
		
		//Ler do Arquivo
		Arquivo.ReadLivro("livro.txt");
		Arquivo.ReadCliente("cliente.txt");
		Arquivo.ReadBibliotecario("bibliotecario.txt");
        
        //Sistema
        Telas.telaPrincipal();
	}
}