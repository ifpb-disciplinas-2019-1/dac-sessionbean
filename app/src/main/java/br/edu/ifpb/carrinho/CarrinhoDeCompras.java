package br.edu.ifpb.carrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 24/05/2019, 08:13:07
 */
@Stateful
@Remote(Carrinho.class)
@StatefulTimeout(unit = TimeUnit.SECONDS, value = 30)
public class CarrinhoDeCompras implements Carrinho {

    private List<String> produtos = new ArrayList<>();

    public void novo(String produto) {
        this.produtos.add(produto);
    }

    public void excluir(String produto) {
        this.produtos.remove(produto);
    }

    public List<String> todos() {
        return Collections
            .unmodifiableList(produtos);
    }

    @Remove
    public void finalizar() {
        System.out.println("---- Listando os produtos -----");
        this.produtos.forEach(System.out::println);
    }
}
