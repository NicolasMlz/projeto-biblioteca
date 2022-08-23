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
		for(Livro l : livros) {
			if(l.getId().equals(livro.getId())) {
				return false;
			}
		}	
		
		livros.add(livro);	
		return true;
	}

	public static boolean adicionarLivroQtde(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				l.atualizarQtde(qtde);
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
				return true;
			}
		}	
		
		return false;
	}

	public static boolean removerLivroTotal(Long id) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				livros.remove(l);
				return true;
			}
		}	
		
		return false;
	}

	public static boolean removerLivroParcial(Long id, int qtde) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				if((l.getQtdeTotal() - l.getQtdeDisponiveis()) <= qtde) 
					qtde = (l.getQtdeTotal() - l.getQtdeDisponiveis()) * -1;
				else 
					qtde *= -1;
				
				l.atualizarQtde(qtde);
				return true;
			}
		}
		
		return false;
	}

	public static boolean removerCliente(Long cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cpf)) {
				clientes.remove(c);
				return true;
			}
		}	
		
		return false;
	}

	public static boolean alterarBibliotecario(Long matricula, Bibliotecario b) {
		
		if(removerBibliotecario(matricula)) {
			removerBibliotecario(matricula);
			if(adicionarBibliotecario(b)) {
				adicionarBibliotecario(b);
				return true;
			}
		}
		
		return false;
	}

	public static boolean alterarCliente(Long cpf, Cliente cliente) {
		
		if(removerCliente(cpf)) {
			removerCliente(cpf);
			if(adicionarCliente(cliente)) {
				adicionarCliente(cliente);
				return true;
			}
		}
		
		return false;
	}

	public static boolean alterarLivro(Long id, Livro livro) {
		
		if(removerLivroTotal(id)) {
			removerLivroTotal(id);
			if(adicionarLivroNovo(livro)) {
				adicionarLivroNovo(livro);
				return true;
			}
		}
		
		return false;
	}

	public static String consultarLivroUnico(Long id) {
		for(Livro l : livros) {
			if(l.getId().equals(id)) {
				return l.toString();
			}
		}	
		
		return "";
	}
	
	public static String consultarLivroUnico(String nome) {
		
		String todos = "";
		
		for(Livro l : livros) {
			if(l.getTitulo().equals(nome)) {
				todos += l.toString();
				todos+="\n";
			}
		}	
		
		return todos;
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
		
		return "";
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
		
		return "";
	}

	public static String consultarClientesTotais() {
		
		String t = "";
		
		for(Cliente c : clientes) {
			t += c.toString() + "\n";
		}
		
		return t;		
	}
	
}