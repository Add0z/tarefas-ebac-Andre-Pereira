/**
 * 
 */
package controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = -784519597996507487L;

	public String redirectCliente() {
		return "/cliente/list.xhtml";
	}
	
	public String redirectProduto() {
		return "/produto/list.xhtml";
	}
	
	public String redirectVenda() {
		return "/venda/list.xhtml";
	}
	
	public String redirectVendaProd() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, String> requestParams = facesContext.getExternalContext().getRequestParameterMap();
        String prodNome = requestParams.get("prodNome");

        
        return "venda.xhtml?faces-redirect=true";
    }
		
}

