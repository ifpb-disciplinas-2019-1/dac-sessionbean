package br.edu.ifpb.web.jsf;

import br.edu.ifpb.carrinho.Carrinho;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 24/05/2019, 08:22:48
 */
@SessionScoped
@Named
public class ControladorDeCarrinho implements Serializable {

    private String produto;

//    @Inject
    @EJB
    private Carrinho carrinho;

    public String adicionar() {
        this.carrinho.novo(produto);
        this.produto = "";
        return null;
    }

    public String remover(String produto) {
        this.carrinho.excluir(produto);
        return null;
    }

    public String finalizar() {
        this.carrinho.finalizar();
        finalizarSessao();
        return "carrinho.xhtml?faces-redirect=true";
    }

    public List<String> todos() {
        return this.carrinho.todos();
    }

    private void finalizarSessao() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext()
            .getSession(true);
        session.invalidate();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

}
