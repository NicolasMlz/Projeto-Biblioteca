package arquivosTXT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;
import backend.Livro;

public class Arquivo {

	//Contrutor privado
	private Arquivo() {

	}
	
	//Escrever no arquivo
    public static boolean Write(String Caminho,String Texto){
        try {
            FileWriter arq = new FileWriter(Caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
	
    //Ler o arquivo
    public static String ReadLivro(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            int i=0;
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha;
                    
                    Long id = Long.parseLong(conteudo.split(";")[i]); i++;
                    String nome = conteudo.split(";")[i]; i++;
                    String autor = conteudo.split(";")[i]; i++;
                    String editora = conteudo.split(";")[i]; i++;
                    int edicao = (int) Integer.parseInt(conteudo.split(";")[i]); i++;
                    String genero = conteudo.split(";")[i]; i++;
                    int qtde = (int) Integer.parseInt(conteudo.split(";")[i]); i++;
                    Biblioteca.adicionarLivroNovo(new Livro(id, nome, autor, editora, edicao, genero, qtde));
                    
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }  
    public static String ReadCliente(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            int i=0;
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha;
                    
                    Long id = Long.parseLong(conteudo.split(";")[i]); i++;
                    String nome = conteudo.split(";")[i]; i++;
                    String telefone = conteudo.split(";")[i]; i++;
                    String email = conteudo.split(";")[i]; i++;
                    Biblioteca.adicionarCliente(new Cliente(id, nome, telefone, email));
                    
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
    public static String ReadBibliotecario(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            int i=0;
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha;
                    
                    Long id = Long.parseLong(conteudo.split(";")[i]); i++;
                    String nome = conteudo.split(";")[i]; i++;
                    String telefone = conteudo.split(";")[i]; i++;
                    Long matricula = Long.parseLong(conteudo.split(";")[i]); i++;
                    String login = conteudo.split(";")[i]; i++;
                    String senha = conteudo.split(";")[i]; i++;
                    Biblioteca.adicionarBibliotecario(new Bibliotecario(id, nome, telefone, matricula, login, senha));
                    
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    //Remover arquivo
    public static boolean Remove(String Caminho,  String instancia){
    	
		//Acessar arquivo
		File arq = new File(Caminho);
		
		try {
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			
			String linha = br.readLine();
			ArrayList<String> salvar = new ArrayList<>();
			
			while(linha != null) {
				if(linha != instancia) {
					salvar.add(linha);
				}
				linha = br.readLine();
			}
			
			br.close();
			fr.close();
			FileWriter fw2 = new FileWriter(arq, true);
			fw2.close();
			
			FileWriter fw = new FileWriter(arq);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0; i<salvar.size(); i++) {
				
			}
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }
}
