package br.fatec.exercicio4;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user") // declara classe para ser acessível
@RequestScoped // request - deve durar desde qdo usuario enviar a requisicao até servidor
				// devolver

public class UsuarioBean {
	private String nome;
	private String email;
	private String senha;
	private String confirmasenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmasenha() {
		return confirmasenha;
	}

	public void setConfirmasenha(String confirmasenha) {
		this.confirmasenha = confirmasenha;
	}

	public String operacao() {
		// executa operacao
		return "resultado"; // se desejar que a página que está sendo exibida não mude
		// return null
	}

	public String novo() {
		return "usuario"; // esta retornando apelido da página, precisa mapear em faces-config.xml
	}// instância FacesContext representa todo a informação contextual associada com
		// o
		// processamento de uma solicitação de entrada e criação de uma resposta

	public String Salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.senha.equalsIgnoreCase(this.confirmasenha)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "senhas diferentes", ""));
			return "usuario";
		}
		// no futuro salvara em banco de dados
		return "mostrausuario";
	}

}
