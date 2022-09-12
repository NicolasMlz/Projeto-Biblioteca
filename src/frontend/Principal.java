package frontend;

import arquivoTXT.Arquivo;

public class Principal {
	public static void main(String[] args) {
		
		try {	
			//Ler arquivos
			//A leitura só funciona se houver pelo menos uma String em cada arquivo 
			//Então a primeira linha de cada arquivo não pode ser modificada
			Arquivo.ReadLivro("livro.txt");
			Arquivo.ReadCliente("cliente.txt");
			Arquivo.ReadBibliotecario("bibliotecario.txt");
			Arquivo.ReadEmprestimo("emprestimo.txt");
			
	        Telas.telaPrincipal();

		}catch (Exception e) {
				System.out.println("Erro ao iniciar sistema! Tente novamente.");
		}
	}
}