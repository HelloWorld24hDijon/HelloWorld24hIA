/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author aurian
 */
public class IA_HelloWorld_Fruitcheball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Carte c = new Carte();
        Parseur p = new Parseur("", c);
        p.creer_carte();
        p.getCooNosPerso();
        /*
        InetAddress adresseIP;
        
        try{            
            String temp = "127.0.0.1";            
            byte[] tableIP = new byte[4];            
            char ch = temp.charAt(0);
            
            int i = 0;
            String chaineIP = "";
            while(ch != '.'){                
                i++;
                chaineIP = chaineIP + ch;
                
                ch = temp.charAt(i);
            }
            
            tableIP[0] = (byte)Integer.parseInt(chaineIP);
            chaineIP ="";
            i++;
            ch = temp.charAt(i);
            
            while(ch != '.'){
                i++;
                chaineIP = chaineIP + ch;
                ch = temp.charAt(i);
            }
            tableIP[1] = (byte)Integer.parseInt(chaineIP);
            chaineIP ="";
            i++;
            ch = temp.charAt(i);
            
            while(ch != '.'){
                i++;
                chaineIP = chaineIP + ch;
                ch = temp.charAt(i);
            }
            
            tableIP[2] = (byte)Integer.parseInt(chaineIP);
            chaineIP ="";
            
            i++;
            ch = temp.charAt(i);
            
            while(ch != '.' && i<temp.length()-1){
                i++;
                chaineIP = chaineIP + ch;
                ch = temp.charAt(i);
            }
            chaineIP = chaineIP + temp.charAt(temp.length()-1);
            tableIP[3] = (byte)Integer.parseInt(chaineIP);
            
            adresseIP = InetAddress.getByAddress(tableIP);
            InetSocketAddress serveurAdresse = new InetSocketAddress(adresseIP, 1337);

            //Création du socket avec l'adresse locale et le port
            System.out.println(adresseIP.getHostAddress());
            java.net.Socket s = new java.net.Socket(adresseIP,1337);             
            
            //PARTIE TRAITEMENT DU SOCKET ET ENVOI DES DONNEES            
            Scanner sc1 = new Scanner(s.getInputStream());
            PrintStream p = new PrintStream(s.getOutputStream());
            BufferedReader b =  new BufferedReader(new InputStreamReader (s.getInputStream()));
            
            //DEFINE PLAYER INSTRUCTION HERE
            p.println("Hello World");
            String rec = b.readLine();
            System.out.println(rec);
            while(rec!="FIN"){                
                p.println("S-S-E\n");
            }

            System.out.println();
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }*/
    }
    
}
