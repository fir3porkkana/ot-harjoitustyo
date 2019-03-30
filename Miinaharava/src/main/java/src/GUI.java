/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.*; 
import java.util.*;
import java.awt.*;

public class GUI extends JFrame {
    
    public GUI() {
        this.setTitle("Miinaharava");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        
        Board board = new Board();
        this.setContentPane(board);
    }
    
    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, 1288, 800); 
       }
    }
    
}
