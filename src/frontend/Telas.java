package frontend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;
import backend.Livro;

public class Telas {

	//VARIAVEIS
	static Scanner sc = new Scanner(System.in);
	
	//METODOS
	public static void telaPrincipal() {
		
		try {
			//VARIAVEIS
			int sistAberto = 1;
			Scanner sc = new Scanner(System.in);
			
			//TELA INICIAL
			while(sistAberto == 1) {
				
				//Opcoes
				System.out.println("\nSistema da Biblioteca");
				System.out.println("(1) Sign-up\n(2) Cadastre-se\n");
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
		} catch (Exception e) {
			System.err.println("Opcao invalida.");
			telaPrincipal();
		}
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
			System.err.println("Falha ao efetuar o login.");
		}

		
	}
	
	private static void telaCadastro() {
		try {
			
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
			
		} catch (InputMismatchException e) {
			System.err.println("CPF ou matricula invalidos!");
		}
	}

	private static void telaOpcoesSistema() {
		
		//VARIAVEIS
		int escolha = 1;
		
			//OPCOES
			while(escolha != 0) {
				
				System.out.println("--------------------------------------------\n");
				System.out.println("O que você deseja fazer?");
				System.out.println("(0)  Sair");
				System.out.println("(1)  Consultar livros disponíveis");
				System.out.println("(2)  Consultar livro específico");
				System.out.println("(3)  Consultar todos os bibliotecários");
				System.out.println("(4)  Consultar biblitecário específico");
				System.out.println("(5)  Consultar todos os clientes");
				System.out.println("(6)  Consultar cliente específico");
				System.out.println("(7)  Adicionar livro na biblioteca");
				System.out.println("(8)  Adicionar livro no estoque");
				System.out.println("(9)  Adicionar bibliotecário");
				System.out.println("(10) Adicionar cliente");
				System.out.println("(11) Alterar livro");
				System.out.println("(12) Alterar bibliotecário");
				System.out.println("(13) Alterar cliente");
				System.out.println("(14) Remover livro da biblioteca");
				System.out.println("(15) Remover livro do estoque");
				System.out.println("(16) Remover bibliotecário");
				System.out.println("(17) Remover cliente");
				System.out.println("(18) REGISTRAR EMPRÉSTIMO DO LIVRO (CLIENTE)");
				System.out.println("(19) REGISTRAR DEVOLUÇÃO DO LIVRO (CLIENTE)");
				System.out.println("(20) CONSULTAR EMPRESTIMOS PENDENTES");
				System.out.println("(21) CONSULTAR EMPRESTIMOS ATRASADOS");
				System.out.println("--------------------------------------------");
				System.out.print("Sua escolha: ");
				
				try {
				escolha = sc.nextInt();
				
				//TELAS
				if(escolha == 0) {
					System.out.println("Até a próxima!");
					System.exit(0);
				} else if(escolha == 1) {
					System.out.println(Biblioteca.consultarLivrosTotais());
				} else if(escolha == 2) {
					telaLivroDesejado();
				} else if(escolha == 3) {
					System.out.println(Biblioteca.consultarBibliotecariosTotais());
				} else if(escolha == 4) {
					telaBibliotecarioEspecifico();
				} else if(escolha == 5) {
					System.out.println(Biblioteca.consultarClientesTotais());
				} else if(escolha == 6) {
					telaClienteEspecifico();
				} else if(escolha == 7) {
					sc.nextLine();
					telaAdicionarLivroNovo();
				} else if(escolha == 8) {
					telaAdicionarLivroEstoque();
				} else if(escolha == 9) {
					telaAdicionarBibliotecario();
				} else if(escolha == 10) {
					telaAdicionarCliente();
				} else if(escolha == 11) {
					telaAlterarLivro();
				} else if(escolha == 12) {
					telaAlterarBibliotecario();
				} else if(escolha == 13) {
					telaAlterarCliente();
				} else if(escolha == 14) {
			        telaRemoverLivroTotal(); 
			    } else if(escolha == 15) {
			        telaRemoverLivroQuantidade();
			    } else if(escolha == 16) {
			        telaRemoverBibliotecario();
			    } else if(escolha == 17) {
			        telaRemoverCliente();
			    } else if(escolha == 18) {
			        telaEmprestimo();
			    } else if(escolha == 19) {
			        telaDevolucao();
			    } else if(escolha == 20) {
			        System.out.println(Biblioteca.consultarEmprestimosTotais());
			    } else if(escolha == 21) {
			    	System.out.println(Biblioteca.consultarEmprestimosAtrasados());
			    } else {
					System.err.println("Opção nao registrada!\n");
				}
				 
			} catch (Exception e) {
				System.err.println("Opção inválida! Digite um número!\n");
			}
		} 
			
	}
	
