package br.edu.ifpb.chat;


import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2019, 10:57:34
 */
public interface Chat {

    List<String> historico();

    void nova(String mensagem);

}
