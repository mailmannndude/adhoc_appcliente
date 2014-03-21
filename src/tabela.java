/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuno
 */
public class tabela {
    String nome;
    String vizinho;
    String ipv6;
    
    tabela(String nome,String vizinho,String ipv6){
        this.nome = nome;
        this.vizinho = vizinho;
        this.ipv6 = ipv6;
    }
    
    public String getIp(){return this.ipv6;}
    public String getVizinho(){return this.vizinho;}
    public String getNome(){return this.nome;}
    

    
   public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(nome + "\t" + vizinho + " \t" + ipv6);
        return s.toString();
    }
    
    
}
