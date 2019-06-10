package br.edu.ifpb.carrinho;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 24/05/2019, 08:47:25
 */
public interface Carrinho {

    void excluir(String produto);

    void finalizar();

    void novo(String produto);

    List<String> todos();

}
