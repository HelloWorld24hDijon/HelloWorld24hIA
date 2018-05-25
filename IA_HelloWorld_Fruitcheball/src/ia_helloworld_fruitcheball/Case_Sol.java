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
public class Case_Sol extends Case {

    public Case_Sol(int ligne, int colonne, Carte carte) {
        super(ligne, colonne, carte);
    }

    @Override
    public Type_Case getType() {
        return Type_Case.sol;
    }

    @Override
    public boolean franchissable() {
        return true;
    }
    
}
