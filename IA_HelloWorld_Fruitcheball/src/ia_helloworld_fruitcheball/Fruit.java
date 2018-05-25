/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

/**
 *
 * @author Alexiane
 */
public abstract class Fruit {
    
    private Case ca ; 
        
    public Fruit (Case ca) {
        this.ca = ca ; 
        
    }
    
    
    public abstract Type_Fruit getType(); 
}
