/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finitesets;

/**
 *
 * @author Isabella
 */
public class Leaf implements FiniteSets{
    
    public Leaf(){
    }
    
    public FiniteSets empty(){
        return new Leaf();
    }
    
    public int cardinality(){
        return 0;
    }

    
    public boolean isEmptyHuh(){
        return true;
    }
    public boolean member(int elt){
        return false;
    }
    public FiniteSets add(int elt){
        return BSTNode(new Leaf(), elt, new Leaf());
    }
    public FiniteSets remove(int elt){
        return new Leaf();
    }
    public FiniteSets union(BST u){
        
    }
    public FiniteSets inter(BST u);
    public FiniteSets diff(BST u);
    public boolean equal(BST u);
    public boolean subset(BST u);
    
}
