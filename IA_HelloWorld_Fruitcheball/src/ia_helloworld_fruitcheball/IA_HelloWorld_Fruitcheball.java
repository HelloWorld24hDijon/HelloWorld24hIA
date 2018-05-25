/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
       
        Graph g = new Graph(c);
        c.getGraph(g);
        c.genererGrapheSimple();
        p.getCooNosPerso();
        p.getNotreZone();
        p.getPosEnnemi();
        p.getFruitPossede();
        p.getScoreNotreEquipe();

        //System.out.println(g.getVertex("1/1"));
        
        Dijkstra d = new Dijkstra(g);
        
        d.calcul(g.getVertex("1/1"), g.getVertex("3/3"));

        for(Vertex v : d.getPath()) {
                System.out.println(v.getCoordinates());
            }
        
        IA ia = new IA(c, g, p);
        ia.ordresPersos();

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
            PrintStream ps = new PrintStream(s.getOutputStream());            
            InputStream is = s.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rd = new BufferedReader(ir);
                        
            //DEFINE PLAYER INSTRUCTION HERE
            ps.println("Hello World");
            String msgSrv = rd.readLine();
            System.out.println("first :" + msgSrv);
            
            int iteration = 0;

            while(!msgSrv.equals("FIN")){
                if(msgSrv.equals("FIN")){
                    break;
                }
                msgSrv = rd.readLine();
                System.out.println("*** iteration " +iteration+" ***");
                System.out.println("<< recoit <<" + msgSrv);
                String msgClient = "S-S-E";
                ps.println(msgClient);
                System.out.println(">> envoie >>" + msgClient);
                ps.flush();
                iteration++;
            }
            System.out.println("Server disconnected");
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        */
    }  
}
