package backend;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	//ATRIBUTOS
	static List<Bibliotecario> bibliotecarios = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();
	static List<Livro> livros = new ArrayList<>();
	
	
	//CONSTRUTOR
	private Biblioteca() {
		
	}


	//METODOS
	
	public static boolean loginCorreto(String login, String senha) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getLogin().equals(login) && b.getSenha().equals(senha)) {
				return true;
			}
		}	
		
		return false;
	}
	
	public static void adicionarBibliotecario(Bibliotecario bibliotecario) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula().equals(bibliotecario.getMatricula())) {
				System.out.println("Bibliotecario já cadastrado!");
				break;
			}
		}
		
		bibliotecarios.add(bibliotecario);
	}

	public static void adicionarLivroNovo(Livro livro) {
		for(Livro l : livros) {
			if(l.getId().equals(livro.getId())) {
				System.out.println("Livro já cadastrado!");
				break;
			}
		}	
		
		livros.add(livro);	
	}

	public static void adicionarLivroQtde(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				l.atualizarQtde(qtde);
			}
		}
	}

	public static void adicionarCliente(Cliente cliente) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cliente.getCpf())) {
				System.out.println("Cliente já cadastrado!");
				break;
			}
		}	
		
		clientes.add(cliente);
	}

	public static void removerBibliotecario(Long matricula) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula().equals(matricula)) {
				bibliotecarios.remove(b);
				break;
			}
		}		
	}

	public static void removerLivroTotal(Long id) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				livros.remove(l);
				break;
			}
		}		
	}

	public static void removerLivroParcial(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				l.atualizarQtde(qtde);
				break;
			}
		}
	}

	public static void removerCliente(Long cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cpf)) {
				clientes.remove(c);
				break;
			}
		}		
	}

	public static void alterarBibliotecario(Long matricula, Bibliotecario b) {
		removerBibliotecario(matricula);
		adicionarBibliotecario(b);
	}

	public static void alterarCliente(Long cpf, Cliente cliente) {
		removerCliente(cpf);
		adicionarCliente(cliente);
	}

	public static void alterarLivro(Long id, Livro livro) {
		removerLivroTotal(id);
		adicionarLivroNovo(livro);
	}

	public static String consultarLivroUnico(Long id) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				return l.toString();
			}
		}	
		
		return "Livro não encontrado!";
	}

	public static String consultarLivrosTotais() {
		
		String t = "";
		
		for(Livro l : livros) {
			t += l.toString() + "\n";
		}
		
		return t;
	}

	public static String consultarBibliotecarioUnico(Long matricula) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula().equals(matricula)) {
				return b.toString();
			}
		}	
		
		return "Bibliotecario não encontrado!";
	}

	public static String consultarBibliotecariosTotais() {
		
		String t = "";
		
		for(Bibliotecario b : bibliotecarios) {
			t += b.toString() + "\n";
		}
		
		return t;		
	}

	public static String consultarClienteUnico(Long cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cpf)) {
				return c.toString();
			}
		}
		
		return "Cliente não encontrado!";
	}

	public static String consultarClientesTotais() {
		
		String t = "";
		
		for(Cliente c : clientes) {
			t += c.toString() + "\n";
		}
		
		return t;		
	}
	
}