	private static void telaLivroDesejado() {
		
		int escolhaAux;
		Long id;
		String nome;
		
		System.out.println("Escolha o método de consulta:");
		System.out.println("(1) Nome do livro\n(2) Id do livro\n");
		System.out.print("Sua escolha: ");
		try {
			escolhaAux = sc.nextInt();
			
			if(escolhaAux == 1) {
				System.out.print("Digite o nome do livro desejado: ");
				nome = sc.next();
				System.out.println(Biblioteca.consultarLivroUnico(nome));
			} else {
				System.out.print("Digite o id do livro desejado: ");
				id = sc.nextLong();
				System.out.println(Biblioteca.consultarLivroUnico(id));
			}
		} catch (Exception e) {
			System.err.println("Opcao invalida!");
		}
		
	}

	private static void telaBibliotecarioEspecifico() {
		
		Long matricula;
		System.out.print("Digite a matricula do bibliotecario: ");
		matricula = sc.nextLong();
		System.out.println(Biblioteca.consultarBibliotecarioUnico(matricula));		
	}

	private static void telaClienteEspecifico() {
		Long cpf;
		System.out.print("Digite o cpf do cliente: ");
		cpf = sc.nextLong();
		System.out.println(Biblioteca.consultarClienteUnico(cpf));		
	}
	
	private static void telaAdicionarLivroNovo() {
		
		//Variaveis 
		String titulo, autor, editora, genero;
		int edicao, qtde;
		Long id; 
		
		//Dados
		System.out.print("Digite o titulo: ");
		titulo = sc.nextLine();
		System.out.print("Digite o autor: ");
		autor = sc.nextLine();
		System.out.print("Digite a edição: ");
		edicao = sc.nextInt(); sc.nextLine();
		System.out.print("Digite a editora: ");
		editora= sc.nextLine();
		System.out.print("Digite o gênero: ");
		genero = sc.nextLine();
		System.out.print("Digite a quantidade de livros: ");
		qtde = sc.nextInt();sc.nextLine();
		System.out.print("Digite o id do livro: ");
		id = sc.nextLong();
		
		//Cadastrar novo biblitecario
		Livro novo = new Livro(id, titulo, autor, editora, edicao, genero, qtde);
		
		//Saida
		if(Biblioteca.adicionarLivroNovo(novo)) {
			System.out.println("Livro cadastrado com sucesso!");
		} else {
			System.out.println("Falha ao cadastrar!");
		}
	}	

	private static void telaAdicionarLivroEstoque() {
		
		Long id;
		int qtde;
		
		System.out.print("Digite o id do livro: ");
		id = sc.nextLong();
		System.out.print("Digite a quantidade a ser adicionada no estoque: ");
		qtde = sc.nextInt();
		
		if(Biblioteca.adicionarLivroQtde(id, qtde)) {
			System.out.println("Quantidade adicionada com sucesso!");
		} else {
			System.out.println("Id invalido!");
		}
	}

