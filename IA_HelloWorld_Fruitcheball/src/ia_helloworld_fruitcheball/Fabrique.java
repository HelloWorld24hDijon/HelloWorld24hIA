/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

/**
 *
 * @author emili
 */
public class Fabrique {
    
    /*ATTRIBUTS*/
    private static Fabrique instance;
    
    /*CONSTRUCTEUR*/
    private Fabrique(){
        
    }
    /*METHODES*/
    public static Fabrique get(){
        if(instance==null){
            instance=new Fabrique();
        }
        return instance;
    }
}
