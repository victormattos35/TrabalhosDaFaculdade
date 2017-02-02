package br.com.mercado.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.mercado.DAO.LoginDAO;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name = "MBLogin")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1967933235700231365L;
	private String senha;
	private String mensagem;
	private Long idfuncionario;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(Long idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	// validate login
	public void validateUsernamePassword() {
		boolean valid = LoginDAO.validate(idfuncionario, senha);
		try {
			if (valid) {
				JSFUtil.adicionarMessagemSucesso("Logado com Sucesso!");
				HttpSession session = SessionBean.getSession();
				session.setAttribute("username", idfuncionario);
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/TCC/faces/paginas/indexGeral.xhtml");
				
		
			} else {
				JSFUtil.adicionarMessagemErro("Usuário ou senha incorretos!");
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/TCC/faces/paginas/login.xhtml");
				
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
	}
}
