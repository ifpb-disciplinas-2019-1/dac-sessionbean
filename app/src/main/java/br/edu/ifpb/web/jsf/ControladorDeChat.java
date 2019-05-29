package br.edu.ifpb.web.jsf;

import br.edu.ifpb.chat.Chat;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2019, 10:43:41
 */
@RequestScoped
@Named
public class ControladorDeChat {

    @EJB
    private Chat chat;
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String enviar() {
        this.chat.nova(mensagem);
        this.mensagem = "";
        return null;
    }

    public List<String> todas() {
        return this.chat.historico();
    }
}
