package arquivoTXT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Cliente;
import backend.Livro;

public class Arquivo {

	//Contrutor privado
	private Arquivo() {

	}
	
	//Escrever no arquivo
    public static boolean Write(String Caminho, String Texto){
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
	
    //Remover arquivo
    public static boolean Remove(String Caminho,  String instancia){
    	
		//Acessar arquivo
		File arq = new File(Caminho);
		
		//Remover instancia do arquivo
		try {
			
			//Ler arquivo
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			
			//Armazenar linha por linha
			String linha = br.readLine();
			
			//Salvar linhas do arquivo em um array
			ArrayList<String> salvar = new ArrayList<>();
			
			//Salvar no array todas as linhas menos a removida
			while(linha != null) {
				if(linha.equals(instancia) == false) {
					salvar.add(linha);
				}
				linha = br.readLine();
			}
			
			//Excluir arquivo
			br.close();
			fr.close();
			FileWriter fw2 = new FileWriter(arq, true);
			fw2.close();
			
			//Criar novo arquivo
			FileWriter fw = new FileWriter(arq);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Armazenar array no novo arquivo
			for(int i=0; i<salvar.size(); i++) {
				bw.write(salvar.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
			
			return true;
			
		} catch (IOException e) {
			
			//Tratar excessao
			e.printStackTrace();
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
    public static String ReadEmprestimo(String Caminho){
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
                    
                    Long idCliente = Long.parseLong(conteudo.split(";")[i]); i++;
                    Long idLivro = Long.parseLong(conteudo.split(";")[i]); i++;
                    String data = conteudo.split(";")[i]; i++;
                    String bool = conteudo.split(";")[i]; i++;
                    
                    boolean livroDevolvido ;
                    if (bool.equals("true")) livroDevolvido = true;
                    else livroDevolvido = false;
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(data);
                    Biblioteca.alugarLivroBiblioteca(idCliente, idLivro, date, livroDevolvido);
                    
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException | ParseException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }    
    
}