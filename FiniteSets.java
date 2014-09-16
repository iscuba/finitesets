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
public interface FiniteSets {
    
    public FiniteSets empty();
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(int elt);
    public FiniteSets add(int elt);
    public FiniteSets remove(int elt);
    public FiniteSets union(BST u);
    public FiniteSets inter(BST u);
    public FiniteSets diff(BST u);
    public boolean equal(BST u);
    public boolean subset(BST u);
    
}
