/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author emilie
 */
public class Aleatoire {
    
    public Aleatoire(){
        
    }
    
    
    public void aleatoire(){
        String s =""; 
        int i = (int) random(6);
        
        switch(i){
            case 0 : s="N";
            case 1 : s="S"; 
            case 2 : s="E"; 
            case 3: s="O"; 
            case 4 : s="X"; 
            case 5 : s="P" ; 
            default : s+="-";break;
            
        }
        
         switch(i){
            case 0 : s="N";
            case 1 : s="S"; 
            case 2 : s="E"; 
            case 3: s="O"; 
            case 4 : s="X"; 
            case 5 : s="P" ; 
            default : s+="-";break;
         }
         
         switch(i){
            case 0 : s="N";
            case 1 : s="S"; 
            case 2 : s="E"; 
            case 3: s="O"; 
            case 4 : s="X"; 
            case 5 : s="P" ; 
            default : s+="\n";break;
        }
        
        
    }
    
    
}
