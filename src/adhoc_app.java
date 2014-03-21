
import java.io.IOException;
import static java.lang.Boolean.TRUE;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuno
 */
public class adhoc_app implements Runnable{
    ArrayList<tabela> tabela_route;
    adhoc_app(){
        tabela_route = new ArrayList<tabela>();
       
    }
    
    
     ArrayList<tabela> getTabela(){
           ArrayList<tabela> aux = new ArrayList<tabela>();
            for(tabela tab:tabela_route)
                aux.add(tab);
           return aux;
       }
       
   
  public void run(){
    byte[] aReceber= new byte[1024];
    while(true) {
        try {
            DatagramPacket pedido= new DatagramPacket(aReceber,aReceber.length);
            InetAddress group = InetAddress.getByName("FF02::1");
            MulticastSocket socket = new MulticastSocket(9999);
            socket.joinGroup(group);
            socket.receive(pedido);
         
            System.out.print(pedido.getAddress());
            String pedidoString = new String(pedido.getData(), 0,pedido.getLength());
            System.out.println(pedidoString);
            //InetAddress IPAddress=group;
            //int porta=pedido.getPort();
            //byte[] aEnviar=pedidoString.toUpperCase().getBytes();
            //DatagramPacket resposta= new DatagramPacket(aEnviar,aEnviar.length,IPAddress,porta);
            //s.send(resposta);
            //System.out.println("enviou");
        }catch (IOException ex) {
            Logger.getLogger(adhoc_app.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 }
  
  
 public static void main(String [] args) throws InterruptedException{
   
     adhoc_app ap = new adhoc_app();
     Thread worker = new Thread(ap);
     worker.start();
     while(true){
        Adhoccliente ac = new Adhoccliente(ap.getTabela());
        Thread cliente = new Thread(ac);
        cliente.start();
        sleep(10000);   
     }
 }   
}
   
