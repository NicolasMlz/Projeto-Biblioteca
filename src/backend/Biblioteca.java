package backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import arquivoTXT.Arquivo;

public class Biblioteca {
	
	//ATRIBUTOS
	static List<Bibliotecario> bibliotecarios = new ArrayList<>();
	static List<Emprestimo> emprestimos = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();
	static List<Livro> livros = new ArrayList<>();
	
	
	//CONSTRUTOR
	private Biblioteca() {
		
	}

	
	//METODOS
	public static String consultarEmprestimosTotais() {
		
		String resultado="";
		
		for(Emprestimo e : emprestimos) {
			resultado += e.toString();
		}
		
		return resultado;
	}
	
	public static String consultarEmprestimosAtrasados() {
		
		String resultado="";
		
		for(Emprestimo e : emprestimos) {
			if(e.emprestimoAtrasado()) {
				resultado += e.toString();
			}
		}
		
		return resultado;		
	}
	
	public static boolean alugarLivroBiblioteca(Long cpf_cliente, Long id_livro, Date dataEmprestimo, boolean ldev) {
		
        Emprestimo e = new Emprestimo(cpf_cliente, id_livro, dataEmprestimo, ldev);

        if(e.alugarLivro()) {
            emprestimos.add(e);
            return true;
        }
        
        return false;
    }
	
    public static boolean devolverLivroBiblioteca(Long cpf_cliente, Long id_livro) {

        for(Emprestimo e : emprestimos) {
            if(e.getCpf_cliente().equals(cpf_cliente) && e.getId_livro().equals(id_livro)) {
            	
                e.devolverLivro();
                
                //Adicionar no arquivo
                SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		        String dataFormatada = f1.format(e.getDataEmprestimo());
	           
		        String linha = e.getCpf_cliente()+";"+e.getId_livro()+";"+dataFormatada+";"+"false"+";";
	            Arquivo.Remove("emprestimo.txt", linha);
	            linha = e.getCpf_cliente()+";"+e.getId_livro()+";"+dataFormatada+";"+"true"+";";
	            Arquivo.Write("emprestimo.txt", linha);
	            
                return true;
            }
        }

        return false;
    }
	
