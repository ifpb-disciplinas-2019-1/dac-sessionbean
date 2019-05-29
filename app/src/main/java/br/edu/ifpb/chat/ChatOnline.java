package br.edu.ifpb.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2019, 10:36:54
 */
@Singleton
@Remote(Chat.class)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
//@Lock(LockType.READ)
public class ChatOnline implements Chat {

    private List<String> mensagens = new ArrayList<>();

    @Override
    @Lock(LockType.WRITE)
    public  void nova(String mensagem) {
        this.mensagens.add(mensagem);
    }

    @Override
    @Lock(LockType.READ)
    public List<String> historico() {
        return Collections
            .unmodifiableList(mensagens);
    }
}