	private static void telaAdicionarBibliotecario() {
		
		//Variaveis 
		Long cpf, matricula; 
		String nome, telefone, login, senha;
		
		//Login e senha
		sc.nextLine();
		System.out.print("Digite o nome: ");
		nome = sc.nextLine();
		System.out.print("Digite o telefone: ");
		telefone = sc.nextLine();
		System.out.print("Digite o cpf: ");
		cpf = sc.nextLong(); sc.nextLine();
		System.out.print("Digite a matricula: ");
		matricula = sc.nextLong(); sc.nextLine();
		System.out.print("Digite o login: ");
		login = sc.nextLine();
		System.out.print("Digite a senha: ");
		senha = sc.nextLine();
		
		//Cadastrar novo biblitecario
		Bibliotecario novo = new Bibliotecario(cpf, nome, telefone,  matricula, login, senha);
		
		//Saida
		if(Biblioteca.adicionarBibliotecario(novo)) {
			System.out.println("Usuario cadastrado com sucesso!");
		} else {
			System.out.println("Falha ao cadastrar!");
		}
	}
	
	private static void telaAdicionarCliente() {
		
		//Variaveis 
		Long cpf; 
		String nome, telefone, email;
		
		//Login e senha
		sc.nextLine();
		System.out.print("Digite o nome: ");
		nome = sc.nextLine();
		System.out.print("Digite o telefone: ");
		telefone = sc.nextLine();
		System.out.print("Digite o email: ");
		email = sc.nextLine();
		System.out.print("Digite o cpf: ");
		cpf = sc.nextLong(); sc.nextLine();
		
		//Cadastrar novo biblitecario
		Cliente novo = new Cliente(cpf, nome, telefone, email);
		
		//Saida
		if(Biblioteca.adicionarCliente(novo)) {
			System.out.println("Cliente cadastrado com sucesso!");
		} else {
			System.out.println("Falha ao cadastrar!");
		}
	}	
	
	private static void telaAlterarLivro() {
		
		Long id;
		System.out.print("Digite o id do livro a ser alterado: ");
		id = sc.nextLong();
		
		//Dados
		if(!Biblioteca.consultarLivroUnico(id).equals("")) {
			
			sc.nextLine();
			System.out.print("Digite o titulo: ");
			String titulo = sc.nextLine();
			System.out.print("Digite o autor: ");
			String autor = sc.nextLine();
			System.out.print("Digite a edição: ");
			int edicao = sc.nextInt(); sc.nextLine();
			System.out.print("Digite a editora: ");
			String editora= sc.nextLine();
			System.out.print("Digite o gênero: ");
			String genero = sc.nextLine();
			System.out.print("Digite a quantidade de livros: ");
			int qtde = sc.nextInt();sc.nextLine();
			System.out.print("Digite o id do livro: ");
			id = sc.nextLong();
			
			//Alterar livro
			Livro novo = new Livro(id, titulo, autor, editora, edicao, genero, qtde);
			if(Biblioteca.alterarLivro(id, novo)) {
				System.out.println("Livro alterado com sucesso!");
			} else {
				System.out.println("Falha ao alterar");
			}
		} else {
			System.out.println("Id invalido!");
		}
		
	}
	
	private static void telaAlterarBibliotecario() {
		
		Long matricula;
		System.out.print("Digite a matricula do bibliotecario: ");
		matricula = sc.nextLong();
		
		//Dados
		if(!Biblioteca.consultarBibliotecarioUnico(matricula).equals("")) {
			sc.nextLine();
			System.out.print("Digite o nome: ");
			String nome = sc.nextLine();
			System.out.print("Digite o telefone: ");
			String telefone = sc.nextLine();
			System.out.print("Digite o cpf: ");
			Long cpf = sc.nextLong(); sc.nextLine();
			System.out.print("Digite a matricula: ");
			matricula = sc.nextLong(); sc.nextLine();
			System.out.print("Digite o login: ");
			String login = sc.nextLine();
			System.out.print("Digite a senha: ");
			String senha = sc.nextLine();
			
			//Alterar biblitecario
			Bibliotecario novo = new Bibliotecario(cpf, nome, telefone,  matricula, login, senha);
			
			if(Biblioteca.alterarBibliotecario(matricula, novo)) {
				System.out.println("Sucesso ao alterar bibliotecario!");
			} else {
				System.out.println("Falha ao alterar");
			}
		} else {
			System.out.println("Matricula invalida!");
		}
		
	}
	
