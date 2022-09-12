package frontend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import arquivoTXT.Arquivo;
import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;
import backend.Livro;
import exceptions.SenhaInvalidaException;

public class Telas {

	//VARIAVEIS
	static Scanner sc = new Scanner(System.in);
	
	//CONSTRUTOR
	private Telas() {
		
	}
	
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
				} else {
					System.err.println("Opãço inválida!");
				}
			}
			
			sc.close();
		} catch (SenhaInvalidaException e) {
			System.err.println(e.getMessage());
			telaLogin();
		} catch (Exception e) {
			System.err.println("Opcão inválida!");
			telaPrincipal();
		}
	}
	
	private static void telaLogin(){

        //Variaveis 
        String login;
        String senha;

        //Login e senha
        System.out.print("Login: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();

        //Condicao de entrada
        try{
            exception(login, senha);

        } catch(SenhaInvalidaException e) {
            System.err.println(e.getMessage());
            telaPrincipal();
        }
    }
	
	private static void exception(String login, String senha) throws SenhaInvalidaException{
        if(Biblioteca.loginCorreto(login, senha)) {
            System.out.println("Login efetuado com sucesso!");
            telaOpcoesSistema();
        }
        else throw new SenhaInvalidaException("Senha Inválida!\nTente novamente.\n");
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
            System.out.print("Digite sua matrícula: ");
            matricula = sc.nextLong(); sc.nextLine();
            System.out.print("Digite seu login: ");
            login = sc.nextLine();
            System.out.print("Digite sua senha: ");
            senha = sc.nextLine();

            for(Bibliotecario l : Biblioteca.getBibliotecarios()) {
                if(l.getMatricula().equals(matricula)) {
                    System.err.println("Erro! Matrícula já existente.");
                    telaPrincipal(); 
                }
                else if(l.getLogin().equals(login)) {
                    System.err.println("Erro! Usuário já existente.");
                    telaPrincipal();
                }
            }

            //Cadastrar novo biblitecario
            //Salvar no arquivo
			String linha = cpf+";"+nome+";"+telefone+";"+matricula+";"+login+";"+senha+";\n";
			Arquivo.Write("bibliotecario.txt", linha);
            Bibliotecario novo = new Bibliotecario(cpf, nome, telefone,  matricula, login, senha);
            Biblioteca.adicionarBibliotecario(novo);

            //Saida
            System.out.println("Usuário cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.err.println("CPF ou matrícula inválidos!");
            sc.nextLine();
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
				System.out.println("(20) CONSULTAR TODOS OS EMPRÉSTIMOS");
				System.out.println("(21) CONSULTAR EMPRÉSTIMOS ATRASADOS");
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
					System.err.println("Opção não registrada!\n");
				}
				 
			} catch (Exception e) {
				System.err.println("Opção inválida. Digite um número!\n");
				sc.nextLine();
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
				sc.nextLine();
				System.out.print("Digite o nome do livro desejado: ");
				nome = sc.nextLine();
				System.out.println(Biblioteca.consultarLivroUnico(nome));
				
			} else if(escolhaAux == 2){
				System.out.print("Digite o id do livro desejado: ");
				id = sc.nextLong();
				System.out.println(Biblioteca.consultarLivroUnico(id));
			} else {
				System.err.println("Opção inválida");
				sc.nextLine();
			}
		} catch (Exception e) {
			System.err.println("Opção inválida!");
			sc.nextLine();
		}
	
		
	}

	private static void telaBibliotecarioEspecifico() {
		
		try {
			Long matricula;
			System.out.print("Digite a matricula do bibliotecario: ");
			matricula = sc.nextLong();
			System.out.println(Biblioteca.consultarBibliotecarioUnico(matricula));
		} catch (Exception e) {
			System.err.println("Matricula inválida!");
			sc.nextLine();
		}		
	}

	private static void telaClienteEspecifico() {
		try {
			Long cpf;
			System.out.print("Digite o cpf do cliente: ");
			cpf = sc.nextLong();
			System.out.println(Biblioteca.consultarClienteUnico(cpf));
		} catch (Exception e) {
			System.err.println("Cpf inválido!");
			sc.nextLine();
		}		
	}
	
	private static void telaAdicionarLivroNovo() {
		
		try {
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
			
			//Cadastrar novo livro
			Livro novo = new Livro(id, titulo, autor, editora, edicao, genero, qtde);
			
			//Salvar no arquivo
			String texto = id+";"+titulo+";"+autor+";"+editora
						+";"+edicao+";"+genero+";"+qtde+";\n";
			
			//Saida
			if(Biblioteca.adicionarLivroNovo(novo) && Arquivo.Write("livro.txt", texto)) {
				System.out.println("Livro cadastrado com sucesso!");
			} else {
				System.err.println("Livro já cadastrado!");
				sc.nextLine();
			}
		} catch (Exception e) {
			System.err.println("Falha ao cadastrar livro!");
			sc.nextLine();
		}
	}	

	private static void telaAdicionarLivroEstoque() {
		
		Long id;
		int qtde;
		
		try {
			System.out.print("Digite o id do livro: ");
			id = sc.nextLong();
			System.out.print("Digite a quantidade a ser adicionada no estoque: ");
			qtde = sc.nextInt();
			
			if(Biblioteca.adicionarLivroQtde(id, qtde)) {
				System.out.println("Quantidade adicionada com sucesso!");
			} else {
				System.err.println("Id invalido!");
			}
		} catch (Exception e) {
			System.err.println("Falha ao adicionar livro no estoque!");
			sc.nextLine();
		}
	}

	private static void telaAdicionarBibliotecario() {
		
		//Variaveis 
		Long cpf, matricula; 
		String nome, telefone, login, senha;
		
		try {
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
			
			//Salvar no arquivo
			String linha = cpf+";"+nome+";"+telefone+";"+matricula+";"+login+";"+senha+";\n";
			Arquivo.Write("bibliotecario.txt", linha);
			
			//Saida
			if(Biblioteca.adicionarBibliotecario(new Bibliotecario(cpf, nome, telefone,  matricula, login, senha))) {
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.err.println("Falha ao cadastrar!");
			}
			
		} catch (Exception e) {
			System.err.println("Falha ao cadastrar bibliotecário!");
			sc.nextLine();
		}
	}
	
	private static void telaAdicionarCliente() {
		
		//Variaveis 
		Long cpf; 
		String nome, telefone, email;
		
		try {
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
			
			//Salvar no arquivo
			String arq = "cliente.txt";
			String texto = cpf+";"+nome+";"+telefone+";"+email+";\n";
			
			//Saida
			if(Biblioteca.adicionarCliente(novo) && Arquivo.Write(arq, texto)) {
				System.out.println("Cliente cadastrado com sucesso!");
			} else {
				System.err.println("Falha ao cadastrar!");
			}
			
		} catch (Exception e) {
			System.err.println("Falha ao cadastrar cliente!");
			sc.nextLine();
		}
	}	
	
	private static void telaAlterarLivro() {
		
		Long id;
		System.out.print("Digite o id do livro a ser alterado: ");
		id = sc.nextLong();
		
		//Dados
		if(!Biblioteca.consultarLivroUnico(id).equals("")) {
			
			try {
				sc.nextLine();
				System.out.print("Digite o título: ");
				String titulo = sc.nextLine();
				System.out.print("Digite o autor: ");
				String autor = sc.nextLine();
				System.out.print("Digite a edição: ");
				int edicao = sc.nextInt(); sc.nextLine();
				System.out.print("Digite a editora: ");
				String editora= sc.nextLine();
				System.out.print("Digite o gênero: ");
				String genero = sc.nextLine();
				
				//Alterar livro
				int qtdeTotal=0;
				int qtdeDisponiveis = 0;
				for(Livro l : Biblioteca.getLivros()) {
					if(l.getId() == id) {
						qtdeTotal = l.getQtdeTotal();
						qtdeDisponiveis = l.getQtdeDisponiveis();
						break;
					}
				}
				Livro novo = new Livro(id, titulo, autor, editora, edicao, genero, qtdeTotal);
				novo.setQtdeDisponiveis(qtdeDisponiveis);
				
				if(Biblioteca.alterarLivro(id, novo)) {
					System.out.println("Livro alterado com sucesso!");
				} else {
					System.err.println("Falha ao alterar");
				}
				
			} catch (Exception e) {
				System.err.println("Falha ao alterar livro!");
				sc.nextLine();
			}
		} else {
			System.out.println("Id inválido!");
		}
		
	}
	
	private static void telaAlterarBibliotecario() {
		
		Long matricula;
		System.out.print("Digite a matrícula do bibliotecário: ");
		matricula = sc.nextLong();
		
		//Dados
		if(!Biblioteca.consultarBibliotecarioUnico(matricula).equals("")) {
			try {
				sc.nextLine();
				System.out.print("Digite o nome: ");
				String nome = sc.nextLine();
				System.out.print("Digite o telefone: ");
				String telefone = sc.nextLine();
				System.out.print("Digite o cpf: ");
				Long cpf = sc.nextLong(); sc.nextLine();
				System.out.print("Digite a matrícula: ");
				Long matriculaNova = sc.nextLong(); sc.nextLine();
				System.out.print("Digite o login: ");
				String login = sc.nextLine();
				System.out.print("Digite a senha: ");
				String senha = sc.nextLine();
				
				//Alterar biblitecario
				Bibliotecario novo = new Bibliotecario(cpf, nome, telefone,  matriculaNova, login, senha);
				
				if(Biblioteca.alterarBibliotecario(matricula, novo)) {
					System.out.println("Sucesso ao alterar bibliotecário!");
				} else {
					System.err.println("Falha ao alterar");
				}
			} catch (Exception e) {
				System.err.println("Falha ao alterar bibliotecário!");
				sc.nextLine();
			}
		} else {
			System.err.println("Matrícula inválida!");
		}
		
	}
	
	private static void telaAlterarCliente() {
		
		//Encontrar livro
		Long cpf;
		System.out.print("Digite o cpf do cliente: ");
		cpf = sc.nextLong();
	
		//Novos dados
		if(!Biblioteca.consultarClienteUnico(cpf).equals("")) {
			try {
				sc.nextLine();
				System.out.print("Digite o nome: ");
				String nome = sc.nextLine();
				System.out.print("Digite o telefone: ");
				String telefone = sc.nextLine();
				System.out.print("Digite o e-mail: ");
				String email = sc.nextLine();
				System.out.print("Digite o cpf: ");
				Long cpfNovo = sc.nextLong(); sc.nextLine();
				
				//Alterar livro
				Cliente novo = new Cliente(cpfNovo, nome, telefone, email);
				
				for(Cliente c : Biblioteca.getClientes()) {
					if(c.getCpf().equals(cpf))
					novo.setLivrosAlugados(c.getLivrosAlugados());
				}
				
				Biblioteca.alterarCliente(cpf, novo);
				
				if(Biblioteca.alterarCliente(cpf, novo)) {
					System.out.println("Sucesso ao alterar cliente!");
				} else {
					System.err.println("Falha ao alterar");
				}
				
			} catch (Exception e) {
				System.err.println("Falha ao alterar cliente!");
				sc.nextLine();
			}
		} else {
			System.err.println("Cpf inválido!");
		}
	}
	
	public static void telaRemoverLivroTotal(){
        try {
			System.out.print("Digite o id do livro: ");
			Long id = sc.nextLong();
			
			if(Biblioteca.removerLivroTotal(id)) {
			    System.out.println("Livro removido!");
			} else {
				System.out.println("Livro não encontrado!");
			}
		} catch (Exception e) {
			System.err.println("Id inválido!");
			sc.nextLine();
		}
        
    }

    public static void telaRemoverLivroQuantidade() {
        try {
        	
			System.out.print("Digite o id do livro: ");
			Long id = sc.nextLong();
			System.out.print("Digite a quantidade de livros a serem removidos: ");
			int quantidade = sc.nextInt();
			
			if(Biblioteca.removerLivroParcial(id, quantidade)) {
			    System.out.println("Quantidade de livro(s) removido(s)!");
			} else {
				System.err.println("Falha ao remover");
			}
			
		} catch (Exception e) {
			System.err.println("Entrada inválida!");
			sc.nextLine();
		}
    }

    public static void telaRemoverBibliotecario() {
        try {
			System.out.print("Digite a matrícula do bibliotecário a serem removidos: ");
			Long matricula = sc.nextLong();

			
			
			if(Biblioteca.removerBibliotecario(matricula)) {
			    System.out.println("Bibliotecário removido!");
			} else {
				System.out.println("Bibliotecário não encontrado!");
			}
		} catch (Exception e) {
			System.err.println("Matrícula inválida!");
			sc.nextLine();
		}
    }
  	
    public static void telaRemoverCliente() {
        try {
			System.out.print("Digite o cpf do cliente a ser removido: ");
			Long cpf = sc.nextLong();
			
			if(Biblioteca.removerCliente(cpf)) {
			    System.out.println("Cliente removido!");
			} else {
				System.out.println("Cliente não encontrado!");
			}
		} catch (Exception e) {
			System.err.println("Cpf inválido!");
			sc.nextLine();
		}
    }
    
    public static void telaEmprestimo() {
    	
    	//Variaveis
    	Long cpf, id;
    	String data;
    	
    	//Dados iniciais
    	try {
			sc.nextLine();
			System.out.print("Digite o cpf do cliente solicitante: ");
			cpf = sc.nextLong();
			System.out.print("Digite o id do livro a ser emprestado: ");
			id = sc.nextLong();
			System.out.print("Digite a data do empréstimo (dd/mm/yyyy): ");
			data = sc.next();
			
			//FORMARTAR DATA DE EMPRESTIMO A PARTIR DA STRING
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				
				//Instanciar data 
				Date date = formatter.parse(data);
				
				//Adicionar no arquivo
	            String linha = cpf+";"+id+";"+data+";false;\n";
	            
				//Registrar emprestimo			
				if(Biblioteca.alugarLivroBiblioteca(cpf, id, date, false)) {
					
					Arquivo.Write("emprestimo.txt", linha);
					Date dataDev;
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, 14);
					dataDev = cal.getTime();
					
					SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
			        String dtDevolver = f1.format(dataDev);
					
					System.out.println("Empréstimo realizado com sucesso!");
					System.out.println("O cliente deve devolver o livro até dia " + dtDevolver + ".\n");
					
				} else {
					System.err.println("Falha ao realizar empréstimo.");
					sc.nextLine();
				}
			}  catch (ParseException e) {
				System.err.println("Falha ao realizar empréstimo.");
				sc.nextLine();
			}
		} catch (Exception e) {
			System.err.println("Entrada inválida!");
			sc.nextLine();
		}

    }
    
    public static void telaDevolucao() {
    	
        //Variaveis
        Long cpf, id;

        //Dados iniciais
        try {
        	
			sc.nextLine();
			System.out.print("Digite o cpf do cliente: ");
			cpf = sc.nextLong();
			System.out.print("Digite o id do livro a ser devolvido: ");
			id = sc.nextLong();

			if(Biblioteca.devolverLivroBiblioteca(cpf, id)) {
			    System.out.println("Livro devolvido com sucesso!");
			}
			else {
			    System.err.println("Erro ao devolver livro. Dados inválidos!");
			}
		} catch (Exception e) {
			System.err.println("Entrada inválida!");
			sc.nextLine();
		}
    }

}
