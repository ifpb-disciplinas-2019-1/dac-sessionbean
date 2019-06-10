package br.edu.ifpb;

import br.edu.ifpb.chat.Chat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/05/2019, 10:29:55
 */
public class App {
//Informações:   Glassfish-specific (Non-portable) JNDI names for EJB 
//    CarrinhoDeCompras: [br.edu.ifpb.carrinho.Carrinho#br.edu.ifpb.carrinho.Carrinho, 
//                           br.edu.ifpb.carrinho.Carrinho]

//    Informações:   Portable JNDI names for EJB ChatOnline: 
//    [java:global/sessionbeans/ChatOnline, 
//    java:global/sessionbeans/ChatOnline!br.edu.ifpb.chat.Chat]
    public static void main(String[] args) throws Exception {
//        Clientes clientes = lookup(
//            "java:global/sessionbeans/ClientesEmJDBC"
//        );
//        clientes.todos().forEach(c -> System.out.println(c.getNome()));
//        Carrinho carrinho = lookup(
//            "java:global/app/CarrinhoDeCompras!br.edu.ifpb.carrinho.Carrinho"
//        );
//
//        carrinho.novo("TV");
//        carrinho.novo("PC");
//        carrinho.novo("Computador");
//        carrinho.excluir("TV");
//        carrinho.finalizar();
//
//        carrinho = lookup(
//            "java:global/app/CarrinhoDeCompras!br.edu.ifpb.carrinho.Carrinho"
//        );
//        carrinho.novo("TV");
////        Thread.sleep(60000);
//        carrinho.novo("PC");
//        carrinho.finalizar();
//        System.setProperty(
//            "java.security.auth.login.config",
//            "/Users/job/Documents/dev/testes/20191/dac-sessionbean-jse/src/main/resources/auth.conf"
//        );

        Chat chat = lookup(
            "java:global/sessionbeans/ChatOnline!br.edu.ifpb.chat.Chat"
        );

        System.out.println("-----------");
        chat.historico().forEach(System.out::println);
        chat.nova("Enviado pelo JSE");
        System.out.println("-----------");
        chat.historico().forEach(System.out::println);
        System.out.println("-----------");


    }

    private static <T> T lookup(String resource) {
        try {
            //ip
            //porta
            // ConnectionFactory
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort","3701");
            Context context = new InitialContext(props);
            return (T) context.lookup(resource);
        } catch (NamingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    private static <T> T lookupRemote(String string) {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort","3701");
            props.setProperty("java.naming.factory.url.pkgs",
                              "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state",
                              "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty(Context.SECURITY_PRINCIPAL,"admin");
            props.setProperty(Context.SECURITY_CREDENTIALS,"admin");
            props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout",
                              "5000");
            props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts",
                              "100:500:100:500");
            props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts",
                              "500:2000:50:1000");
            props.setProperty("https.protocols","TLSv1,TLSv1.1,TLSv1.2");
            Context context = new InitialContext(props);
            return (T) context.lookup(string);
        } catch (NamingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}

//            props.setProperty("java.naming.factory.initial",
//                              "com.sun.enterprise.naming.SerialInitContextFactory");
//            props.setProperty("java.naming.factory.url.pkgs",
//                              "com.sun.enterprise.naming");
//            props.setProperty("java.naming.factory.state",
//                              "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//            props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
//            props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
//            props.put(Context.SECURITY_PRINCIPAL,"admin");
//            props.put(Context.SECURITY_CREDENTIALS,"admin");
//            props.setProperty("https.protocols","TLSv1,TLSv1.1,TLSv1.2");
//            Context context = new InitialContext(props);
//            NamingEnumeration<NameClassPair> list2 = context.list(context.getNameInNamespace());
//            while (list2.hasMore()) {
//                System.out.println(list2.next());
//            }
