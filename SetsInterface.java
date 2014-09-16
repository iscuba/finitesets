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
public interface SetsInterface {
    public BST empty();
    public int cardinality(BST t);
    public boolean isEmptyHuh(BST t);
    public boolean member(BST t, int elt);
    public BST add(BST t, int elt);
    public BST remove(BST t, int elt);
    public BST union(BST t, BST u);
    public BST inter(BST t, BST u);
    public BST diff(BST t, BST u);
    public boolean equal(BST t, BST u);
    public boolean subset(BST t, BST u);  
}
