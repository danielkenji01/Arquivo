package model;

public class Planilha {

	private String nome;
	
	private String[] cabecalho;
	
	private Linha[] linhas;
	
	public Planilha(String nome, String[] cabecalho, Linha[] linhas) {
		this.nome = nome;
		this.cabecalho = cabecalho;
		this.linhas = linhas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String[] cabecalho) {
		this.cabecalho = cabecalho;
	}

	public Linha[] getLinhas() {
		return linhas;
	}

	public void setLinhas(Linha[] linhas) {
		this.linhas = linhas;
	}
	
	public String getNomeFormatado() {
		return this.nome + ".csv";
	}
	
}