	private static void telaAlterarCliente() {
		
		//Encontrar livro
		Long cpf;
		System.out.print("Digite o cpf do cliente: ");
		cpf = sc.nextLong();
	
		//Novos dados
		if(!Biblioteca.consultarClienteUnico(cpf).equals("")) {
			sc.nextLine();
			System.out.print("Digite o nome: ");
			String nome = sc.nextLine();
			System.out.print("Digite o telefone: ");
			String telefone = sc.nextLine();
			System.out.print("Digite o email: ");
			String email = sc.nextLine();
			System.out.print("Digite o cpf: ");
			cpf = sc.nextLong(); sc.nextLine();
			
			//Alterar livro
			Cliente novo = new Cliente(cpf, nome, telefone, email);
			Biblioteca.alterarCliente(cpf, novo);
			
			if(Biblioteca.alterarCliente(cpf, novo)) {
				System.out.println("Sucesso ao alterar cliente!");
			} else {
				System.out.println("Falha ao alterar");
			}
		} else {
			System.out.println("Cpf invalido!");
		}
	}

	public static void telaRemoverLivroTotal(){
        System.out.print("Digite o id do livro: ");
        Long id = sc.nextLong();

        
        if(Biblioteca.removerLivroTotal(id)) {
            System.out.println("Livro removido!");
		} else {
			System.out.println("Falha ao remover");
		}
        
    }

    public static void telaRemoverLivroQuantidade() {
        System.out.print("Digite o id do livro: ");
        Long id = sc.nextLong();
        System.out.print("Digite a quantidade de livros a remover: ");
        int quantidade = sc.nextInt();

        
        
        if(Biblioteca.removerLivroParcial(id, quantidade)) {
            System.out.println("Quantidade de livro(s) removido(s)!");
		} else {
			System.out.println("Falha ao remover");
		}
    }

    public static void telaRemoverBibliotecario() {
        System.out.print("Digite a matrícula do bibliotecário a remover: ");
        Long matricula = sc.nextLong();

        
        
        if(Biblioteca.removerBibliotecario(matricula)) {
            System.out.println("Bibliotecário removido!");
		} else {
			System.out.println("Falha ao remover");
		}
    }

    public static void telaRemoverCliente() {
        System.out.print("Digite o cpf do cliente a remover: ");
        Long cpf = sc.nextLong();
        
        if(Biblioteca.removerCliente(cpf)) {
            System.out.println("Cliente removido!");
		} else {
			System.out.println("Falha ao remover");
		}
    }
    
    public static void telaEmprestimo() {
    	
    	//Variaveis
    	Long cpf, id;
    	String data;
    	
    	//Dados iniciais
    	sc.nextLine();
    	System.out.print("Digite o cpf do cliente solicitante: ");
    	cpf = sc.nextLong();
    	System.out.print("Digite o id do livro a ser emprestado: ");
    	id = sc.nextLong();
    	System.out.print("Digite o a data do emprestimo (dd/mm/yyyy): ");
    	data = sc.next();
    	
    	//FORMARTAR DATA DE EMPRESTIMO A PARTIR DA STRING
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    		
    		//Instanciar data 
			Date date = formatter.parse(data);
			
			//Registrar emprestimo			
			if(Biblioteca.alugarLivroBiblioteca(cpf, id, date)) {
				System.out.println("Emprestimo realizado com sucesso!");
				System.out.println("O cliente tem deve devolver o livro em 14 dias uteis.");
			} else {
				System.out.println("Falha ao realizar emprestimo.");
			}
		}  catch (ParseException e) {
			System.out.println("Falha ao realizar emprestimo.");
		}

    }
    
    public static void telaDevolucao() {
    	
        //Variaveis
        Long cpf, id;

        //Dados iniciais
        sc.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        cpf = sc.nextLong();
        System.out.print("Digite o id do livro a ser devolvido: ");
        id = sc.nextLong();

        if(Biblioteca.devolverLivroBiblioteca(cpf, id)) {
            System.out.println("Livro devolvido com sucesso!");
        }
        else {
            System.out.println("Erro ao devolver livro. Dados inválidos!");
        }
    }

}
