package frontend;

import arquivoTXT.Arquivo;

public class Principal {
	public static void main(String[] args) {
		
		//Ler do Arquivo
		Arquivo.ReadLivro("livro.txt");
		Arquivo.ReadCliente("cliente.txt");
		Arquivo.ReadBibliotecario("bibliotecario.txt");
		Arquivo.ReadEmprestimo("emprestimo.txt");
        
        //Sistema
        Telas.telaPrincipal();
	}
}