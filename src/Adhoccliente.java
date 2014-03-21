/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Adhoccliente implements Runnable
{

    
ArrayList<tabela> tabela_route;
       Adhoccliente(ArrayList<tabela> t){
           tabela_route = new ArrayList<tabela>();
           for(tabela tab:t)
                tabela_route.add(tab);
       } 
      
    public void run(){
  
        InetAddress group = null;
         try {
            group = InetAddress.getByName("FF02::1");
            MulticastSocket s = null;
            s = new MulticastSocket();
            s.joinGroup(group);
            byte[] aEnviar= new String("Hello" ).getBytes();
            DatagramPacket p= new DatagramPacket(aEnviar,aEnviar.length,group,9999); 
            s.send(p); 
            s.leaveGroup(group);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Adhoccliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}


