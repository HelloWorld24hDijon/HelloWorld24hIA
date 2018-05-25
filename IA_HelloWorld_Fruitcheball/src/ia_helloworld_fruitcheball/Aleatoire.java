/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author emilie
 */
public class Aleatoire {
    
    public Aleatoire(){
        
    }
    
    
    public String aleatoire(){
        String s ="";
        Random rand = new Random();
        int i = rand.nextInt(6) + 0;
        switch(i){
            case 0 : s="N"; break;
            case 1 : s="S"; break;
            case 2 : s="E"; break;
            case 3: s="O"; break;
            case 4 : s="X"; break;
            case 5 : s="P" ; break;
            
        }
        
        i = rand.nextInt(6) + 0;
        s+="-";
        
         switch(i){
            case 0 : s+="N";break;
            case 1 : s+="S"; break;
            case 2 : s+="E"; break;
            case 3: s+="O"; break;
            case 4 : s+="X"; break;
            case 5 : s+="P" ; break;
         }
         
         i = rand.nextInt(6) + 0;
         s+="-";
         
         switch(i){
            case 0 : s+="N";break;
            case 1 : s+="S"; break;
            case 2 : s+="E"; break;
            case 3: s+="O"; break;
            case 4 : s+="X"; break;
            case 5 : s+="P" ; break;
        }
        
        return s+="\n";
    }
    
    
}
