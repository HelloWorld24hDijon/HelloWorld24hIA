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
public class Fruit_Prune  extends Fruit {

    public Fruit_Prune(Case ca) {
        super(ca);
    }

    @Override
    public Type_Fruit getType() {
        return Type_Fruit.prune ;
    }
    
}
