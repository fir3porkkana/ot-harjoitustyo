/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author tiera
 */
public class Logic {
    private int[][] taulu;
    
    public Logic() {
        taulu = new int[2][2];
        taulu[1][1] = 100;
    }

    public int[][] getTaulu() {
        return taulu;
    }
    
    
    
}
