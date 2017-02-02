package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.drogaria.util.JSFUtil;


@ManagedBean(name = "MBLogin")
public class LoginBean {
	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login1() {
		if (login.equals("adm") && senha.equals("123")) {
			try{
			JSFUtil.adicionarMessagemSucesso("Login efetuado com sucesso");
			FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml"); 
			}catch(Exception e){
				JSFUtil.adicionarMessagemErro(e.getMessage());
			}
			} else {
			JSFUtil.adicionarMessagemErro("Erro ao logar");
		}
		
	return null;
	}
}