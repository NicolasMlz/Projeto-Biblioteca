package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements OperacoesInterface {
	
	//ATRIBUTOS
	static List<Bibliotecario> bibliotecarios = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();
	static List<Livro> livros = new ArrayList<>();
	
	
	//CONSTRUTOR
	private Biblioteca() {
		
	}


	//METODOS
	@Override
	public void adicionarBibliotecario(Bibliotecario bibliotecario) {
		if(!bibliotecarios.contains(bibliotecario)) bibliotecarios.add(bibliotecario);
	}

	@Override
	public void adicionarLivroNovo(Livro livro) {
		if(!livros.contains(livro)) livros.add(livro);	
	}

	@Override
	public void adicionarLivroQtde(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId() == id) {
				l.atualizarQtde(qtde);
			}
		}
	}

	@Override
	public void adicionarCliente(Cliente cliente) {
		if(!clientes.contains(cliente)) clientes.add(cliente);
	}

	@Override
	public void removerBibliotecario(Long matricula) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula() == matricula) {
				bibliotecarios.remove(b);
			}
		}		
	}

	@Override
	public void removerLivroTotal(Long id) {
		for(Livro l : livros) {
			if(l.getId() == id) {
				livros.remove(l);
			}
		}		
	}

	@Override
	public void removerLivroParcial(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId() == id) {
				l.atualizarQtde(qtde);
			}
		}
	}

	@Override
	public void removerCliente(Long cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf() == cpf) {
				clientes.remove(c);
			}
		}		
	}

	@Override
	public void alterarBibliotecario(Long matricula, Bibliotecario b) {
		removerBibliotecario(matricula);
		adicionarBibliotecario(b);
	}

	@Override
	public void alterarCliente(Long cpf, Cliente cliente) {
		removerCliente(cpf);
		adicionarCliente(cliente);
	}

	@Override
	public void alterarLivro(Long id, Livro livro) {
		removerLivroTotal(id);
		adicionarLivroNovo(livro);
	}

	@Override
	public String consultarLivroUnico(Long id) {
		for(Livro l : livros) {
			if(l.getId() == id) {
				return l.toString();
			}
		}	
		
		return "Livro não encontrado!";
	}

	@Override
	public String consultarLivrosTotais() {
		
		String t = "";
		
		for(Livro l : livros) {
			t += l.toString() + "\n";
		}
		
		return t;
	}

	@Override
	public String consultarBibliotecarioUnico(Long matricula) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula() == matricula) {
				return b.toString();
			}
		}	
		
		return "Bibliotecario não encontrado!";
	}

	@Override
	public String consultarBibliotecariosTotais() {
		
		String t = "";
		
		for(Bibliotecario b : bibliotecarios) {
			t += b.toString() + "\n";
		}
		
		return t;		
	}

	@Override
	public String consultarClienteUnico(Long cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf() == cpf) {
				return c.toString();
			}
		}
		
		return "Cliente não encontrado!";
	}

	@Override
	public String consultarClientesTotais() {
		
		String t = "";
		
		for(Cliente c : clientes) {
			t += c.toString() + "\n";
		}
		
		return t;		
	}
	
}