	public static boolean loginCorreto(String login, String senha) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getLogin().equals(login) && b.getSenha().equals(senha)) {
				return true;
			}
		}	
		
		return false;
	}
	
	public static boolean adicionarBibliotecario(Bibliotecario bibliotecario) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula().equals(bibliotecario.getMatricula())) {
				
				return false;
			}
		}
		bibliotecarios.add(bibliotecario);
		return true;
	}

	public static boolean adicionarLivroNovo(Livro livro) {
		
		for(Livro l : getLivros()) {
			if(l.getId().equals(livro.getId())) {
				return false;
			}
		}	
		
		//Salvar no array
		getLivros().add(livro);	
		return true;
	}

	public static boolean adicionarLivroQtde(Long id, int qtde) {
		for(Livro l : getLivros()) {
			if(l.getId().equals(id)) {
				
				//Remover livro do arquivo
				String linha = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
						+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";";
				Arquivo.Remove("livro.txt", linha);
				
				//Atualizar livro
				l.atualizarQtde(qtde);
				
				//Reescrever no arquivo
				linha = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
						+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";\n";
				Arquivo.Write("livro.txt", linha);
				
				return true;
			}
		}
		
		return false;
	}

	public static boolean adicionarCliente(Cliente cliente) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cliente.getCpf())) {
				return false;
			}
		}	
		clientes.add(cliente);
		return true;
	}

	public static boolean removerBibliotecario(Long matricula) {
		for(Bibliotecario b : bibliotecarios) {
			if(b.getMatricula().equals(matricula)) {
				bibliotecarios.remove(b);
				
				//Passar a linha como parametro para remocao
				String linha = b.getCpf()+";"+b.getNome()+";"+b.getTelefone()+";"+b.getMatricula()+";"+b.getLogin()+";"+b.getSenha()+";";
				Arquivo.Remove("bibliotecario.txt", linha);
				
				return true;
			}
		}	
		
		return false;
	}

	public static boolean removerLivroTotal(Long id) {
		for(Livro l : getLivros()) {
			if(l.getId().equals(id)) {
			
				if(l.getQtdeTotal() == l.getQtdeDisponiveis()) {
					
					//Passar a linha como parametro para remocao
					String linha = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
							+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";";
					Arquivo.Remove("livro.txt", linha);
					getLivros().remove(l);
				} else {
					
					int qtde = l.getQtdeTotal() - l.getQtdeDisponiveis();
					
					Livro li = new Livro(l.getId(), l.getTitulo(), l.getAutor(), l.getEditora(), l.getEdicao(), l.getGenero(), qtde);
					li.setQtdeDisponiveis(0);
					
					String linha2 = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
							+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";";
					Arquivo.Remove("livro.txt", linha2);
					getLivros().remove(l);
					
					String linha = li.getId()+";"+li.getTitulo()+";"+li.getAutor()+";"+li.getEditora()+";"
							+li.getEdicao()+";"+li.getGenero()+";"+li.getQtdeTotal()+";";
					Arquivo.Write("livro.txt", linha);
					getLivros().add(li);
				}
				
				return true;
			}
		}	
		
		return false;
	}

	public static boolean removerLivroParcial(Long id, int qtde) {
		for(Livro l : getLivros()) {
			if(l.getId().equals(id)) {
				if(l.getQtdeDisponiveis() <= qtde) 
					qtde =  l.getQtdeDisponiveis() * (-1);
				else 
					qtde *= -1;
			
				
				//Remover livro do arquivo
				String linha = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
						+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";";
				Arquivo.Remove("livro.txt", linha);
				
				//Atualizar livro
				l.atualizarQtde(qtde);
				
				//REescrever no arquivo
				linha = l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getEditora()+";"
						+l.getEdicao()+";"+l.getGenero()+";"+l.getQtdeTotal()+";";
				Arquivo.Write("livro.txt", linha);
				
				return true;
			}
		}
		
		return false;
	}

	public static boolean removerCliente(Long cpf) {
		for(Cliente c : clientes) {
				if(c.getCpf().equals(cpf)) {
					if(c.getLivrosAlugados().size() == 0) {
					clientes.remove(c);
					
					//Passar a linha como parametro para remocao
					String linha = c.getCpf()+";"+c.getNome()+";"+c.getTelefone()+";"+c.getEmail()+";";
					Arquivo.Remove("cliente.txt", linha);
					
					return true;
				}
			}
		}	
		
		return false;
	}

	public static boolean alterarBibliotecario(Long matricula, Bibliotecario b) {
		
		if(removerBibliotecario(matricula)) {
			if(adicionarBibliotecario(b)) {
				//Passar a linha como parametro para remocao
				String linha = b.getCpf()+";"+b.getNome()+";"+b.getTelefone()+";"+b.getMatricula()+";"+b.getLogin()+";"+b.getSenha()+";";
				Arquivo.Write("bibliotecario.txt", linha);
				return true;
			}
		}
		
		return false;
	}

	public static boolean alterarCliente(Long cpf, Cliente c) {
		
		if(removerCliente(cpf)) {
			if(adicionarCliente(c)) {
				//Passar a linha como parametro para remocao
				String linha = c.getCpf()+";"+c.getNome()+";"+c.getTelefone()+";"+c.getEmail()+";";
				Arquivo.Write("cliente.txt", linha);
				return true;
			}
		}
		
		return false;
	}

	public static boolean alterarLivro(Long id, Livro livro) {
		
		
		if(removerLivroTotal(id)) {
			if(adicionarLivroNovo(livro)) {
				
				String linha = livro.getId()+";"+livro.getTitulo()+";"+livro.getAutor()+";"+livro.getEditora()+";"
						+livro.getEdicao()+";"+livro.getGenero()+";"+livro.getQtdeTotal()+";";
				Arquivo.Write("livro.txt", linha);
				return true;
			}
		}
		
		return false;
	}

	public static String consultarLivroUnico(Long id) {
		for(Livro l : getLivros()) {
			if(l.getId().equals(id)) {
				return l.toString();
			}
		}	
		
		return "Livro não cadastrado!";
	}
	
	public static String consultarLivroUnico(String nome) {
		for(Livro l : getLivros()) {
			if(l.getTitulo().equalsIgnoreCase(nome)) {
				return l.toString();
			}
		}	
		
		return "Livro não cadastrado!\n";
	}

	public static String consultarLivrosTotais() {
		
		String t = "";
		
		for(Livro l : getLivros()) {
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
		
		return "Matrícula não cadastrada!";
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
		
		return "Cliente não cadastrado!";
	}

	public static String consultarClientesTotais() {
		
		String t = "";
		
		for(Cliente c : clientes) {
			t += c.toString() + "\n";
		}
		
		return t;		
	}
	
	public static List<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }


	public static List<Livro> getLivros() {
		return livros;
	}


	public static List<Cliente> getClientes() {
		return clientes;
	}


	public static void setClientes(List<Cliente> clientes) {
		Biblioteca.clientes = clientes;
	}
	
}
