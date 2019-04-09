/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame {

    private int spacing = 3;
    
    public int mx = -10;
    public int my = -10;

    public GUI() {
        this.setTitle("Miinaharava");
        this.setSize(911, 590);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Board board = new Board();
        this.setContentPane(board);

        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);
    }

    public class Board extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 920, 590);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    g.setColor(Color.MAGENTA);
                    int botX = i * 56 + 3 * spacing;
                    int topX = i * 56 + 56 + spacing;
                    int botY = j * 56 + 56 + 3*spacing;
                    int topY = j * 56 + 56*2 + spacing;
                    if (mx >= botX && mx <= topX && my >= botY && my <= topY) {
                        g.setColor(Color.CYAN);
                    }
                    g.fillRect(3 * spacing + i * 56, spacing + j * 56 + 32, 56 - 2 * spacing, 56 - 2 * spacing);
                }
            }
        }
    }

    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent me) {

        }

        @Override
        public void mouseMoved(MouseEvent me) {
//            System.out.println("mouse was moved");
            mx = me.getX();
            my = me.getY();
//            System.out.println("x: " + mx + " ,y: " + my);
        }

    }

    public class Click implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            System.out.println("mouse was clicked");
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }

}
