package com.example.contatos;

public class Contato {
	
	private String nome;
	private String telefone;
	private String URL;
	private String imagem;
	
	public Contato(String nome, String telefone, String uRL, String imagem) {		
		this.nome = nome;
		this.telefone = telefone;
		URL = uRL;
		this.setImagem(imagem);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	

}
