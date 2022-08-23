package backend;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	
	//ATRIBUTOS
	private String email;
	private List<Livro> livrosAlugados = new ArrayList<>();
	
	//CONSTRUTOR
	public Cliente(Long cpf, String nome, String telefone, String email) {
        super(cpf, nome, telefone);
        this.email = email;
    }

	//METODOS
	@Override
	public String toString() {
		return super.toString() + " - Email: " + email + " - Livros alugados: " + livrosAlugados + "\n";
	}
	public void adicionarLivroAlugado(Livro livro) {
        livrosAlugados.add(livro);
    }
    public void removerLivroAlugado(Livro livro) {
        livrosAlugados.remove(livro);
    }
	
	//GETTERS E SETTERS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Livro> getLivrosAlugados() {
		return livrosAlugados;
	}
	public void setLivrosAlugados(List<Livro> livrosAlugados) {
		this.livrosAlugados = livrosAlugados;
	}
	
}