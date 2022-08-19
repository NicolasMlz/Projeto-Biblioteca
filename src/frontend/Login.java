package frontend;

import java.util.Scanner;

import backend.Biblioteca;
import backend.Bibliotecario;

public class Login {

	//VARIAVEIS
	static Scanner sc = new Scanner(System.in);
	
	//METODOS
	public static void telaPrincipal() {
		
		//VARIAVEIS
		int sistAberto = 1;
		Scanner sc = new Scanner(System.in);
		
		//TELA INICIAL
		while(sistAberto == 1) {
			
			//Opcoes
			System.out.println("\nSistema da Biblioteca");
			System.out.println("(1) Sign-up\n(2) Cadastre-se");
			System.out.print("Sua escolha: ");
			int escolha = sc.nextInt();
			
			//SIGN-UP
			if(escolha == 1) {
				telaLogin();
			}
			//CADASTRE-SE
			else if(escolha == 2) {
				telaCadastro();
			}
		}
		
		sc.close();
	}
	
	private static void telaLogin() {
		
		//Variaveis 
		String login;
		String senha;
		
		//Login e senha
		System.out.print("Login: ");
		login = sc.nextLine();
		System.out.print("Senha: ");
		senha = sc.nextLine();
		
		//Condicao de entrada
		if(Biblioteca.loginCorreto(login, senha)) {
			System.out.println("Login efetuado com sucesso!");
			telaOpcoesSistema();
		} else {
			System.out.println("Falha ao efetuar o login.");
		}
	}
	
	private static void telaCadastro() {
		
		//Variaveis 
		Long cpf, matricula; 
		String nome, telefone, login, senha;
		
		//Login e senha
		System.out.print("Digite seu nome: ");
		nome = sc.nextLine();
		System.out.print("Digite seu telefone: ");
		telefone = sc.nextLine();
		System.out.print("Digite seu cpf: ");
		cpf = sc.nextLong(); sc.nextLine();
		System.out.print("Digite seu matricula: ");
		matricula = sc.nextLong(); sc.nextLine();
		System.out.print("Digite seu login: ");
		login = sc.nextLine();
		System.out.print("Digite seu senha: ");
		senha = sc.nextLine();
		
		//Cadastrar novo biblitecario
		Bibliotecario novo = new Bibliotecario(cpf, nome, telefone,  matricula, login, senha);
		Biblioteca.adicionarBibliotecario(novo);
		
		//Saida
		System.out.println("Usuario cadastrado com sucesso!");
	}

	private static void telaOpcoesSistema() {
		
		//VARIAVEIS
		int escolha;
		
		//OPCOES
		System.out.println("-------------------------------------");
		System.out.println("O que você deseja fazer?");
		System.out.println("(0)  Sair");
		System.out.println("(1)  Consultar livros disponíveis");
		System.out.println("(2)  Consultar livro específico");
		System.out.println("(3)  Consultar todos os bibliotecários");
		System.out.println("(4)  Consultar biblitecário específico");
		System.out.println("(5)  Consultar todos os clientes");
		System.out.println("(6)  Consultar cliente específico");
		System.out.println("(7)  Adicionar livro da biblioteca");
		System.out.println("(8)  Adicionar livro no estoque");
		System.out.println("(9)  Adicionar bibliotecaário");
		System.out.println("(10) Adicionar cliente");
		System.out.println("(11) Alterar livro");
		System.out.println("(12) Alterar bibliotecário");
		System.out.println("(13) Alterar cliente");
		System.out.println("(14) Remover livro da biblioteca");
		System.out.println("(15) Remover livro do estoque");
		System.out.println("(16) Remover bibliotecário");
		System.out.println("(17) Remover cliente");
		System.out.println("-------------------------------------");
		System.out.print("Sua escolha: ");
		escolha = sc.nextInt();
		
		//TELAS
		if(escolha == 0) {
			
		} else if(escolha == 1) {
			
		} else if(escolha == 2) {
			
		} else if(escolha == 3) {
			
		} else if(escolha == 4) {
			
		} else if(escolha == 5) {
			
		} else if(escolha == 6) {
			
		} else if(escolha == 7) {
			
		} else if(escolha == 8) {
	
		} else if(escolha == 9) {
			
		} else if(escolha == 10) {
			
		} else if(escolha == 11) {
			
		} else if(escolha == 12) {
			
		} else if(escolha == 13) {
			
		} else if(escolha == 14) {
			
		} else if(escolha == 15) {
			
		} else if(escolha == 16) {
			
		} else if(escolha == 17) {
			
		}
	}
}
