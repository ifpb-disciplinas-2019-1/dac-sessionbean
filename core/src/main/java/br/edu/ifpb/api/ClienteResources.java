package br.edu.ifpb.api;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/05/2019, 11:04:56
 */
@Path("cliente")
@Stateless
public class ClienteResources {

    @EJB
    private Clientes clientes;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente[] todos() {
        return this.clientes.todos().toArray(new Cliente[]{});
    }
}
