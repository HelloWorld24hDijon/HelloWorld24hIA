/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

/**
 *
 * @author emilien
 */
public abstract class Personnage {
    private Case saCase;
    
    public Personnage(){
        this.saCase= null;
    }
    
    public void setCase(Case ca){
        this.saCase=ca;
    } 
    
    public Case getCase() {
        return this.saCase;
    }
    
    public Carte getCarte(){
        return this.saCase.getCarte();
    }
    
    public abstract Type_Personnage getType();
}
