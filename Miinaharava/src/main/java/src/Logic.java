/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Random;

/**
 *
 * @author tiera
 */
public class Logic {
    private int[][] mines;
    private int[][] neighbours;
    private boolean[][] revealed;
    private boolean[][] flagged;
    
    Random rand = new Random();
    
    public Logic() {
        mines = new int[2][2];
        mines[1][1] = 100;
    }

    public int[][] getMines() {
        return mines;
    }
    
    
    
}
