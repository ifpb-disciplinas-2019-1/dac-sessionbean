package br.edu.ifpb.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2019, 11:19:45
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Startup
@DependsOn("ChatOnline")
public class SalaDeBatepapo {

    private List<String> mensagens = new ArrayList<>();

    private Object lock = new Object();

//    public synchronized void nova(String mensagem) {
    public void nova(String mensagem) {
//        synchronized (this) {
        synchronized (lock) {
            this.mensagens.add(mensagem);
        }
        // imaginem 100 linhas de código
    }

//    public static void remover() {
//        synchronized (SalaDeBatepapo.class) {
//        }
//    }

    public List<String> historico() {
        return Collections
            .unmodifiableList(mensagens);
    }

}
